package mainpkg;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class MainController implements Initializable {
    @FXML
    private TextField Pricetextfield;
    @FXML
    private TableView<cartitem> itemTableView;
    @FXML
    private TableColumn<cartitem, String> productColumn;
    @FXML
    private TableColumn<cartitem, Float> priceColumn;
    @FXML
    private TableColumn<cartitem, Float> vatColumn;
    @FXML
    private TableColumn<cartitem, Integer> quantityColumn;
    @FXML
    private TableColumn<cartitem, Float> totalColumn;
    @FXML
    private Button savebuttonon;
    @FXML
    private TextField PreDefVATtextfield;
    @FXML
    private ComboBox<String> SelectproductCombobox;
    @FXML
    private ComboBox<Integer> QuantityBox;
    @FXML
    private ComboBox<Integer> vatConsiderComboBox;
    @FXML
    private TextField costBoundTextFeild;
    @FXML
    private Button CalculateVAT;
    @FXML
    private TableColumn<String, String> totalbillColumn1;
    @FXML
    private Button CheckoutButton;
    @FXML
    private TextArea DisplayVattextarea;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SelectproductCombobox.getItems().addAll("Shampoo", "Soap", "Rice", "Chicken", "Beef", "Mutton",
                "Oats", "Flour", "Milk", "Tang");
        QuantityBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        vatConsiderComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        // Initialize TableView columns
        productColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProduct()));
        priceColumn.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getPrice()).asObject());
        vatColumn.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getPreDefVAT()).asObject());
        quantityColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()).asObject());
        totalColumn.setCellValueFactory(data -> {
            float total = data.getValue().getPrice() * data.getValue().getQuantity();
            return new SimpleFloatProperty(total).asObject();
        });
    }

    @FXML
    private void savebuttononclick(ActionEvent event) {
        float price = Float.parseFloat(Pricetextfield.getText());
        float preDefVAT = Float.parseFloat(PreDefVATtextfield.getText());
        String product = SelectproductCombobox.getValue();
        int quantity = QuantityBox.getValue();
        cartitem item = new cartitem(price, preDefVAT, product, quantity);

        itemTableView.getItems().add(item);
    }

    @FXML
    private void CheckoutButtonOnClick(ActionEvent event) {
        float totalBill = 0;
        for (cartitem item : itemTableView.getItems()) {
            totalBill += item.getPrice() * item.getQuantity();
        }
        totalbillColumn1.setText("Total Bill: " + totalBill);

        // Update data in Product Details.txt after CheckoutButtonOnClick
        FileHandler.updateProductDetails(getItemListAsString());
        BinaryFileHandler.updateProductDetails(getItemListAsString());
    }

    

    // Helper method to get the list of items as a formatted string
    private String getItemListAsString() {
        StringBuilder itemList = new StringBuilder();
        for (cartitem item : itemTableView.getItems()) {
            itemList.append(item.getProduct()).append(" - Price: ").append(item.getPrice())
                    .append(" - Taka ").append(item.getProduct()).append(" - VAT: ").append(item.getPreDefVAT())
                    .append("%").append(", Quantity: ").append(item.getQuantity())
                    .append(", Total: ").append(item.getPrice() * item.getQuantity()).append(" - Taka ").append("\n");
        }
        return itemList.toString();
    }

    

    @FXML
    private void CalculateVatOnClick(ActionEvent event) {
        float totalVAT = 0;
        String selectedProducts = totalbillColumn1.getText(); // Assuming the selected products are displayed in displaytextfield
        float priceRange = Float.parseFloat(costBoundTextFeild.getText());
        float percentageRange = vatConsiderComboBox.getValue();

        StringBuilder vatDetails = new StringBuilder(); // StringBuilder to store the VAT details
        boolean hasInvalidVAT = false; // Flag to track if there is any invalid VAT

        for (cartitem item : itemTableView.getItems()) {
            if (selectedProducts.contains(item.getProduct())) {
                vatDetails.append("Product: ").append(item.getProduct())
                        .append(", Price: ").append(item.getPrice())
                        .append(", Quantity: ").append(item.getQuantity());

                if (item.getPrice() <= priceRange) {
                    vatDetails.append(", Price within range");
                } else {
                    vatDetails.append(", Price outside range");
                }

                if (item.getPreDefVAT() <= percentageRange) {
                    vatDetails.append(", VAT within range");
                } else {
                    vatDetails.append(", Invalid VAT");
                    hasInvalidVAT = true; // Set the flag to indicate an invalid VAT is found
                }

                vatDetails.append("\n");

                totalVAT += item.getPrice() * item.getQuantity() * item.getPreDefVAT() / 100;
                
            }
        }

        if (hasInvalidVAT) {
            DisplayVattextarea.setText("Error:  Selected VAT Crieteria not met!.\nTotal VAT: " + totalVAT);
        } else {
            DisplayVattextarea.setText(vatDetails.toString() + "Total VAT: " + totalVAT);    
        }
        // Update data in VAT Details.txt after CalculateVatOnClick
        FileHandler.updateVATDetails(DisplayVattextarea.getText());
        BinaryFileHandler.updateVATDetails(DisplayVattextarea.getText());
    }
}

    