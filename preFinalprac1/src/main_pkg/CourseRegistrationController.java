package main_pkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CourseRegistrationController implements Initializable {

    @FXML
    private TextField studentIdTextField;
    @FXML
    private ComboBox<Course> courseIdComboBox;
    @FXML
    private TextField semesterTextField;
    @FXML
    private TextField secTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Load the courses into the combo box
        loadCourses();
    }

    private void loadCourses() {
        // Load the courses from the binary file or any other data source
        // For example:
        List<Course> courseList = FileHandler.loadCourseData();
        courseIdComboBox.getItems().addAll(courseList);
    }

    @FXML
    private void registerCourse(ActionEvent event) {
        String studentId = studentIdTextField.getText();
        Course selectedCourse = courseIdComboBox.getValue();
        String semester = semesterTextField.getText();
        String sec = secTextField.getText();

        if (selectedCourse != null) {
            // Assuming the RegisteredCourse class has a constructor to create a new registered course
            RegisteredCourse newRegisteredCourse = new RegisteredCourse(studentId, selectedCourse.getCourseId(), semester, sec);

            // Load existing registered course data
            List<RegisteredCourse> registeredCourseList = FileHandler.loadRegisteredCourseData();

            // Add the new registered course to the list
            registeredCourseList.add(newRegisteredCourse);

            // Save the updated registered course list
            FileHandler.saveRegisteredCourseData(registeredCourseList);

            // Clear input fields after adding
            studentIdTextField.clear();
            courseIdComboBox.getSelectionModel().clearSelection();
            semesterTextField.clear();
            secTextField.clear();

            // Show feedback or perform other actions if needed
        }
    }
}
