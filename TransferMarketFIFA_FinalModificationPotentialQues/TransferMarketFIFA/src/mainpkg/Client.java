/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Mustaqueem Alam
 */
public class Client {
        public static void generateBarChart(BarChart<String, Number> barChart, List<Player> players) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Player Positions");
        yAxis.setLabel("Number of Players");
        barChart.setTitle("Player Positions Distribution");

        // Count the number of players in each position
        int forwardCount = 0;
        int midfielderCount = 0;
        int defenderCount = 0;
        int goalkeeperCount = 0;

        for (Player player : players) {
            switch (player.getPosition()) {
                case "Forward":
                    forwardCount++;
                    break;
                case "Midfielder":
                    midfielderCount++;
                    break;
                case "Defender":
                    defenderCount++;
                    break;
                case "Goalkeeper":
                    goalkeeperCount++;
                    break;
            }
        }

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Forward", forwardCount));
        series.getData().add(new XYChart.Data<>("Midfielder", midfielderCount));
        series.getData().add(new XYChart.Data<>("Defender", defenderCount));
        series.getData().add(new XYChart.Data<>("Goalkeeper", goalkeeperCount));

        barChart.getData().add(series);
    }

    public static void generatePieChart(PieChart pieChart, List<Player> players) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        // Count the number of players in each position
        int forwardCount = 0;
        int midfielderCount = 0;
        int defenderCount = 0;
        int goalkeeperCount = 0;

        for (Player player : players) {
            switch (player.getPosition()) {
                case "Forward":
                    forwardCount++;
                    break;
                case "Midfielder":
                    midfielderCount++;
                    break;
                case "Defender":
                    defenderCount++;
                    break;
                case "Goalkeeper":
                    goalkeeperCount++;
                    break;
            }
        }

        pieChartData.add(new PieChart.Data("Forward", forwardCount));
        pieChartData.add(new PieChart.Data("Midfielder", midfielderCount));
        pieChartData.add(new PieChart.Data("Defender", defenderCount));
        pieChartData.add(new PieChart.Data("Goalkeeper", goalkeeperCount));

        pieChart.setData(pieChartData);
        pieChart.setTitle("Player Positions Distribution");
    }
    
    
}
