package ecommerce;

import java.io.IOException;

import common.StageHolder;
import javafx.application.Application;
import javafx.stage.Stage;
import login.LoginScreen;

public class EcommerceMain extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	
	public void start(Stage stageCreatedByJavaFx) throws IOException {
		StageHolder.stage=stageCreatedByJavaFx;
		StageHolder.stage.setTitle("E-commerce Application");
		new LoginScreen().show();
	}
	
}
