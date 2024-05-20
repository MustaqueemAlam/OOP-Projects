package main_pkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddFacultyController implements Initializable {

    private List<Faculty> facultyList = new ArrayList<>();
    private FileHandler fileHandler = new FileHandler();

    @FXML
    private TextField facultyIdTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField designationTextField;
    @FXML
    private TextField deptTextField;
    @FXML
    private TextField salaryTextField;
    @FXML
    private TextField dobTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Load existing faculty data from file (if available)
        loadFacultyData();
    }

    @FXML
    private void addNewFaculty(ActionEvent event) {
        try {
            int facultyId = Integer.parseInt(facultyIdTextField.getText());
            String name = nameTextField.getText();
            String designation = designationTextField.getText();
            String dept = deptTextField.getText();
            double salary = Double.parseDouble(salaryTextField.getText());
            LocalDate dob = LocalDate.parse(dobTextField.getText());

            Faculty newFaculty = new Faculty(facultyId, name, designation, dept, salary, dob);
            facultyList.add(newFaculty);
            fileHandler.saveFacultyData(facultyList);

            showAlert("Success", "New Faculty Added", "Faculty with ID " + facultyId + " added successfully.");

            // Clear input fields
            facultyIdTextField.clear();
            nameTextField.clear();
            designationTextField.clear();
            deptTextField.clear();
            salaryTextField.clear();
            dobTextField.clear();
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid Input", "Faculty ID and Salary must be valid numbers.");
        } catch (Exception e) {
            showAlert("Error", "Invalid Input", "Please check your input values and try again.");
        }
    }

    // Load existing faculty data from file
    private void loadFacultyData() {
        facultyList = fileHandler.loadFacultyData();
    }

    // Helper method to show alert messages
    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
