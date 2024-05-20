package callofduty2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class RegisterPlayerScController implements Initializable {

    @FXML
    private TextField TypeUserNameTextFeild;
    @FXML
    private Button NextButtonToPlay;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void TypeUserNameTextFeild(ActionEvent event) {
    }

    @FXML
    private void NextButtonToPlayOnClick(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("playSc1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
     
        // Get the current stage from any node in the current scene
        Stage currentStage = (Stage) NextButtonToPlay.getScene().getWindow();
        currentStage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
}
