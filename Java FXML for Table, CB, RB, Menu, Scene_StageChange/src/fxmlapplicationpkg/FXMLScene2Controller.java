
package fxmlapplicationpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class FXMLScene2Controller implements Initializable {

    @FXML
    private Button goBackToMainSceneButton;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private RadioButton transGenderRadioButton;
    @FXML
    private Label genderLabel;
    //@FXML
    private ToggleGroup tg, tg2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tg = new ToggleGroup();
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);
        transGenderRadioButton.setToggleGroup(tg);
        
        maleRadioButton.setSelected(true);
        genderLabel.setText("Selected Gender is : Male");
    }    

    @FXML
    private void goBackToMainSceneButtonOnClick(ActionEvent event) throws IOException{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("FXMLMainScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void radioButtonOnClick(ActionEvent event) {
        if(maleRadioButton.isSelected()) genderLabel.setText("Selected Gender is : Male");
        else if(femaleRadioButton.isSelected()) genderLabel.setText("Selected Gender is : Female");
        else if (transGenderRadioButton.isSelected()) genderLabel.setText("Selected Gender is : Trans Gender");
        
    }
}
