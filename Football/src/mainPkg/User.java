/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Mustaqueem Alam
 */
public class User {
        private ObservableList<FootballPlayer> playerList = FXCollections.observableArrayList();

    public void addFootballPlayer(String name, int age, String position, int goals) {
        FootballPlayer player = new FootballPlayer(name, age, position, goals);
        playerList.add(player);
    }

    public void savePlayersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FootballPlayers.bin"))) {
            oos.writeObject(new ArrayList<>(playerList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<FootballPlayer> loadPlayersFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FootballPlayers.bin"))) {
            List<FootballPlayer> loadedPlayers = (List<FootballPlayer>) ois.readObject();
            playerList.setAll(loadedPlayers);
            return playerList;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return playerList;
        }
    }

    public void generatePDF(Node node, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            WritableImage image = node.snapshot(new SnapshotParameters(), null);
            // Convert image to PDF using a PDF library (e.g., iText)
            // Write image data to the PDF file
            // Handle any exceptions that may occur during PDF creation
            // Display success or error message to the user
        }
    }

    public void updatePieChart(PieChart pieChart, TableView<FootballPlayer> tableView) {
        pieChart.getData().clear();
        
        for (FootballPlayer player : tableView.getItems()) {
            pieChart.getData().add(new PieChart.Data(player.positionProperty().get(), player.goalsProperty().get()));
        }
    }

    public void  clearTableView(TableView<FootballPlayer> tableView) {
        playerList.clear();
    }
}
