/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mustaqueem Alam
 */
public class AddNewPlayersToTransferMarketController implements Initializable {


    @FXML
    private TableView<Player> playerTableView;
    @FXML
    private TableColumn<Player, String> playerNameCol;
    @FXML
    private TableColumn<Player, String> playerPositionCol;
    @FXML
    private TableColumn<Player, Double> playerPriceCol;
    @FXML
    private TableColumn<Player, LocalDate> playerDateCol;
    @FXML
    private TextField playerNameTextField;
    @FXML
    private ComboBox<String> positionComboBox;
    @FXML
    private TextField playerPriceTextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button addPlayerButton;

    private ObservableList<Player> playerData = FXCollections.observableArrayList();
    @FXML
    private Button back;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        playerPositionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        playerPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        playerDateCol.setCellValueFactory(new PropertyValueFactory<>("dateOfScheduling"));
        playerTableView.setItems(playerData);
        positionComboBox.getItems().addAll("Forward", "Midfielder", "Defender", "Goalkeeper");
    }    
    @FXML
    private void addPlayerToTransferMarket(ActionEvent event) {
    String playerName = playerNameTextField.getText();
        String playerPosition = positionComboBox.getValue();
        if (playerName.isEmpty() || playerPosition == null) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Player name and position are required.");
            return;
        }
        double playerPrice;
        try {
            playerPrice = Double.parseDouble(playerPriceTextField.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Invalid player price.");
            return;
        }
        LocalDate dateOfScheduling = datePicker.getValue();
        if (dateOfScheduling == null) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please select a scheduling date.");
            return;
        }
        Player newPlayer = new Player(playerName, playerPosition, playerPrice, dateOfScheduling);
        playerData.add(newPlayer);
        playerNameTextField.clear();
        positionComboBox.getSelectionModel().clearSelection();
        playerPriceTextField.clear();
        datePicker.setValue(null);
        Admin.writePlayerDataToFile(playerData, "players.bin");
        showAlert(Alert.AlertType.INFORMATION, "Success", "Player added successfully.");
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    @FXML
    private void backOnC(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainSc.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) back.getScene().getWindow();
            currentStage.setScene(scene);
        }catch (IOException e) {
                e.printStackTrace();
        }
    }
}