
package add_product;

import java.io.IOException;
import java.sql.SQLException;

import common.DBUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AddProductScreenController {
	
	@FXML
	TextField ProductId;
	
	@FXML
	TextField ProductName;
	
	@FXML
	TextField ProductPrice;
	
	@FXML
	TextField ProductQuantity;
	
	@FXML
	Button BackButton;
	
	@FXML
	Button AddProduct;
	
	@FXML
	Label ProductAddedMessage;
	
	public void addButtonProductClick() {
		String ProductIdField=ProductId.getText();
		String productNameField = ProductName.getText();
        String productPriceField = ProductPrice.getText();
        String productQuantityField = ProductQuantity.getText();
        
        if (productNameField.isEmpty() || productPriceField.isEmpty() || ProductIdField.isEmpty() || productQuantityField.isEmpty()) {
            ProductAddedMessage.setText("Please fill in all fields.");
            ProductAddedMessage.setTextFill(Color.RED);
            return;
        }
        
		if(addProductIntoDb(Integer.parseInt(ProductIdField),productNameField,Integer.parseInt(productQuantityField),Integer.parseInt(productPriceField))){ 
			ProductAddedMessage.setText("Failed to add product!!");
			ProductAddedMessage.setTextFill(Color.RED);
		}
		else {

			ProductAddedMessage.setText("Product Added Sucessfully!!");
			ProductAddedMessage.setTextFill(Color.GREEN);
		      clearFields();
		}
	}
	
	public void backButtonClick() throws IOException {
		//new 
	}
	
	private void clearFields() {
	    ProductId.clear();
	    ProductName.clear();
	    ProductPrice.clear();
	    ProductQuantity.clear();
	}

	public boolean addProductIntoDb(int productId, String productName, int productQuantity, int productPrice) {
        String query = "INSERT INTO product (product_id, name, quantity, price) VALUES ('" + productId + "', '" + productName + "', '" + productQuantity + "', '" + productPrice + "')";
        
        boolean isInserted = false;
        try {
            isInserted = DBUtils.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isInserted;
    }
}
