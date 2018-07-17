package view;

import javafx.scene.control.Tab;

import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;

public class StudentProfileRootPane extends BorderPane {

	private CreateProfilePane cpp;
	private AddMarksPane amp;
	private OverviewResultsPane orp;
	private MenuPane mb;
	private TabPane tp;
	
	public StudentProfileRootPane() {
		tp = new TabPane();
		
		tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE); //don't allow tabs to be closed
		
		mb = new MenuPane();
		
		cpp = new CreateProfilePane();
		orp = new OverviewResultsPane();
		amp = new AddMarksPane();
	
		Tab t1 = new Tab("Create Profile", cpp);
		Tab t2 = new Tab("Add Marks", amp);
		Tab t3 = new Tab("Overview Results", orp);
		
		tp.getTabs().addAll(t1, t2, t3);
		
		this.setTop(mb);
		this.setCenter(tp);
		
	}

	
	
	public CreateProfilePane getCreateProfilePane() {
		return cpp;
	}
	
	public AddMarksPane getAddMarksPane(){
		return amp;
	}

	public OverviewResultsPane getOverviewResultsPane() {
		return orp;
	}
	
	public MenuPane getMenuPane(){
		return mb;
	}
	
	public void changeTab(int index) {
		tp.getSelectionModel().select(index);
	}
}

