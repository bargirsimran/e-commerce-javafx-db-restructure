package home;

import java.io.IOException;

import add_user.AddUserScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import product_management.ProductManagement;
import user_management.UserManagement;

public class HomeScreenController {
	@FXML
	Button ProductId;
	
	@FXML
	Button UserId;
	
	@FXML
	Button LogOut;

	public void addProductButtonClick() throws IOException {
		System.out.println("Add Product Button");
		new ProductManagement().show();
		
	}
	
	public void addUserButtonClick() throws IOException {
		System.out.println("Add User Button");
		new UserManagement().show();
	}
	
	
	public void logOutButtonClick() {
		System.out.println("Logout Successfully!!");
		
		//LogoutController.show();
		
	}
}
