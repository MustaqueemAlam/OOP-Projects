package mainPkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author cis101
 */
public class TestScController implements Initializable {

    @FXML
    private TextField supplierIDtextfeild;
    @FXML
    private TextField supplierNameTextFeild;
    @FXML
    private ComboBox<String> employeeComboBox;
    @FXML
    private RadioButton BangladeshiRadioButton;
    @FXML
    private RadioButton NonBangladeshiRadioButton;
    @FXML
    private TextArea AdressTextArea;
    @FXML
    private DatePicker dateOfEnlishmentDatePicker;

    private TableView<Supplier> tableView;
    @FXML
    private TableColumn<Supplier, Integer> idCol;
    @FXML
    private TableColumn<Supplier, String> nameCol;
    @FXML
    private TableColumn<Supplier, String> nationalityCol;
    @FXML
    private TableColumn<Supplier, String> employeeCol;
    @FXML
    private TableColumn<Supplier, LocalDate> dateOFEnCol;
    @FXML
    private TableColumn<Supplier, String> adressCol;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private TableView<Supplier> tableview;
    @FXML
    private ComboBox<String> countryComboBox;
    @FXML
    private PieChart pieChart;
    @FXML
    private TextArea readreportTextarea;

    private ObservableList<Supplier> displayedSuppliers = FXCollections.observableArrayList();
    @FXML
    private RadioButton AllRadioButton;

    private ToggleGroup nationalityToggleGroup = new ToggleGroup();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nationalityCol.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        employeeCol.setCellValueFactory(new PropertyValueFactory<>("empId"));
        dateOFEnCol.setCellValueFactory(new PropertyValueFactory<>("dateOfEnlishment"));
        adressCol.setCellValueFactory(new PropertyValueFactory<>("adress"));
        countryComboBox.getItems().addAll("India", "Srilanka", "Bangladesh", "Nepal", "Pakistan", "Bhutan");
        employeeComboBox.getItems().addAll("employeeA", "employeeB", "employeeC");
        BangladeshiRadioButton.setToggleGroup(nationalityToggleGroup);
        NonBangladeshiRadioButton.setToggleGroup(nationalityToggleGroup);
        AllRadioButton.setToggleGroup(nationalityToggleGroup);

        List<Object> objectList = Employee.readObjectsFromFile("suppliers.bin");
        for (Object obj : objectList) {
            if (obj instanceof Supplier) {
                displayedSuppliers.add((Supplier) obj);
            }
        }
        tableview.setItems(displayedSuppliers);
    }

    @FXML
    private void AddToTableView(ActionEvent event) {
        int Sid;
        String Sname = supplierNameTextFeild.getText();
        String Snationality = countryComboBox.getValue();
        String SempId = employeeComboBox.getValue();
        LocalDate SdateOfEnlishment;
        String Sadress = AdressTextArea.getText();
        try {
            Sid = Integer.parseInt(supplierIDtextfeild.getText());
            if (!isSupplierNumberUnique(Sid)) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Supplier no. number must be unique.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Product number must be a valid integer.");
            return;
        }

        SdateOfEnlishment = dateOfEnlishmentDatePicker.getValue();
        if (SdateOfEnlishment == null || SdateOfEnlishment.isAfter(LocalDate.now())) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please select a valid Date of Enlishment.");
            return;
        }
        if (Sname.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Supplier name cannot be empty.");
            return;
        }
        if (Sadress.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Address cannot be empty.");
            return;
        }
        if (Snationality == null || SempId == null) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please select nationality and employee.");
            return;
        }
        if (SdateOfEnlishment == null || SdateOfEnlishment.isAfter(LocalDate.now())) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please select a valid Date of Establishment.");
            return;
        }
        if (supplierIDtextfeild.getText().isEmpty() || Sname.isEmpty() || Snationality == null || SempId == null
                || SdateOfEnlishment == null || Sadress.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please fill in all fields.");
            return;
        }
        Supplier newSupplier = new Supplier(Sid, Sname, Snationality, Sadress, SdateOfEnlishment, SempId);
        displayedSuppliers.add(newSupplier);

        Employee.writeSupplierDataToFile(displayedSuppliers, "suppliers.bin");
        showAlert(Alert.AlertType.INFORMATION, "Success", "Supplier added successfully.");
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void loadTableViewOnClick(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) nationalityToggleGroup.getSelectedToggle();
        String selectedEmployee = employeeComboBox.getValue();

        if (selectedEmployee == null || selectedRadioButton == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select an employee and nationality.");
            return;
        }

        String nationality = selectedRadioButton == BangladeshiRadioButton ? "Bangladesh"
                : selectedRadioButton == NonBangladeshiRadioButton ? "NonBangladeshi" : "All";

        List<Supplier> allSuppliers = Employee.readSuppliersFromFile("suppliers.bin");
        List<Supplier> filteredSuppliers = new ArrayList<>();

        for (Supplier supplier : allSuppliers) {
            boolean matchesEmployee = selectedEmployee.equals("All") || supplier.getEmpId().equals(selectedEmployee);
            boolean matchesNationality = nationality.equals("All")
                    || (nationality.equals("NonBangladeshi") && !supplier.getNationality().equals("Bangladesh"))
                    || supplier.getNationality().equals(nationality);

            if (matchesEmployee && matchesNationality) {
                filteredSuppliers.add(supplier);
            }
        }

        // Apply sorting logic
        filteredSuppliers.sort(Comparator.comparing(Supplier::getName));

        ObservableList<Supplier> observableList = FXCollections.observableArrayList(filteredSuppliers);
        tableview.setItems(observableList);
    }

    private boolean isSupplierNumberUnique(int Supid) {
        for (Supplier supplier : displayedSuppliers) {
            if (supplier.getId() == Supid) {
                return false;
            }
        }
        return true;
    }

    @FXML
    private void reportGenerateOnClick(ActionEvent event) {
         ObservableList<Supplier> displayedSuppliers = tableview.getItems();

    if (displayedSuppliers.isEmpty()) {
        showAlert(Alert.AlertType.ERROR, "Error", "No suppliers to generate a report.");
        return;
    }

    Employee.writeSupplierDataToFile(displayedSuppliers, "SupplierReport.bin");
    showAlert(Alert.AlertType.INFORMATION, "Success", "Report generated successfully.");

    }

    @FXML
    private void readReportTExtArea(ActionEvent event) {
        String selectedFileName = "SupplierReport.bin";
        List<Object> objects = Employee.readObjectsFromFile(selectedFileName);
        StringBuilder contentBuilder = new StringBuilder();
        for (Object obj : objects) {
            if (obj instanceof Supplier) {
                contentBuilder.append(((Supplier) obj).toString()).append("\n");
            }
        }
        readreportTextarea.setText(contentBuilder.toString());
    }

    @FXML
    private void piChartOnClick(ActionEvent event) {
        if (displayedSuppliers.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "No suppliers to display in Pie Chart.");
            return;
        }
        pieChart.getData().clear();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        int countEmployeeA = 0;
        int countEmployeeB = 0;
        int countEmployeeC = 0;

        for (Supplier supplier : displayedSuppliers) {
            if ("employeeA".equals(supplier.getEmpId())) {
                countEmployeeA++;
            } else if ("employeeB".equals(supplier.getEmpId())) {
                countEmployeeB++;
            } else if ("employeeC".equals(supplier.getEmpId())) {
                countEmployeeC++;
            }
        }
        pieChartData.add(new PieChart.Data("Employee A", countEmployeeA));
        pieChartData.add(new PieChart.Data("Employee B", countEmployeeB));
        pieChartData.add(new PieChart.Data("Employee C", countEmployeeC));
        pieChart.setData(pieChartData);
    }

    @FXML
    private void barchartOnClick(ActionEvent event) {

        if (displayedSuppliers.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "No suppliers to display in Bar Chart.");
            return;
        }

        barChart.getData().clear();

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        int countEmployeeA = 0;
        int countEmployeeB = 0;
        int countEmployeeC = 0;

        for (Supplier supplier : displayedSuppliers) {
            if ("employeeA".equals(supplier.getEmpId())) {
                countEmployeeA++;
            } else if ("employeeB".equals(supplier.getEmpId())) {
                countEmployeeB++;
            } else if ("employeeC".equals(supplier.getEmpId())) {
                countEmployeeC++;
            }

        }

        series.getData().add(new XYChart.Data<>("Employee A", countEmployeeA));
        series.getData().add(new XYChart.Data<>("Employee B", countEmployeeB));
        series.getData().add(new XYChart.Data<>("Employee C", countEmployeeC));

        barChart.getData().add(series);

    }

    @FXML
    private void formatTableViewDSataOnClick(ActionEvent event) {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Are you sure?");
        confirmationAlert.setContentText("This action will erase the data in the bin file. Continue?");

        ButtonType result = confirmationAlert.showAndWait().orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK) {

            displayedSuppliers.clear();
            Employee.writeSupplierDataToFile(displayedSuppliers, "suppliers.bin");

            showAlert(Alert.AlertType.INFORMATION, "Success", "TableView data cleared successfully.");
        }
    }

    @FXML
    private void loaddAllDataFromBinFileOnClicks(ActionEvent event) {
        List<Supplier> allSuppliers = Employee.readSuppliersFromFile("suppliers.bin");

        if (allSuppliers.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "No suppliers found in the bin file.");
            return;
        }

        allSuppliers.sort(Comparator.comparing(Supplier::getName));

        ObservableList<Supplier> observableList = FXCollections.observableArrayList(allSuppliers);
        tableview.setItems(observableList);
    }
}
