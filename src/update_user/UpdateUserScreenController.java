package update_user;

import java.io.IOException;
import java.sql.SQLException;

import common.DBUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import user_management.UserManagement;

public class UpdateUserScreenController {
	
	@FXML
	TextField UserIdToUpdate;
	
	@FXML
	TextField UpdatedUserID;
	
	@FXML
	TextField UpdatedUserName;
	
	@FXML
	TextField UpdatedEmail;
	
	@FXML
	TextField UpdatedAddress;
	
	@FXML
	TextField UpdatedPassword;
	
	@FXML
	TextField UpdatedUsername;
	
	@FXML
	Label UpdatedUserMsg;
	
	@FXML
	Button UpdateUserButton;
	
	@FXML
	Button CancleProduct;
	
	public void updateUserButtonClick() {
        String userIdField = UserIdToUpdate.getText();
        String updatedUserIdField = UpdatedUserID.getText();
        String updatedUserNameField = UpdatedUserName.getText();
        String updatedEmailField = UpdatedEmail.getText();
        String updatedAddressField = UpdatedAddress.getText();
        String updatedPasswordField = UpdatedPassword.getText();
        String updatedUsernameField = UpdatedUsername.getText();
        
        if (userIdField.isEmpty() || updatedUserIdField.isEmpty() || updatedUserNameField.isEmpty() || updatedEmailField.isEmpty() || updatedAddressField.isEmpty() || updatedPasswordField.isEmpty() || updatedUsernameField.isEmpty()) {
            UpdatedUserMsg.setText("Please fill in all fields.");
            UpdatedUserMsg.setTextFill(Color.RED);
            return;
        }
        
        if (updateUserInDb(Integer.parseInt(userIdField), Integer.parseInt(updatedUserIdField), updatedUserNameField, updatedEmailField, updatedAddressField, updatedPasswordField, updatedUsernameField)) {
            UpdatedUserMsg.setText("Failed to update user!!");
            UpdatedUserMsg.setTextFill(Color.RED);
            clearFields();
        } else {
            UpdatedUserMsg.setText("User updated successfully!!");
            UpdatedUserMsg.setTextFill(Color.GREEN);
            clearFields();
        }
    }
    
    private void clearFields() {
        UserIdToUpdate.clear();
        UpdatedUserID.clear();
        UpdatedUserName.clear();
        UpdatedEmail.clear();
        UpdatedAddress.clear();
        UpdatedPassword.clear();
        UpdatedUsername.clear();
    }

    @FXML
    public void cancelButtonClick() throws IOException {
        
        new UserManagement().show();
    }

    public boolean updateUserInDb(int userId, int updatedUserId, String updatedUserName, String updatedEmail, String updatedAddress, String updatedPassword, String updatedUsername) {
        String query = "UPDATE user SET user_id = '" + updatedUserId + "', name = '" + updatedUserName + "', email = '" + updatedEmail + "', address = '" + updatedAddress + "', password = '" + updatedPassword + "', username = '" + updatedUsername + "' WHERE user_id = '" + userId + "'";
        
        boolean isUpdated = false;
        try {
            isUpdated = DBUtils.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }
	
	
}
