/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main_pkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mustaqueem Alam
 */
public class OfferNewCourseController implements Initializable {

    @FXML
    private TextField courseId;
    @FXML
    private TextField courseTitle;
    @FXML
    private ComboBox<Integer> noOfcreditComboBox;
    @FXML
    private ComboBox<String> selectPreReqCombobox;
    @FXML
    private ComboBox<String> courseCatagoryComboBox;
    @FXML
    private ComboBox<String> courseTypeComboBox;
    @FXML
    private ComboBox<String> selectPOcombobox;
    @FXML
    private ComboBox<String> selectCOcombobox;
    @FXML
    private Label POlistLabel;
    @FXML
    private Label COlistLabel;
    @FXML
    private TextField descriptionOfCO;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       noOfcreditComboBox.getItems().addAll(1, 3, 4, 6);
       selectPOcombobox.getItems().addAll("PO1", "PO2", "PO3", "PO4"); 
        selectCOcombobox.getItems().addAll("CO1", "CO2", "CO3", "CO4");
        selectPreReqCombobox.getItems().addAll("Course A", "Course B", "Course C");
        courseCatagoryComboBox.getItems().addAll("major", "minor", "seniorproject", "core", "foundation");
        courseTypeComboBox.getItems().addAll("theory", "lab", "others");
    }    

    @FXML
    private void addSelectedPoOnClick(ActionEvent event) {
             String selectedPO = selectPOcombobox.getValue();
        if (selectedPO != null) {
            POlistLabel.setText(selectedPO);
        }
    
    }

    @FXML
    private void addSelectedCoOnClick(ActionEvent event) {
                String selectedCO = selectCOcombobox.getValue();
        if (selectedCO != null) {
            COlistLabel.setText(selectedCO);
        }
    
    }

    @FXML
    private void addSelectedPreReqOnClick(ActionEvent event) {
        String selectedPreReq = selectPreReqCombobox.getValue();
    }

    @FXML
    private void addNewcourseOnClick(ActionEvent event) {
                String courseIdValue = courseId.getText();
        String courseTitleValue = courseTitle.getText();
        int noOfCreditsValue = noOfcreditComboBox.getValue();
        String selectedPO = POlistLabel.getText();
        String selectedCO = COlistLabel.getText();
        String selectedPreReq = selectPreReqCombobox.getValue();
        String courseCategoryValue = courseCatagoryComboBox.getValue();
        String courseTypeValue = courseTypeComboBox.getValue();
        String descriptionOfCOValue = descriptionOfCO.getText();

        Course newCourse = new Course(courseIdValue, courseTitleValue, noOfCreditsValue, selectedPO, selectedCO, selectedPreReq, courseCategoryValue, courseTypeValue, descriptionOfCOValue);

        boolean saveStatus = HOD.saveCourse(newCourse, "Offeredcourse.bin");

        if (saveStatus) {
            // Show a confirmation alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Course added successfully!");
            alert.showAndWait();

            // Clear the input fields and labels
            clearInputFields();
        } else {
            // Show an error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error adding course. Please try again.");
            alert.showAndWait();
        }
    }

    private void clearInputFields() {
        courseId.clear();
        courseTitle.clear();
        noOfcreditComboBox.setValue(null);
        POlistLabel.setText("");
        COlistLabel.setText("");
        selectPreReqCombobox.setValue(null);
        courseCatagoryComboBox.setValue(null);
        courseTypeComboBox.setValue(null);
        descriptionOfCO.clear();
    
    }
    
}
