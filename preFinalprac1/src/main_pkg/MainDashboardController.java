package main_pkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class MainDashboardController {

    @FXML
    private Label newUserIdOutputLabel;

    @FXML
    private void switchToAddFacultyScene(ActionEvent event) {
        switchScene("AddFacultyScene.fxml");
    }

    @FXML
    private void switchToAddNewApprovedCourseScene(ActionEvent event) {
        switchScene("AddNewApprovedCourseScene.fxml");
    }

    @FXML
    private void switchToOfferCourseForRegistrationScene(ActionEvent event) {
        switchScene("OfferCourseForRegistrationScene.fxml");
    }

    @FXML
    private void switchToCourseRegistrationScene(ActionEvent event) {
        switchScene("CourseRegistrationScene.fxml");
    }

    private void switchScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Get the current stage from any node in the current scene
            Stage currentStage = (Stage) newUserIdOutputLabel.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
