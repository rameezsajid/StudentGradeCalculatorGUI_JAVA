package application;

import controller.StudentProfileController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.StudentProfile;
import view.StudentProfileRootPane;

public class Main extends Application {

	private StudentProfileRootPane view;
	private StudentProfile model;
	
	@Override
	public void init() {
		
		view = new StudentProfileRootPane();
		view.setMaxWidth(700);
	    view.setMinSize(200, 200);
		model = new StudentProfile();
		new StudentProfileController(view, model);
		
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Student Profile");
		Scene scene = new Scene(view);
		scene.getStylesheets().add(this.getClass().getResource("myStyle.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
