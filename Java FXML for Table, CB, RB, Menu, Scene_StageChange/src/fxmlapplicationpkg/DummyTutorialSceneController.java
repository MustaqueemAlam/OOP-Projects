/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlapplicationpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Subrata Kumar Dey
 */
public class DummyTutorialSceneController implements Initializable {

    @FXML    private TextField inputTextField;
    
    private Student asif;
    @FXML    private DatePicker dOfJoiningPicket;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadCalculatorMenuItemOnClick(ActionEvent event) {
        //your code to load a cal
        doSome();
    }
    
    private void doSome(){
        //.....
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
    }
    
}
