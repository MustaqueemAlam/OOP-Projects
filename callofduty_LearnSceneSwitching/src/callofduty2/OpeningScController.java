package callofduty2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;



public class OpeningScController implements Initializable {

    @FXML
    private Button NewGameButton;
    @FXML
    private Button WeaponSummaryButton;
    @FXML
    private Button SettingsButton;
    @FXML
    private Button ExitButton;
    
    Stage stage;
    @FXML
    private AnchorPane scenePane;
    @FXML
    public void ExitButtonOnClick(ActionEvent event){
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit Game");
        alert.setHeaderText("You are about to exit the game");
        alert.setContentText("Do you want to save your progress before exiting?");
        if (alert.showAndWait().get()== ButtonType.OK){
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Game Exited Sucessfully!");
            stage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void NewGameButtonOnClick(ActionEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterPlayerSc.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
     
        // Get the current stage from any node in the current scene
        Stage currentStage = (Stage) NewGameButton.getScene().getWindow();
        currentStage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void WeaponSummaryButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void SettitingsButtonOnClick(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("settingsSc1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
     
        // Get the current stage from any node in the current scene
        Stage currentStage = (Stage) SettingsButton.getScene().getWindow();
        currentStage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    
}
