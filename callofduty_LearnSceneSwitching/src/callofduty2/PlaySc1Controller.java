/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package callofduty2;

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
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mustaqueem Alam
 */
public class PlaySc1Controller implements Initializable {

    @FXML
    private Label outputlabel;
    @FXML
    private Button PauseButton;
    @FXML
    private Button climbButton;
    @FXML
    private Button CollectWeaponButton;
    @FXML
    private Button attackButton;
    @FXML
    private Label lifebarLabel;
    
    @FXML
    private Button StopPlayButton;
    @FXML
    private Button RunButton;
    @FXML
    private Button walkButton;
    @FXML
    private Button CrawlButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lifebarLabel.setText("5");
    }    

    @FXML
    private void PauseButtonOnClick(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pauseSc.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
     
        // Get the current stage from any node in the current scene
        Stage currentStage = (Stage) PauseButton.getScene().getWindow();
        currentStage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }


    @FXML
    private void climbButtonOnClick(ActionEvent event) {
        outputlabel.setText("Climbing");
    }

    @FXML
    private void CollectWeaponButtonOnClick(ActionEvent event) {
        outputlabel.setText("Collecting Weapons");
    }

    @FXML
    private void attackButtonOnClick(ActionEvent event) {
        outputlabel.setText("Attacking Enemy");
    }

    @FXML
    private void StopPlayButtonOnClick(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OpeningSc.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
     
        // Get the current stage from any node in the current scene
        Stage currentStage = (Stage) StopPlayButton.getScene().getWindow();
        currentStage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void RunButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void walkButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void CrawlButtonOnClick(ActionEvent event) {
    }
    
}
