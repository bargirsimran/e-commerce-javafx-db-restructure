package product_management;

import java.io.IOException;

import add_product.AddProductScreen;
import add_user.AddUserScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import update_product.UpdateProduct;
 
public class ProductManagementScreenController {
	
	@FXML
	Button AddProduct;
	
	@FXML
	Button UpdateProduct;
	
	@FXML
	Button SearchProduct;
	
	@FXML
	Button ViewProduct;
	
	@FXML
	Button DeleteProduct;
	
	@FXML
	Button ExitProduct;
	
	public void addProduct() throws IOException {
		new AddProductScreen().show();
	}
	public void updateProduct() throws IOException {
		new UpdateProduct().show();
	}

}
