/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main_pkg;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author cis101
 */
public class PieChartFacultyDistributionController implements Initializable {

        @FXML
    private TableColumn<Faculty, Integer> FacultyCountCol;
    @FXML
    private TableColumn<Faculty, String> DepartmentColumn;
    @FXML
    private TableColumn<Faculty, String> DesignationColumn;
    @FXML
    private TableView<Faculty> tableView;
    @FXML
    private ComboBox<String> departmentComboBox;
    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private PieChart pieChart;
    
    private final String fileName = "Faculty.bin";
    private ObservableList<Faculty> facultyData = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        departmentComboBox.getItems().addAll("CSE", "EEE", "Physics", "Mathematics");
        designationComboBox.getItems().addAll("Lecturer", "Associate Professor", "Senior Lecturer");
    }

    @FXML
    private void generateReportOnClick(ActionEvent event) {
        String selectedDepartment = departmentComboBox.getValue();
        String selectedDesignation = designationComboBox.getValue();
        
        if (selectedDepartment != null && !selectedDepartment.isEmpty() &&
            selectedDesignation != null && !selectedDesignation.isEmpty()) {
            
            List<Object> facultyObjects = CITSAdmin.readObjectsFromFile(fileName);
            
            int selectedCount = 0;
            int totalCount = 0;
            
            for (Object obj : facultyObjects) {
                if (obj instanceof Faculty) {
                    Faculty faculty = (Faculty) obj;
                    if (faculty.getDepartment().equals(selectedDepartment) &&
                        faculty.getDesignation().equals(selectedDesignation)) {
                        selectedCount++;
                    }
                    if (faculty.getDepartment().equals(selectedDepartment)) {
                        totalCount++;
                    }
                }
            }
            
            double selectedRatio = (double) selectedCount / totalCount;
            
            updateTableView(selectedCount);
            updatePieChart(selectedRatio, selectedDesignation, selectedCount, totalCount);
        }
    }

    private void updateTableView(int selectedCount) {
        facultyData.clear();
        
        Faculty faculty = new Faculty();
        faculty.setDepartment(departmentComboBox.getValue());
        faculty.setDesignation(designationComboBox.getValue());
        faculty.setId(selectedCount);
        
        facultyData.add(faculty);
        
        DepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        DesignationColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));
        FacultyCountCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        tableView.setItems(facultyData);
    }
    
    private void updatePieChart(double selectedRatio, String selectedName, int selectedCount, int totalCount) {
        pieChart.getData().clear();

        String selectedLabel = selectedName + " (" + selectedCount + " out of " + totalCount + ")";
        PieChart.Data selectedData = new PieChart.Data(selectedLabel, selectedRatio);
        PieChart.Data otherData = new PieChart.Data("Others", 1 - selectedRatio);

        pieChart.getData().addAll(selectedData, otherData);
        pieChart.setLegendVisible(true);
    }


}