/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mustaqueem Alam
 */
public class BuyPlayersController implements Initializable {

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
    private ComboBox<String> playerNameComboBox;
    @FXML
    private Label warningLabel;

    /**
     * Initializes the controller class.
     */
    private ObservableList<Player> availablePlayers = FXCollections.observableArrayList(); // Declare and initialize
    @FXML
    private Button back;
    @FXML
    private Button restock;
    @FXML
    private BarChart<String, Number> barchart;
    @FXML
    private PieChart pichart;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        playerPositionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        playerPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        playerDateCol.setCellValueFactory(new PropertyValueFactory<>("dateOfScheduling"));
        // Populate available players list (you can load from file or other sources)
        // For example, loading from a file using Admin class
        List<Object> objectList = Admin.readObjectsFromFile("players.bin");
        for (Object obj : objectList) {
            if (obj instanceof Player) {
                availablePlayers.add((Player) obj);
            }
        }
        playerTableView.setItems(availablePlayers);
        // Populate player names in the ComboBox from availablePlayers
        ObservableList<String> playerNames = FXCollections.observableArrayList();
        for (Player player : availablePlayers) {
            playerNames.add(player.getName());
        }
        playerNameComboBox.setItems(playerNames);
    }    
    @FXML
    private void buyPlayer(ActionEvent event) {
        String selectedPlayerName = playerNameComboBox.getSelectionModel().getSelectedItem();
            if (selectedPlayerName == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "Please select a player to buy.");
                return;
            }

            // Find the selected player based on the name
            Player selectedPlayer = null;
            for (Player player : availablePlayers) {
                if (player.getName().equals(selectedPlayerName)) {
                    selectedPlayer = player;
                    break;
                }
            }

            if (selectedPlayer != null) {
                // Show confirmation alert
                Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmationAlert.setTitle("Confirmation");
                confirmationAlert.setHeaderText("Buy Player");
                confirmationAlert.setContentText("Are you sure you want to buy this player?");
                Optional<ButtonType> result = confirmationAlert.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    // Remove the selected player from availablePlayers list
                    availablePlayers.remove(selectedPlayer);
                    playerTableView.getItems().remove(selectedPlayer);

                    // Update the ComboBox with remaining player names
                    ObservableList<String> updatedPlayerNames = FXCollections.observableArrayList();
                    for (Player player : availablePlayers) {
                        updatedPlayerNames.add(player.getName());
                    }
                    playerNameComboBox.setItems(updatedPlayerNames);

                    // Delete the selected player from the file
                    Admin.buyPlayers(selectedPlayerName);

                    // Example of updating stock alert label
                    int remainingInstances = availablePlayers.size();
                    if (remainingInstances < 10) {
                        warningLabel.setText("Warning: Only " + remainingInstances + " players remaining!");
                    } else if (remainingInstances <= 0) {
                        warningLabel.setText("Stock Over: No players remaining.");
                    }
                }
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Selected player not found.");
            }
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

    @FXML
    private void restockOnC(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Restock.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Create a new stage
            Stage restockStage = new Stage();
            restockStage.setTitle("Restock Report"); // Set the title
            restockStage.setScene(scene);

            // Show the stage
            restockStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void gwnwrateBarChartOnClick(ActionEvent event) {
        Client.generateBarChart(barchart, availablePlayers);
    }

    @FXML
    private void generatePiChartOnCLick(ActionEvent event) {
        Client.generatePieChart(pichart, availablePlayers);
    }
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
