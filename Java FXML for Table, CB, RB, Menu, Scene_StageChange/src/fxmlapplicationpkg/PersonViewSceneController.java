package fxmlapplicationpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javax.swing.event.MenuEvent;

public class PersonViewSceneController implements Initializable {

    private Person selectedPerson;
    
    @FXML Label firstNameLabel;
    @FXML Label lastNameLabel;    
    @FXML Label birthdayLabel;
    @FXML Label ageLabel;    
    @FXML
    private MenuItem closeMenu;
    @FXML
    private MenuItem resetViewMenuItem;
    
    public void initData(Person p){
        selectedPerson = p;
        firstNameLabel.setText(selectedPerson.getFirstName());
        lastNameLabel.setText(selectedPerson.getLastName());
        birthdayLabel.setText(selectedPerson.getBirthday().toString());
        ageLabel.setText(Integer.toString(selectedPerson.getAge())+" years");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //firstNameLabel.setText(selectedPerson.getFirstName());
        //lastNameLabel.setText(selectedPerson.getLastName());
        //birthdayLabel.setText(selectedPerson.getBirthday().toString());
        //ageLabel.setText(Integer.toString(selectedPerson.getAge())+" years");        
    }    

    @FXML
    private void closeMenuOnClick(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void resetViewMenuItemOnClick(ActionEvent event) {
        firstNameLabel.setText(null);
        lastNameLabel.setText(null);
        birthdayLabel.setText(null);
        ageLabel.setText(null);
    }
    
}
