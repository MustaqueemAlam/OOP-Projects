package mainpkg;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
    @FXML
    private TextField Pricetextfield;
    @FXML
    private TextArea displaytextfield;
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
    private TextArea DisplayVattextarea;
    
    //ArrayList:
    private List<cartitem> datalist = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SelectproductCombobox.getItems().addAll("Shampoo", "Soap", "Rice", "Chicken", "Beef", "Mutton",
                "Oats", "Flour", "Milk", "Tang");
        QuantityBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        vatConsiderComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    }

    @FXML
    private void savebuttononclick(ActionEvent event) {
        float Price = Float.parseFloat(Pricetextfield.getText());
        float PreDefVAT = Float.parseFloat(PreDefVATtextfield.getText());
        String Selectproduct = SelectproductCombobox.getValue();
        int Quantity = QuantityBox.getValue();
        cartitem item = new cartitem(Price, PreDefVAT, Selectproduct, Quantity);
        datalist.add(item);

        displaytextfield.appendText(item.getSelectproduct() + " - Price: " + item.getPrice() + " - Taka " + item.getSelectproduct()
                + " - VAT: " + item.getPreDefVAT() + "%" + ", Quantity: " + item.getQuantity() + ", Total: "
                + (item.getPrice() * item.getQuantity()) + " - Taka " + "\n");
    }

    @FXML
    private void CheckoutButtonOnClick(ActionEvent event) {
        float totalBill = 0;
        for (cartitem item : datalist) {
            totalBill += item.getPrice() * item.getQuantity();
        }
        displaytextfield.appendText("Total Bill: " + totalBill + "\n");
    }

    @FXML
    private void CalculateVatOnClick(ActionEvent event) {
        float totalVAT = 0;
        String selectedProducts = displaytextfield.getText(); // Assuming the selected products are displayed in displaytextfield
        float priceRange = Float.parseFloat(costBoundTextFeild.getText());
        float percentageRange = vatConsiderComboBox.getValue();
        StringBuilder vatDetails = new StringBuilder(); // StringBuilder to store the VAT details
        boolean hasInvalidVAT = false; // Flag to track if there is any invalid VAT

        for (cartitem item : datalist) {
            if (selectedProducts.contains(item.getSelectproduct())) {
                vatDetails.append("Product: ").append(item.getSelectproduct())
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
    }
}

