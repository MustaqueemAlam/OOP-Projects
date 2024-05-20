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
 * @author User
 */
public class DummyTableDemoForSec3Controller implements Initializable {
    @FXML    private TableView<Student> studentTableView;
    @FXML    private TableColumn<Student, String> idTableColumn;
    @FXML    private TableColumn<Student, String> nameTableColumn;
    @FXML    private TableColumn<Student, Float> cgpaTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
