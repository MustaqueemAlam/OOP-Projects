/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_pkg;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.util.HashMap;
import java.util.Map;

public class Registrar {
    private static final Map<String, Integer> departmentFacultyCounts = new HashMap<>();

    public static ObservableList<PieChart.Data> viewFacultyRatio() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
        for (Map.Entry<String, Integer> entry : departmentFacultyCounts.entrySet()) {
            pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }

        return pieChartData;
    }

    public static void addNewFacultyAndUpdateChart(Faculty newFaculty) {
        String department = newFaculty.getDepartment();
        departmentFacultyCounts.put(department, departmentFacultyCounts.getOrDefault(department, 0) + 1);
    }
}
