package common;

import javafx.stage.*;

public class StageHolder {
	public static Stage stage;
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void setStage(Stage stage) {
		StageHolder.stage=stage;
	}
}
