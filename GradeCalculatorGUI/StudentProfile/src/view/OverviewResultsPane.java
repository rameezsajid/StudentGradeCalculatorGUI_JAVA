package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;



public class OverviewResultsPane extends GridPane {

	private TextArea results;
	private Button btnSaveOverview;

	public OverviewResultsPane() {
		
		this.setPadding(new Insets(80, 80, 80, 80));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		results = new TextArea("Results will appear here...");
		
		btnSaveOverview = new Button("Save Overview");
		
		this.add(results, 0, 0);
		
		this.add(btnSaveOverview, 0, 1);

		results.setEditable(false);
		this.setPadding(new Insets(40, 40, 40, 40));
		results.setWrapText(true);

	}

	public void addSaveOverviewHandler(EventHandler<ActionEvent> handler) {
		btnSaveOverview.setOnAction(handler);
	}
	
	public void setResults(String overview) {
		results.setText(overview);
	}
	
	public void setColor(String colour) {
		this.setStyle("-fx-background-color: " + colour + ";");
	}

	public String getResult() {
		return results.getText();
	}
	
	public void setResult(String text) {
		results.setText(text);
	}
	
}
