package main_pkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AddNewApprovedCourseController implements Initializable {

    @FXML
    private TextField courseIdTextField;
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField noOfCreditsTextField;
    @FXML
    private TextField courseTypeTextField;
    @FXML
    private TextField courseCategoryTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addNewCourse(ActionEvent event) {
        String courseId = courseIdTextField.getText();
        String title = titleTextField.getText();
        int noOfCredits = Integer.parseInt(noOfCreditsTextField.getText());
        String courseType = courseTypeTextField.getText();
        String courseCategory = courseCategoryTextField.getText();

        // Assuming the Course class has a constructor to create a new course
        Course newCourse = new Course(courseId, title, noOfCredits, courseType, courseCategory);

        // Load existing course data
        List<Course> courseList = FileHandler.loadCourseData();

        // Add the new course to the list
        courseList.add(newCourse);

        // Save the updated course list
        FileHandler.saveCourseData(courseList);

        // Clear input fields after adding
        courseIdTextField.clear();
        titleTextField.clear();
        noOfCreditsTextField.clear();
        courseTypeTextField.clear();
        courseCategoryTextField.clear();

        // Show feedback or perform other actions if needed
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
