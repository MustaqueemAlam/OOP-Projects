/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main_pkg;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Mustaqueem Alam
 */
public class ViewFacultyCountController implements Initializable {

    @FXML
    private TableColumn<Faculty, Integer> FacultyCountCol;
    @FXML
    private TableColumn<Faculty, String> DepartmentColumn;
    @FXML
    private TableView<Faculty> tableView;
    @FXML
    private ComboBox<String> departmentcombBox;
    
    private final String fileName = "Faculty.bin";
    private ObservableList<Faculty> facultyData = FXCollections.observableArrayList();
    @FXML
    private PieChart piechart;
    @FXML
    private BarChart<String, Number> barchart;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        departmentcombBox.getItems().addAll("CSE", "EEE", "Physics", "Mathematics");
    }    

    @FXML
    private void departmentcombBoxOnClick(ActionEvent event) {
       String selectedDepartment = departmentcombBox.getValue();
        
        if (selectedDepartment != null && !selectedDepartment.isEmpty()) {
            List<Object> facultyObjects = CITSAdmin.readObjectsFromFile(fileName);
            
            int selectedDepartmentCount = 0;
            int totalFacultyCount = 0;
            
            for (Object obj : facultyObjects) {
                if (obj instanceof Faculty) {
                    Faculty faculty = (Faculty) obj;
                    totalFacultyCount++;
                    if (faculty.getDepartment().equals(selectedDepartment)) {
                        selectedDepartmentCount++;
                    }
                }
            }
            
            Faculty faculty = new Faculty();
            faculty.setDepartment(selectedDepartment);
            faculty.setId(selectedDepartmentCount);
            
            facultyData.clear();
            facultyData.add(faculty);
            
            DepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
            FacultyCountCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            
            tableView.setItems(facultyData);
            
            updatePieChart(selectedDepartmentCount, totalFacultyCount);
            updateBarChart();
        }
    }

    private void updatePieChart(int selectedDepartmentCount, int totalFacultyCount) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        int otherDepartmentsCount = totalFacultyCount - selectedDepartmentCount;

        double selectedRatio = (double) selectedDepartmentCount / totalFacultyCount;
        double otherDepartmentsRatio = (double) otherDepartmentsCount / totalFacultyCount;

        String selectedLabel = "Selected Department (" + selectedDepartmentCount + ")";
        String otherDepartmentsLabel = "Other Departments (" + otherDepartmentsCount + ")";

        pieChartData.add(new PieChart.Data(selectedLabel, selectedRatio));
        pieChartData.add(new PieChart.Data(otherDepartmentsLabel, otherDepartmentsRatio));

        piechart.setData(pieChartData);
        piechart.setLegendVisible(true);
    }
    
    private void updateBarChart() {
        List<Object> facultyObjects = CITSAdmin.readObjectsFromFile(fileName);

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        Map<String, Integer> departmentCountMap = new HashMap<>();

        for (Object obj : facultyObjects) {
            if (obj instanceof Faculty) {
                Faculty faculty = (Faculty) obj;
                departmentCountMap.put(faculty.getDepartment(), departmentCountMap.getOrDefault(faculty.getDepartment(), 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : departmentCountMap.entrySet()) {
            series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        barchart.getData().clear();
        barchart.getData().add(series);
    }
}