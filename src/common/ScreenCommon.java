package common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ScreenCommon {
	
	public void show() throws IOException {
		String myClassName = getClass().getSimpleName();
		
		String classFilePath = getClass().getResource(myClassName + ".class").toString();
		
		String fxmlFilePath = classFilePath.replace(".class", ".fxml");
		
		String actualPath = fxmlFilePath.substring(8);
		
		URL fxmlUrl;
		try {
			fxmlUrl=Paths.get(actualPath).toUri().toURL();
			
			Parent actorGroup=FXMLLoader.load(fxmlUrl);
			
			if (fxmlUrl == null) {
	            throw new IOException("FXML file not found: " + fxmlFilePath);
	        }
			Scene scene=new Scene(actorGroup, 650, 500);
			StageHolder.stage.setScene(scene);
			StageHolder.stage.show();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}


