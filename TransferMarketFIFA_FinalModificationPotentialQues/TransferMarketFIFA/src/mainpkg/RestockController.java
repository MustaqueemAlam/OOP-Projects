/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mustaqueem Alam
 */
public class RestockController implements Initializable {

    @FXML
    private RadioButton forwardRadioButton;
    @FXML
    private RadioButton midfeilderRadioButton;
    @FXML
    private RadioButton defenderRadioButton;
    @FXML
    private TextField minRangeTextFeild;
    @FXML
    private TextField MaxRangeTextFeild;
    @FXML
    private TextArea updateRecordsTExtArea;
    @FXML
    private Label instaceAddLimit;
    @FXML
    private RadioButton goalkeepeerRadioButton;
    private ToggleGroup positionToggleGroup;
    private int instanceCount = 0; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        positionToggleGroup = new ToggleGroup(); // Initialize the ToggleGroup
        forwardRadioButton.setToggleGroup(positionToggleGroup);
        midfeilderRadioButton.setToggleGroup(positionToggleGroup);
        defenderRadioButton.setToggleGroup(positionToggleGroup);
        goalkeepeerRadioButton.setToggleGroup(positionToggleGroup);
    }    

    @FXML
    private void addInstanceTOTextarea(ActionEvent event) {
        String selectedPosition = "";

        if (forwardRadioButton.isSelected()) {
            selectedPosition = "Forward";
        } else if (midfeilderRadioButton.isSelected()) {
            selectedPosition = "Midfielder";
        } else if (defenderRadioButton.isSelected()) {
            selectedPosition = "Defender";
        } else if (goalkeepeerRadioButton.isSelected()) {
            selectedPosition = "Goalkeeper";
        }

        String minRange = minRangeTextFeild.getText();
        String maxRange = MaxRangeTextFeild.getText();

        // Validate minRange and maxRange as numbers
        if (!isValidNumber(minRange) || !isValidNumber(maxRange)) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Price range must be valid numbers.");
            return;
        }

        // Convert strings to doubles for comparison
        double minPrice = Double.parseDouble(minRange);
        double maxPrice = Double.parseDouble(maxRange);

        // Validate price range
        if (minPrice > maxPrice) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Minimum price cannot be greater than maximum price.");
            return;
        }

        String instance = "Position: " + selectedPosition + " | Price Range: " + minRange + " - " + maxRange;

        updateRecordsTExtArea.appendText(instance + "\n");

        instanceCount++; // Increment instanceCount each time an instance is added

        int remainingInstances = 20 - instanceCount; // Adjust this according to your total instance count

        if (remainingInstances <= 10) {
            instaceAddLimit.setText("Warning: Only " + remainingInstances + " instances remaining!");

            if (remainingInstances <= 0) {
                showAlert(Alert.AlertType.ERROR, "Error", "No instances remaining.");
            }
        } else {
            instaceAddLimit.setText("Instances available: " + remainingInstances);
        }
    }

    private boolean isValidNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
        @FXML
    private void saveASpdfOnCLick(ActionEvent event) {
            FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("PDF Files", "*.pdf"));

        Stage stage = (Stage) updateRecordsTExtArea.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            try {
                createPdfDocument(file.getAbsolutePath());
                // Show a success message to the user
                instaceAddLimit.setText("PDF report saved successfully!");
            } catch (IOException e) {
                // Handle the exception (e.g., show an error message)
                e.printStackTrace();
                instaceAddLimit.setText("Error: PDF report could not be saved.");
            }
        }
    }

    private void createPdfDocument(String filename) throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter(filename));
        Document document = new Document(pdf);

        // Set title for the PDF document
        document.add(new Paragraph("Restock Report").setBold());

        // Add content from the text area to the PDF
        document.add(new Paragraph(updateRecordsTExtArea.getText()));

        document.close();

    }
    
}
