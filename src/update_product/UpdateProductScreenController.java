package update_product;

import java.io.IOException;
import java.sql.SQLException;

import common.DBUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import user_management.UserManagement;

public class UpdateProductScreenController {
	
	@FXML
	TextField ProductIdToUpdate;
	
	@FXML
	TextField UpdatedProductID;
	
	@FXML
	TextField UpdatedProductName;
	
	@FXML
	TextField UpdatedProductQuantity;
	
	@FXML
	TextField UpdatedProductPrice;
	
	@FXML
	Button UpdateProductButton;
	
	@FXML
	Button CancleProduct;
	
	@FXML
	Label ProductUpdatedMessage;

	
	public void updateButtonProductClick() {
		String ProductIdField=ProductIdToUpdate.getText();
		String UpdatedProductIdField=UpdatedProductID.getText();
		String UpdatedProductNameField=UpdatedProductName.getText();
		String UpdatedProductQuantityField=UpdatedProductQuantity.getText();
		String UpdatedProductPriceField=UpdatedProductPrice.getText();
		
		if (ProductIdField.isEmpty() || UpdatedProductIdField.isEmpty() || UpdatedProductNameField.isEmpty() || UpdatedProductQuantityField.isEmpty() || UpdatedProductPriceField.isEmpty()) {
            ProductUpdatedMessage.setText("Please fill in all fields.");
            ProductUpdatedMessage.setTextFill(Color.RED);
            return;
        }
		
		if (updateProductInDb(Integer.parseInt(ProductIdField), Integer.parseInt(UpdatedProductIdField), UpdatedProductNameField, Integer.parseInt(UpdatedProductQuantityField), Integer.parseInt(UpdatedProductPriceField))) {

            ProductUpdatedMessage.setText("Failed to update product!!");
            ProductUpdatedMessage.setTextFill(Color.RED);
            clearFields();
        } else {

            ProductUpdatedMessage.setText("Product updated successfully!!");
            ProductUpdatedMessage.setTextFill(Color.GREEN);
            clearFields();
        }
	}
	
	private void clearFields() {
        ProductIdToUpdate.clear();
        UpdatedProductID.clear();
        UpdatedProductName.clear();
        UpdatedProductQuantity.clear();
        UpdatedProductPrice.clear();
    }
	public void cancelButtonClick() throws IOException {
		new UserManagement().show();
     }

	
	public boolean updateProductInDb(int productId, int updatedProductId, String updatedProductName, int updatedProductQuantity, int updatedProductPrice) {
        String query = "UPDATE product SET product_id = '" + updatedProductId + "', name = '" + updatedProductName + "', quantity = '" + updatedProductQuantity + "', price = '" + updatedProductPrice + "' WHERE product_id = '" + productId + "'";

        boolean isUpdated = false;
        try {
            isUpdated = DBUtils.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }
	
}
