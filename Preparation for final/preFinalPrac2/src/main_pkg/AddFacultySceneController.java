package main_pkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddFacultySceneController implements Initializable {

    @FXML
    private TextField facultyIdTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField salaryTextField;
    @FXML
    private DatePicker DOBdatePicker;
    @FXML
    private ComboBox<String> designatinComboBox;
    @FXML
    private ComboBox<String> departmentComboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        designatinComboBox.getItems().addAll("Lecturer", "Associate Professor", "Senior Lecturer", "");
        departmentComboBox.getItems().addAll("CSE", "EEE", "Physics", "Mathematics");
        designatinComboBox.setValue("Lecturer");
        departmentComboBox.setValue("CSE");
    }

    @FXML
    private void addNewFacultyonCLick(ActionEvent event) {
        int id;
        String name = nameTextField.getText();
        String designation = designatinComboBox.getValue();
        String department = departmentComboBox.getValue();
        Float salary;
        LocalDate dob;

        try {
            id = Integer.parseInt(facultyIdTextField.getText());
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Invalid Input", "Faculty ID must be a valid integer.");
            return;
        }

        try {
            salary = Float.parseFloat(salaryTextField.getText());
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Invalid Input", "Salary must be a valid floating-point number.");
            return;
        }

        dob = DOBdatePicker.getValue();
        if (dob == null) {
            showAlert(AlertType.ERROR, "Missing Input", "Please select a valid date of birth.");
            return;
        }

        if (name.isEmpty() || designation.isEmpty() || department.isEmpty()) {
            showAlert(AlertType.ERROR, "Missing Input", "All fields are required.");
            return;
        }

        // Confirmation Alert
        Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Add New Faculty");
        confirmationAlert.setContentText("Are you sure you want to add this faculty?");
        confirmationAlert.showAndWait()
            .filter(response -> response == ButtonType.OK)
            .ifPresent(response -> {
                // Add new faculty
                Faculty newFaculty = new Faculty(id, name, designation, department, salary, dob);
                boolean addStatus = CITSAdmin.addNewFaculty(newFaculty, "faculty.bin");

                if (addStatus) {
                    showAlert(AlertType.INFORMATION, "Success", "New Faculty Added Successfully!");
                    // Clear input fields after success
                    clearInputFields();
                } else {
                    showAlert(AlertType.ERROR, "Error", "Oops, something went wrong.");
                }
            });
    }

    // ... Existing methods ...

    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    private void clearInputFields() {
        facultyIdTextField.clear();
        nameTextField.clear();
        salaryTextField.clear();
        DOBdatePicker.setValue(null);
        designatinComboBox.setValue("Lecturer");
        departmentComboBox.setValue("CSE");
    }
}