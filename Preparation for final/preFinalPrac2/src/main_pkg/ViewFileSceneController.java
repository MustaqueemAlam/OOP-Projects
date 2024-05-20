/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main_pkg;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cis101
 */
public class ViewFileSceneController implements Initializable {

    @FXML
    private TextArea textArea;
    @FXML
    private Button backButton;
    @FXML
    private ComboBox<String> loadFileComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadFileComboBox.getItems().addAll( "Faculty.Bin","Course.Bin","OfferedCourse.Bin","RegisteredCourse.Bin");
    }    

     @FXML
    private void LoadFileContentOnClick(ActionEvent event) {
String selectedFileName = loadFileComboBox.getValue();

    List<Object> objects = CITSAdmin.readObjectsFromFile(selectedFileName);
    StringBuilder contentBuilder = new StringBuilder();

    for (Object obj : objects) {
        if (obj instanceof Faculty) {
            contentBuilder.append(((Faculty) obj).toString()).append("\n");
        } else if (obj instanceof Course) {
            contentBuilder.append(((Course) obj).toString()).append("\n");
        } else if (obj instanceof OfferedCourse) {
            contentBuilder.append(((OfferedCourse) obj).toString()).append("\n");
        } else if (obj instanceof RegisteredCourse) {
            contentBuilder.append(((RegisteredCourse) obj).toString()).append("\n");
        } else {
            System.out.println("Encountered an unknown object in the file.");
        }
    }

    textArea.setText(contentBuilder.toString());
}


    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainDashboard.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
     
        // Get the current stage from any node in the current scene
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
}
