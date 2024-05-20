package mainpkg;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class AddEmployeeSceneController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField salaryTextField;
    @FXML
    private TextField lSalBoundTextField;
    @FXML
    private TextField uSalBoundTextField;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private ComboBox<String> departmentComboBox;
    @FXML
    private DatePicker dateOfBirthDatePicker;
    @FXML
    private DatePicker dateOfJoiningDatePicker;
    @FXML
    private ComboBox<String> searchDepartmentComboBox;
    @FXML
    private TextArea outputTextArea1;
    @FXML
    private TextArea outputTextArea2;
    @FXML
    private Label infoLabel;    
    
    
    
    //Declaration of Variables
    ArrayList<Integer> salList = new ArrayList<Integer>();
    Alert anError = new Alert(Alert.AlertType.ERROR);
    ToggleGroup tg = new ToggleGroup();
    String genderStr;
    int i, lSalBound, uSalBound;
    private Button nextsc1button;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);
        maleRadioButton.setSelected(true);
        genderStr = "Male";
        departmentComboBox.getItems().addAll("HR", "Accounts", "Admin", "Marketing");
        designationComboBox.getItems().addAll("HR Manager", "Accountant", "Junior Officer", "Senior Officer", "Director");
        departmentComboBox.setValue("HR");
        designationComboBox.setValue("HR Manager");
    }

    
    @FXML
    private void addEmployeeButtonOnClick(MouseEvent event) {
        String outputStr = "";
        if (idTextField.getText().equals("")) {
            anError.setContentText("Please fill out the missing ID field.");
            anError.showAndWait();
        } else if (nameTextField.getText().equals("")) {
            anError.setContentText("Please fill out the missing Name field.");
            anError.showAndWait();
        } else if (salaryTextField.getText().equals("")) {
            anError.setContentText("Please fill out the missing Salary field.");
            anError.showAndWait();
        } else if (dateOfBirthDatePicker.getValue() == null) {
            anError.setContentText("Please select Date of Birth.");
            anError.showAndWait();
        } else if (dateOfJoiningDatePicker.getValue() == null) {
            anError.setContentText("Please select Date of Joining.");
            anError.showAndWait();
        } else if (dateOfBirthDatePicker.getValue().compareTo(dateOfJoiningDatePicker.getValue()) > 0) {
            anError.setContentText("Date of Birth cannot be after Date of Joining!");
            anError.showAndWait();
        } else {
            Employee newEmployee = new Employee(Integer.parseInt(idTextField.getText()), nameTextField.getText(), genderStr, departmentComboBox.getValue(), designationComboBox.getValue(), Integer.parseInt(salaryTextField.getText()), dateOfBirthDatePicker.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")), dateOfJoiningDatePicker.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
            for (i = 0; i < Employee.employeeList.size(); i++) {
                outputStr += Employee.employeeList.get(i).getDetails();
            }
            outputTextArea1.setText(outputStr);
            infoLabel.setText("Total no. of " + Employee.employeeList.size() + " Employee detail(s) shown below:");

            idTextField.setText("");
            nameTextField.setText("");
            salaryTextField.setText("");
            // Check if the departmentComboBox value is not in the searchDepartmentComboBox
            if (!searchDepartmentComboBox.getItems().contains(departmentComboBox.getValue())) {
                searchDepartmentComboBox.getItems().add(departmentComboBox.getValue());
            }

            EmployeeDetailsArray.getInstance().getEmployeeList().add(newEmployee);
        }
    }
    
    @FXML
    private void maleRadioButtonOnAction(ActionEvent event) {
        genderStr = "Male";
    }
    
    @FXML
    private void femaleRadioButtonOnAction(ActionEvent event) {
        genderStr = "Female";
    }
    
    @FXML
    private void showAvgSalaryButtonOnClick(MouseEvent event) {
        try {
            lSalBound = Integer.parseInt(lSalBoundTextField.getText());
            uSalBound = Integer.parseInt(uSalBoundTextField.getText());
        }
        catch(Exception e) {
            anError.setContentText("Invalid input data type.");
            anError.showAndWait();
        }
        
        if(searchDepartmentComboBox.getValue() == null) {
            anError.setContentText("Select a Search Criteria.");
            anError.showAndWait();
        }
        else {
            for(i=0; i<Employee.employeeList.size(); i++) {
                if(Employee.employeeList.get(i).department.equals(searchDepartmentComboBox.getValue())) {
                    if(Employee.employeeList.get(i).salary > lSalBound && Employee.employeeList.get(i).salary < uSalBound){
                        salList.add(Employee.employeeList.get(i).salary);
                    }
                }
            }
        }
        
        int sumSal = 0, avgSal;
        for(i=0; i<salList.size(); i++) {
            sumSal += salList.get(i);
        }
        avgSal = sumSal/salList.size();
        
        outputTextArea2.setText("The average salary of " + searchDepartmentComboBox.getValue() + " department having salary within " + lSalBound + " and " + uSalBound + " taka is: " + avgSal);
        Employee.Data = ("The average salary of " + searchDepartmentComboBox.getValue() + " department having salary within " + lSalBound + " and " + uSalBound + " taka is: " + avgSal);
        
    }


}
