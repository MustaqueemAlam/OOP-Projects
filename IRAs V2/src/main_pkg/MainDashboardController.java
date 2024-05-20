/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main_pkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author cis101
 */
public class MainDashboardController implements Initializable {

    @FXML
    private BorderPane DashboardBorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SelectOperationOnClick(ActionEvent event) {
    }

    @FXML
    private void AddNewFacultyOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("AddFacultyScene.fxml"));
        DashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void AddNewCourseOnClick(ActionEvent event) {
    }

    @FXML
    private void registerCourseOnClick(ActionEvent event) {
    }

    @FXML
    private void OfferAcourseOnClick(ActionEvent event) {
    }

    @FXML
    private void ViewFileOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ViewFileScene.fxml"));
        DashboardBorderPane.setCenter(parent);
    }
    
}
