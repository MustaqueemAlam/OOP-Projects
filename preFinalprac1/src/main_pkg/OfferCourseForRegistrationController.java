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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mustaqueem Alam
 */
public class OfferCourseForRegistrationController implements Initializable {

    @FXML
    private ComboBox<?> courseIdComboBox;
    @FXML
    private ComboBox<?> facultyIdComboBox;
    @FXML
    private TextField secTextField;
    @FXML
    private TextField semesterTextField;
    @FXML
    private TextField daysTextField;
    @FXML
    private TextField roomTextField;
    @FXML
    private TextField timeTextField;
    @FXML
    private TextField capacityTextField;
    @FXML
    private TextField enrolledTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addNewOfferedCourse(ActionEvent event) {
    }
    
}
