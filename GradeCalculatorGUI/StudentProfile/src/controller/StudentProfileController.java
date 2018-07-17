package controller;

import model.Course;

import model.Module;
import model.Name;
import model.StudentProfile;
import view.AddMarksPane;
import view.CreateProfilePane;
import view.MenuPane;
import view.OverviewResultsPane;
import view.StudentProfileRootPane;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import javafx.event.ActionEvent;


public class StudentProfileController {
	
	
	// Fields
	private StudentProfileRootPane view;
	private OverviewResultsPane orp;
	private CreateProfilePane cpp;
	private AddMarksPane amp;
	private StudentProfile model;
	private MenuPane mb;
	
		
	
	public StudentProfileController(StudentProfileRootPane view, StudentProfile model) {
		
		
		this.view = view;
		this.model = model;
		cpp = view.getCreateProfilePane();
		orp = view.getOverviewResultsPane();
		amp = view.getAddMarksPane();
		mb = view.getMenuPane();
		
		cpp.populateComboBox(setupAndGetCourses());

		
		this.attachEventHandlers();	
		
		

	}
	
	private Course[] setupAndGetCourses() {
		Module ctec2121 = new Module("CTEC2121", "Organisations, Project Management and Research", true);
		Module ctec2122 = new Module("CTEC2122", "Forensics and Security", false);
		Module ctec2602 = new Module("CTEC2602", "OO Software Design and Development", false);
		Module ctec2701 = new Module("CTEC2701", "Multi-tier Web Applications", true);
		Module ctec2901 = new Module("CTEC2901", "Data Structures and Algorithms", false);
		Module lawg2003 = new Module("LAWG2003", "Issues in Criminal Justice", false);
		Module ctec2903 = new Module("CTEC2903", "System Defence Strategies", true);
		Course compSci = new Course("Computer Science");
		compSci.addModule(ctec2121);
		compSci.addModule(ctec2602);
		compSci.addModule(ctec2701);
		compSci.addModule(ctec2901);
		Course softEng = new Course("Software Engineering");
		softEng.addModule(ctec2121);
		softEng.addModule(ctec2602);
		softEng.addModule(ctec2701);
		softEng.addModule(ctec2901);
		Course compSecu = new Course("Computer Security");
		compSecu.addModule(ctec2121);
		compSecu.addModule(ctec2122);
		compSecu.addModule(ctec2701);
		compSecu.addModule(ctec2903);
		Course forenComp = new Course("Forensic Computing");
		forenComp.addModule(ctec2121);
		forenComp.addModule(ctec2122);
		forenComp.addModule(ctec2701);
		forenComp.addModule(lawg2003);
		Course[] courses = new Course[4];
		courses[0] = compSci;
		courses[1] = softEng;
		courses[2] = compSecu;
		courses[3] = forenComp;
		return courses;
		}
	

	private void attachEventHandlers() {
		cpp.addCreateHandler(new CreateProfileHandler()); //attaches button handler
		mb.addAboutHandler(new AboutHandler());
		mb.addLoadHandler(new LoadHandler());
		mb.addSaveHandler(new SaveHandler());
		amp.addClearHandler(new ClearHandler());
		amp.addSubmitHandler(new SubmitHandler());
		orp.addSaveOverviewHandler(new OverviewResultsHandler());		
	}
	
	
		private class SaveHandler implements EventHandler<ActionEvent> {

			public void handle(ActionEvent e) {
				FileChooser fileChooser = new FileChooser();
				File file = fileChooser.showSaveDialog(null);
				if (file != null) {
					try {
						Files.write(Paths.get(file.getPath()), orp.getResult().getBytes());
					} catch (IOException e1) {
						System.out.println("Error saving.");
					}            	
				}
			}
		}
		
		private class LoadHandler implements EventHandler<ActionEvent> {

			public void handle(ActionEvent e) {
				FileChooser fileChooser = new FileChooser();
				File file = fileChooser.showOpenDialog(null);
				if (file != null) {
					try {
						byte[] bytes = Files.readAllBytes(Paths.get(file.getPath()));
						orp.setResult(new String(bytes));
					} catch (IOException e1) {
						System.out.println("Error loading.");
					}            	
				}
			}
		}

		private class AboutHandler implements EventHandler<ActionEvent> {

			public void handle(ActionEvent e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("About");
				alert.setHeaderText(null);
				alert.setContentText("This Program allows users to insert marks and retrieve averages.");
				alert.showAndWait();
			}
		}

		
	
	
	
	private class CreateProfileHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			
			model.setCourse(view.getCreateProfilePane().getSelectedCourse());
			
			Name studentName = new Name(cpp.getFirstNameInput(), cpp.getLastNameInput());
			model.setStudentName(studentName);

			

			model.setpNumber(view.getCreateProfilePane().getPnumber());

			model.setEmail(view.getCreateProfilePane().getEmail());
			
			model.setDate(view.getCreateProfilePane().getDate());
			
			model.getCourse().getModulesOnCourse();

			
			orp.setResults(model.toString());

			view.changeTab(1);
		}
	
	}
	
	private class ClearHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			amp.clear();
		}
	}

	private class SubmitHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			
			
			view.changeTab(2);
			
		}
	
	}
	
	private class OverviewResultsHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
		
			
			
		}
	
	}

		
	
}