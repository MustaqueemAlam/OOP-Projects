package mainPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.property.SimpleFloatProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class MidSceneController implements Initializable {

    @FXML
    private ComboBox<String> selectProductComboBox;
    @FXML
    private TextField unitPriceTextField;
    @FXML
    private ComboBox<Integer> quantityComboBox;
    @FXML
    private TextField vatTextField;
    @FXML
    private TableView<CartItem> tableVIew;
    @FXML
    private TableColumn<CartItem, String> productNameCol;
    @FXML
    private TableColumn<CartItem, Float> unitPriceCol;
    @FXML
    private TableColumn<CartItem, Integer> quantityCol;
    @FXML
    private TableColumn<CartItem, Float> vatCol;
    @FXML
    private TableColumn<CartItem, Float> vatAmountCol;
    @FXML
    private TableColumn<CartItem, Float> grossTotalCol;
    @FXML
    private Label totalPayableTextField;
    @FXML
    private ComboBox<Integer> SelectVatCB;
    @FXML
    private TextField maxPerUnitCostTF;
    @FXML
    private TextArea searchResultTextField;

    ArrayList<CartItem> cartList;

    private final float[] predefinedPrices = { 70.0f, 350.0f, 300.0f, 50.0f, 250.0f, 1500.0f, 400.0f, 100.0f };
    private final int[] predefinedVat = { 3, 3, 5, 7, 5, 15, 7, 15 };
    private int invoiceCounter = 1; // To keep track of the invoice number

    private final String invoiceFolderPath = "C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/Su_23_MID_SET_B/src/mainPackage/invoices/";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectProductComboBox.getItems().addAll("Aarong milk 1kg", "Nescafe Gold 500gm jar", "Salmon fish 1kg",
                "Lux 100gm bar soap", "Basmati rice 1kg pack", " Sturgeon caviar 10gm", "Canned tuna fish",
                "Saffron 2gm pack");
        quantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        selectProductComboBox.setOnAction(this::handleProductSelection);
        SelectVatCB.getItems().addAll(3, 5, 7, 15);

        cartList = new ArrayList<>(); // initialization of ArrayList

        productNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        unitPriceCol.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        vatCol.setCellValueFactory(new PropertyValueFactory<>("vatRate"));
        vatAmountCol.setCellValueFactory(cellData -> {
            float unitPrice = cellData.getValue().getUnitPrice();
            int quantity = cellData.getValue().getQuantity();
            float vatRate = cellData.getValue().getVatRate();
            float vatAmount = (unitPrice * quantity * vatRate) / 100;
            return new SimpleFloatProperty(vatAmount).asObject();
        });
        grossTotalCol.setCellValueFactory(cellData -> {
            float unitPrice = cellData.getValue().getUnitPrice();
            int quantity = cellData.getValue().getQuantity();
            float vatRate = cellData.getValue().getVatRate();
            float vatAmount = (unitPrice * quantity * vatRate) / 100;
            float grossTotal = (unitPrice * quantity) + vatAmount;
            return new SimpleFloatProperty(grossTotal).asObject();
        });

        // Find the highest invoice number in the folder and set the counter accordingly
        findHighestInvoiceNumber();
    }

    private void handleProductSelection(ActionEvent event) {
        String selectedProduct = selectProductComboBox.getValue();
        if (selectedProduct != null) {
            int index = selectProductComboBox.getItems().indexOf(selectedProduct);
            if (index >= 0 && index < predefinedPrices.length && index < predefinedVat.length) {
                float unitPrice = predefinedPrices[index];
                int vatPercentage = predefinedVat[index];

                unitPriceTextField.setText("Unit Price: " + unitPrice);
                vatTextField.setText(vatPercentage + "%");
            }
        }
    }

    private void findHighestInvoiceNumber() {
        File invoiceFolder = new File(invoiceFolderPath);
        if (!invoiceFolder.exists()) {
            invoiceFolder.mkdirs();
        } else {
            File[] invoiceFiles = invoiceFolder.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.matches("Invoice\\d+\\.txt");
                }
            });

            if (invoiceFiles != null && invoiceFiles.length > 0) {
                // Sort the files by name to find the highest invoice number
                Arrays.sort(invoiceFiles);
                Pattern pattern = Pattern.compile("Invoice(\\d+)\\.txt");
                Matcher matcher = pattern.matcher(invoiceFiles[invoiceFiles.length - 1].getName());
                if (matcher.find()) {
                    invoiceCounter = Integer.parseInt(matcher.group(1)) + 1;
                }
            }
        }
    }

    @FXML
    private void saveBinFIleButton(ActionEvent event) {
        try {
            // Check if the cartList is not empty
            if (!cartList.isEmpty()) {
                // Choose the file name for the binary file
                String fileName = "C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/Su_23_MID_SET_B/src/cart_data.bin";

                // Check if the file already exists
                File file = new File(fileName);
                boolean isFileExists = file.exists();

                // Create an ObjectOutputStream to write the data to the file
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName, !isFileExists))) {
                    // Write the cartList to the binary file
                    oos.writeObject(cartList);
                }

                // Display a success message
                System.out.println("Cart data saved successfully!");
            } else {
                // Display a message if the cartList is empty
                System.out.println("Cart is empty! Nothing to save.");
            }
        } catch (IOException e) {
            // Handle any errors that might occur during file saving
            e.printStackTrace();
            System.out.println("Error saving cart data!");
        }
    }

    @FXML
    private void addProductToCartButtonOnClick(ActionEvent event) {

        String selectedProduct = selectProductComboBox.getValue();
        float unitPrice = 0.0f;
        float vatRate = 0.0f;
        int quantity = quantityComboBox.getValue();

        if (selectedProduct != null) {
            // get the index of the selected product in the predefined list
            int index = selectProductComboBox.getItems().indexOf(selectedProduct);
            if (index >= 0 && index < predefinedPrices.length && index < predefinedVat.length) {
                unitPrice = predefinedPrices[index];
                vatRate = predefinedVat[index];
            }

            // check if the selected product is already in the cartList
            boolean isAlreadyAdded = false;
            for (CartItem item : cartList) {
                if (item.getProductName().equals(selectedProduct)) {
                    // updating the quantity of the existing item
                    item.setQuantity(item.getQuantity() + quantity);
                    isAlreadyAdded = true;
                    break;
                }
            }

            if (!isAlreadyAdded) {
                // create a new CartItem and add it to the cartList
                CartItem newItem = new CartItem(selectedProduct, unitPrice, vatRate, quantity);
                cartList.add(newItem);
            }

            // clear the selection after adding the item to the cart
            selectProductComboBox.getSelectionModel().clearSelection();
            quantityComboBox.getSelectionModel().clearSelection();

            // update the TableView to display the cartList items
            updateTableView();
        }
    }

    private void updateTableView() {
        // set the TableView items to the cartList
        tableVIew.getItems().setAll(cartList);

        // calculate the total payable amount
        float totalPayable = 0.0f;
        for (CartItem item : cartList) {
            float grossTotal = item.getGrossTotal();
            totalPayable += grossTotal;
        }

        // update the totalPayableTextField with the calculated total
        totalPayableTextField.setText("Total Payable: " + totalPayable + " BDT");

        // refresh the TableView to update the displayed data
        tableVIew.refresh();
    }

    @FXML
    private void checkOutAndShowBillButtonOnClick(ActionEvent event) {
    // Check if the cartList is not empty
    if (!cartList.isEmpty()) {
        // Create a StringBuilder to store the bill content
        StringBuilder billContent = new StringBuilder();
        billContent.append("Bill Summary\n\n");

        for (CartItem item : cartList) {
            String productName = item.getProductName();
            float unitPrice = item.getUnitPrice();
            int quantity = item.getQuantity();
            float grossTotal = item.getGrossTotal();

            billContent.append(productName).append(" (Quantity: ").append(quantity).append(")\n");
            billContent.append("Unit Price: ").append(unitPrice).append("\n");
            billContent.append("Gross Total: ").append(grossTotal).append("\n\n");
        }

        // Calculate the total payable amount
        float totalPayable = 0.0f;
        for (CartItem item : cartList) {
            float grossTotal = item.getGrossTotal();
            totalPayable += grossTotal;
        }

        // Append the total payable amount to the bill content
        billContent.append("Total Payable: ").append(totalPayable).append(" BDT\n");

        // Create a Text node to display the bill content
        Text billText = new Text(billContent.toString());
        billText.setFont(Font.font("Courier New", 12));
        billText.setTextAlignment(TextAlignment.LEFT);

        // Create an Alert dialog to show the bill content
        Alert billAlert = new Alert(AlertType.INFORMATION);
        billAlert.setTitle("Invoice");
        billAlert.setHeaderText(null);
        DialogPane dialogPane = billAlert.getDialogPane();
        dialogPane.setMinHeight(Region.USE_PREF_SIZE);
        billAlert.getDialogPane().setContent(billText);

        // Show the bill dialog
        billAlert.showAndWait();

        // Save the bill content as a text file
        saveAsTextFile(billContent.toString(), totalPayable);

        cartList.clear();
        updateTableView();
    } else {
        // Display a message if the cartList is empty
        System.out.println("Cart is empty! Nothing to generate an invoice.");
    }
}

    private void saveAsTextFile(String content, float totalPayable) {
    String fileName = invoiceFolderPath + "Invoice" + invoiceCounter + ".txt";

    try (FileWriter fileWriter = new FileWriter(fileName)) {
        // Add current date and time at the top of the invoice
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = sdf.format(new Date());
        fileWriter.write("Invoice generated on: " + dateTime + "\n\n");

        // Write the content to the text file
        fileWriter.write(content);
        
        // Display a success message
        System.out.println("Invoice saved successfully as a text file: " + fileName);

        // Increment the invoice counter for the next invoice
        invoiceCounter++;
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error saving invoice as a text file!");
    }
}


    @FXML
    private void showTotalVatForQualifiedProductsButtonOnClick(ActionEvent event) {

        float selectedVatRate = SelectVatCB.getValue();
        float maxUnitPrice = Float.parseFloat(maxPerUnitCostTF.getText());
        float totalVatAmount = 0.0f;

        for (CartItem item : cartList) {
            float unitPrice = item.getUnitPrice();
            float vatRate = item.getVatRate();

            if (unitPrice <= maxUnitPrice && vatRate == selectedVatRate) {
                totalVatAmount += item.getVatAmount();
            }
        }
        searchResultTextField.setText("Total VAT amount paid for the given criteria: " + totalVatAmount + " BDT");
    }
}
