/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlapplicationpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Subrata Kumar Dey
 */
public class TableViewDemoSceneController implements Initializable {

    @FXML    private TableView<Student> tv;
    @FXML    private TableColumn<Student, Integer> idTC;
    @FXML    private TableColumn<Student, String> nameTC;
    @FXML    private TableColumn<Student, Float> cgpaTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
