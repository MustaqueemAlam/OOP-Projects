package callofduty2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.fxml.FXML;


public class SettingsSc1Controller implements Initializable {

    @FXML
    private ComboBox<String> shadowsOption;
    @FXML
    private ComboBox<Integer> FpsOption;
    @FXML
    private ComboBox<String> resolutionsOption;
    @FXML
    private ComboBox<String> EffectsOption;
    @FXML
    private Button SaveAndReturnButton;
    @FXML
    private ComboBox<String> DifficultyOption;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shadowsOption.getItems().addAll("On", "Off");
        shadowsOption.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        System.out.println("Selected option: " + newValue);
    });
         FpsOption.getItems().addAll(30, 60, 90);

    // Set up event listener for ComboBox selection change
    FpsOption.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        // Handle the updated integer value
        System.out.println("Selected option: " + newValue);
    });
        resolutionsOption.getItems().addAll("Full HD or 1080p","Quad HD or 1440p","4K Ultra HD or 2160p");
        resolutionsOption.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        System.out.println("Selected option: " + newValue);    
    });
        
    }    

    @FXML
    private void shadowsOptionOnClick(ActionEvent event) {
        
    } 
     

    @FXML
    private void FpsOptionOnClick(ActionEvent event) {
    }

    @FXML
    private void resolutionsOptionOnClick(ActionEvent event) {
    }

    @FXML
    private void DifficultyOptionOnClick(ActionEvent event) {
    }

    @FXML
    private void EffectsOptionOnClick(ActionEvent event) {
    }

    @FXML
    private void SaveAndReturnButtonOnClick(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OpeningSc.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
     
        // Get the current stage from any node in the current scene
        Stage currentStage = (Stage) SaveAndReturnButton.getScene().getWindow();
        currentStage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    
}
