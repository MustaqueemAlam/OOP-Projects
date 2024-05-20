/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mustaqueem Alam
 */
public class MainScController implements Initializable {

    @FXML
    private TableView<FootballPlayer> tableView;
    @FXML
    private TableColumn<FootballPlayer, String> nameCol;
    @FXML
    private TableColumn<FootballPlayer, Integer> ageCol;
    @FXML
    private TableColumn<FootballPlayer, String> positionCol;
    @FXML
    private TableColumn<FootballPlayer, Integer> goalsCol;
    @FXML
    private PieChart pieChart;
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private ComboBox<String> positionComboBox;
    @FXML
    private TextField goalsField;
    @FXML
    private Button generatePDFButton;
    private User user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = new User();
        positionComboBox.setItems(FXCollections.observableArrayList("Forward", "Midfielder", "Defender", "Goalkeeper"));
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        ageCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        positionCol.setCellValueFactory(cellData -> cellData.getValue().positionProperty());
        goalsCol.setCellValueFactory(cellData -> cellData.getValue().goalsProperty().asObject());
        user.updatePieChart(pieChart, tableView);
    }    

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String position = positionComboBox.getValue();
        int goals = Integer.parseInt(goalsField.getText());

        user.addFootballPlayer(name, age, position, goals);
        tableView.setItems(user.getPlayerList());
        user.updatePieChart(pieChart, tableView);
    }

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
        user.savePlayersToFile();
        
    }

    @FXML
    private void generatePDFButton(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        user.generatePDF(tableView, stage);
    }

    @FXML
    private void clearButtonOnCLick(ActionEvent event) {
        user.clearTableView(tableView);
        user.updatePieChart(pieChart, tableView);
        
    }
    
}
