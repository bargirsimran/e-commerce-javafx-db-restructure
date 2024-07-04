package login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.DBUtils;
import home.HomeScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;

public class LoginScreenController {
	@FXML
	javafx.scene.control.TextField username;
	
	@FXML
	PasswordField password;
	
	@FXML
	Label errorMessage;
	
	public void loginButtonClick() throws SQLException, IOException {
		
		String userFromDB=username.getText();
		String passwordFromDB=password.getText();
		
		if(validateLogin(userFromDB, passwordFromDB)) {
			System.out.println("Login Successfully!!");
			errorMessage.setText("Login Sucess!!");
			errorMessage.setTextFill(Color.GREEN);
			HomeScreen homeScreen = new HomeScreen();
			homeScreen.show();
		}
		else {
			System.out.println("Login Failed!!");
			errorMessage.setText("Login Failed!!");
			errorMessage.setTextFill(Color.RED);
		}
	}
	public boolean validateLogin(String username, String password) throws SQLException {
		String query="SELECT username, password FROM user WHERE username='"+username+"'AND password= '"+password+"'";
		
		ResultSet result=DBUtils.executeSelectQuery(query);
		return result.next();
		
	}
}
