/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mustaqueem Alam
 */
public class MainScController implements Initializable {

    @FXML
    private Button add;
    @FXML
    private Button buy;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddPlayerOnClick(ActionEvent event) {
                try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddNewPlayersToTransferMarket.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);

                // Get the current stage from any node in the current scene
                Stage currentStage = (Stage) add.getScene().getWindow();
                currentStage.setScene(scene);
            }catch (IOException e) {
                e.printStackTrace();
        }
        
    
    }

    @FXML
    private void BuyPLayerOnCLick(ActionEvent event) {
                try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("BuyPlayers.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);

                // Get the current stage from any node in the current scene
                Stage currentStage = (Stage) buy.getScene().getWindow();
                currentStage.setScene(scene);
            }catch (IOException e) {
                e.printStackTrace();
        }
        
    
    }
    
}
