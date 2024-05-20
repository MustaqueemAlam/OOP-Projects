package main_pkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
            int id = Integer.parseInt(facultyIdTextField.getText());
        String name = nameTextField.getText();
        String designation = designatinComboBox.getValue();
        String department = departmentComboBox.getValue();
        Float salary = Float.valueOf(salaryTextField.getText());
        LocalDate dob = DOBdatePicker.getValue();

        Faculty newFaculty = new Faculty(id, name, designation, department, salary, dob);
        boolean addStatus = CITSAdmin.addNewFaculty(newFaculty, "faculty.bin");

        if (addStatus) {
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText("New Faculty Added Successfully!");
            a.showAndWait();
        } else {
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Oops, something went wrong");
            a.showAndWait();
        }
    }
}