/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main_pkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mustaqueem Alam
 */
public class OfferNewCourseController implements Initializable {

    @FXML
    private TextField courseId;
    @FXML
    private TextField courseTitle;
    @FXML
    private ComboBox<Integer> noOfcreditComboBox;
    @FXML
    private ComboBox<String> selectPreReqCombobox;
    @FXML
    private ComboBox<String> courseCatagoryComboBox;
    @FXML
    private ComboBox<String> courseTypeComboBox;
    @FXML
    private ComboBox<?> selectPOcombobox;
    @FXML
    private ComboBox<?> selectCOcombobox;
    @FXML
    private Label POlistLabel;
    @FXML
    private Label COlistLabel;
    @FXML
    private TextField descriptionOfCO;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addSelectedPoOnClick(ActionEvent event) {
    }

    @FXML
    private void addSelectedCoOnClick(ActionEvent event) {
    }

    @FXML
    private void addSelectedPreReqOnClick(ActionEvent event) {
    }

    @FXML
    private void addNewcourseOnClick(ActionEvent event) {
    }
    
}
