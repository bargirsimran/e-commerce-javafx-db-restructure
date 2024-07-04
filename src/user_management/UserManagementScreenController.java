package user_management;

import java.io.IOException;
import add_user.AddUserScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import update_user.UpdateUser;

public class UserManagementScreenController {
	
	@FXML
	Button AddUser;
	
	@FXML
	Button EditUser;
	
	@FXML
	Button SearchUser;
	
	@FXML
	Button ViewUser;
	
	@FXML
	Button deleteUser;
	
	@FXML
	Button ExitButton;
	
	public void addUser() throws IOException {
		new AddUserScreen().show();
	}
	public void updateUser() throws IOException {
		new UpdateUser().show();
	}
}
