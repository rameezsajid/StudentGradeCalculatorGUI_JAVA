package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class AddMarksPane extends GridPane {

	private TextField txtcourseMark1, txtcourseMark2, txtcourseMark3, txtcourseMark4;
	private TextField txtexamMark1, txtexamMark2, txtexamMark3, txtexamMark4;
	private Button btnClear, btnSubmit;

	public AddMarksPane() {
		//styling
		this.setPadding(new Insets(80, 80, 80, 80));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		//create labels
		Label lblCourse1 = new Label("Module 1");
		Label lblCourse2 = new Label("Module 2");
		Label lblCourse3 = new Label("Module 3");
		Label lblCourse4 = new Label("Module 4");
		Label lblHeading1 = new Label("");
		Label lblHeading2 = new Label("CWK Mark");
		Label lblHeading3 = new Label("Exam Mark");



		//setup text fields
		txtcourseMark1 = new TextField();
		txtcourseMark2 = new TextField();
		txtcourseMark3 = new TextField();
		txtcourseMark4 = new TextField();

		txtexamMark1 = new TextField();
		txtexamMark2 = new TextField();
		txtexamMark3 = new TextField();
		txtexamMark4 = new TextField();

		
		btnClear = new Button("Clear");		
		btnSubmit = new Button("Submit");


		this.add(lblHeading1, 0, 0);
		this.add(lblHeading2, 1, 0);
		this.add(lblHeading3, 2, 0);

		this.add(lblCourse1, 0, 1);
		this.add(txtcourseMark1, 1, 1);
		this.add(txtexamMark1, 2, 1);

		this.add(lblCourse2, 0, 2);
		this.add(txtcourseMark2, 1, 2);
		this.add(txtexamMark2, 2, 2);
		
		this.add(lblCourse3, 0, 3);
		this.add(txtcourseMark3, 1, 3);
		this.add(txtexamMark3, 2, 3);
		
		this.add(lblCourse4, 0, 4);
		this.add(txtcourseMark4, 1, 4);
		this.add(txtexamMark4, 2, 4);
		
		
		this.add(new HBox(), 0, 5);
		this.add(btnClear, 1, 5);
		this.add(btnSubmit, 2, 5);
	}
	
	public void addSubmitHandler(EventHandler<ActionEvent> handler) {
		btnSubmit.setOnAction(handler);
	}
	
	public void addClearHandler(EventHandler<ActionEvent> handler){
		btnClear.setOnAction(handler);
	}
	
	
	
	public void clear() {
		txtcourseMark1.setText("");
		txtcourseMark2.setText("");
		txtcourseMark3.setText("");
		txtcourseMark4.setText("");
		txtexamMark1.setText("");
		txtexamMark2.setText("");
		txtexamMark3.setText("");
		txtexamMark4.setText("");
	}

	public int getCwkMark() {
		return txtcourseMark1.getAnchor();
	}


	

}
