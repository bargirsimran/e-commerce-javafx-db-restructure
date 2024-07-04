package add_user;

import java.io.IOException;
import java.sql.SQLException;
import common.DBUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AddUserScreenController {
	@FXML
	TextField UserId;
	
	@FXML
	TextField UserName;
	
	@FXML
	TextField UserEmail;
	
	@FXML
	TextField UserAddress;
	
	@FXML
	TextField Username;
	
	@FXML
	PasswordField userPassword;
	
	@FXML
	Button AddUser;
	
	@FXML
	Button BackButton;
	
	@FXML
	Label UserAddedMessage;
	
	 public void addButtonUserClick() {
	        String userIdField = UserId.getText();
	        String userNameField = UserName.getText();
	        String userEmailField = UserEmail.getText();
	        String userAddressField = UserAddress.getText();
	        String usernameField = Username.getText();
	        String userPasswordField = userPassword.getText();
	        
	        if (userIdField.isEmpty() || userNameField.isEmpty() || userEmailField.isEmpty() || userAddressField.isEmpty() || usernameField.isEmpty() || userPasswordField.isEmpty()) {
	            UserAddedMessage.setText("Please fill in all fields.");
	            UserAddedMessage.setTextFill(Color.RED);
	            return;
	        }
	        
	        if(addUserIntoDb(Integer.parseInt(userIdField), userNameField, userEmailField, userAddressField, usernameField, userPasswordField)){ 
	            UserAddedMessage.setText("Failed to add user!!");
	            UserAddedMessage.setTextFill(Color.RED);
	        } else {
	            UserAddedMessage.setText("User Added Successfully!!");
	            UserAddedMessage.setTextFill(Color.GREEN);
	            clearFields();
	        }
	    }
	    
	    public void backButtonClick() throws IOException {
	       // UserScreenViewer.show();
	    }
	    
	    private void clearFields() {
	        UserId.clear();
	        UserName.clear();
	        UserEmail.clear();
	        UserAddress.clear();
	        Username.clear();
	        userPassword.clear();
	    }

	    public boolean addUserIntoDb(int userId, String userName, String userEmail, String userAddress, String username, String userPassword) {
	        String query = "INSERT INTO user (user_id, name, email, address, username, password) VALUES ('" + userId + "', '" + userName + "', '" + userEmail + "', '" + userAddress + "', '" + username + "', '" + userPassword + "')";
	        
	        boolean isInserted = false;
	        try {
	            isInserted = DBUtils.executeQuery(query);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return isInserted;
	    }
	
}
