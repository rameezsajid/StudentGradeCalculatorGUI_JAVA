package view;

import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Course;



public class CreateProfilePane extends GridPane {

	private ComboBox<Course> cboCourses;
	private TextField txtSurname, txtFirstName, pNumber, txtEmail;
	private Button btnCreate;
	private DatePicker dp = new DatePicker();
	LocalDate ld;


	public CreateProfilePane() {
		
		this.setPadding(new Insets(80, 80, 80, 80));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		//create labels
		Label lblTitle = new Label("Select Course: ");
		Label lblFirstName = new Label("First name: ");
		Label lblSurname = new Label("Surname: ");
		Label lblNumber = new Label("p Number: ");
		Label lblEmail = new Label ("Email: ");
		Label lblDate = new Label ("Date: ");

		// setup combo box
		cboCourses = new ComboBox<Course>();

		//setup text fields
		txtFirstName = new TextField();
		txtSurname = new TextField();
		pNumber = new TextField();
		txtEmail = new TextField();

		
		
		//Create Profile Button
		btnCreate = new Button("Create Profile");

		//add controls and labels to container
		this.add(lblTitle, 0, 0);
		this.add(cboCourses, 1, 0);

		this.add(lblFirstName, 0, 1);
		this.add(txtFirstName, 1, 1);

		this.add(lblSurname, 0, 2);
		this.add(txtSurname, 1, 2);
		
		this.add(lblNumber, 0, 3);
		this.add(pNumber, 1, 3);
		
		this.add(lblEmail, 0, 4);
		this.add(txtEmail, 1, 4);
		
		this.add(lblDate, 0, 5);
		this.add(dp, 1, 5);
		
		this.add(new HBox(), 0, 6);
		this.add(btnCreate, 1, 6);
	}
	
	
	public void populateComboBox(Course[] courses) {
		cboCourses.getItems().addAll(courses);
		cboCourses.getSelectionModel().select(0);
		}

	
	public Course getSelectedCourse() {
		return cboCourses.getSelectionModel().getSelectedItem();
	}
	
	public String getFirstNameInput() {
		return txtFirstName.getText();
	}
	
	public String getLastNameInput() {
		return txtSurname.getText();
	}
	
	public String getPnumber(){
		return pNumber.getText();
	}
	
	public String getEmail(){
		return txtEmail.getText();
	}

	public LocalDate getDate(){
		dp.setOnAction(e -> {
			ld = dp.getValue();
		});
		return ld; 
	}
	
	
	
	
	public void addCreateHandler(EventHandler<ActionEvent> handler) {
		btnCreate.setOnAction(handler);
	}
	
	
	
	public String getInputAreaText() {
		
		return txtFirstName.getText();
	}

	public void setInputAreaText(String text) {
		txtFirstName.setText(text);
	}
	
	public String getLastName(){
		return txtSurname.getText();
	}
	
	public void setLastName(String text){
		txtSurname.setText(text);
	}
	
	
	public void setOutputAreaText(String text) {
		txtFirstName.setText(text);
	}
	
}
