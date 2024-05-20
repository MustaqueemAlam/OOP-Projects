
package Mainpkg;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;




public class MainController implements Initializable {
    ToggleGroup toggleGroup = new ToggleGroup();


    @FXML
    private TextField idtextfield;
    @FXML
    private TextField nametextfield;
    @FXML
    private TextArea displaytextfield;
    @FXML
    private Button savebuttonon;
    private List<Employee> datalist= new ArrayList<>();
    @FXML
    private Label totalstudentlabel;
    @FXML
    private TextField salarytextfield;
    @FXML
    private ComboBox<String> designationbox;
    @FXML
    private ComboBox<String> departmentbox;
    @FXML
    private DatePicker datepicker;
    @FXML
    private RadioButton maleradiobutton;
    @FXML
    private RadioButton femaleradiobutton;
    @FXML
    private DatePicker datepicker1;
    @FXML
    private ComboBox<String> Departmentbox2;
    @FXML
    private TextField Lowersalarytextfield;
    @FXML
    private TextField Uppersalarytextfield;
    @FXML
    private Button savebuttonon1;
    @FXML
    private TextArea Displayaveragetextarea;
    private ArrayList<Integer> datalist2= new ArrayList<>();
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        designationbox.getItems().addAll("Manager","CFO","assistant amnager","general manager","CEO");
        departmentbox.getItems().addAll("Accounts","Sales","Marketing","IT");
        Departmentbox2.getItems().addAll("Accounts","Sales","Marketing","IT");
        maleradiobutton.setToggleGroup(toggleGroup);
        femaleradiobutton.setToggleGroup(toggleGroup);
    }    

    @FXML
    private void savebuttononclick(ActionEvent event) {
         String Gender = "";
        if(maleradiobutton.isSelected()){
             Gender=maleradiobutton.getText();
        }
        else if(femaleradiobutton.isSelected()){
             Gender=femaleradiobutton.getText();
        }
        int ID=Integer.parseInt(idtextfield.getText());
        String name=nametextfield.getText();
        int salary=Integer.parseInt(salarytextfield.getText());
        String designation=designationbox.getValue();
        LocalDate DOJ=datepicker.getValue();
        LocalDate DOB=datepicker1.getValue();
        String department=departmentbox.getValue();
        Employee emp=new Employee( ID, name,salary,designation,department,DOJ,Gender,DOB);
        datalist.add(emp);
        int totalstudents=datalist.size();
        totalstudentlabel.setText("Total no of Students "+totalstudents);
        StringBuilder sb=new StringBuilder();
        for(Employee employee:datalist){
            sb.append("ID: ").append(employee.getID()).append(", Name: ").append(employee.getName())
                    .append(", Salary: ")
                    .append(employee.getsalary()).append(", Designation: ")
                    .append(employee.getdesignation()).append(", Department: ").append(employee.getdepartment())
                    .append(", DOJ: ").append(employee.getDOJ())
                    .append(", DOB: ").append(employee.getDOB())
                    .append(", Gender: ").append(employee.getGender())
                    .append("\n");
        }
         displaytextfield.setText(sb.toString());
        
    }

    @FXML
    private void Averagebutton(ActionEvent event) {
        String dept= Departmentbox2.getValue();
        int lower=Integer.parseInt(Lowersalarytextfield.getText());
        int higher=Integer.parseInt(Uppersalarytextfield.getText());
        int sum=0;
        for(Employee employee:datalist){
            if(employee.getsalary()>=lower && employee.getsalary()<=higher){
                if(employee.getdepartment()==dept){
                    sum=sum+employee.getsalary();
                    datalist2.add(employee.getsalary());
                    
                }
                else{
                   Displayaveragetextarea.setText("The department is not same"); 
                }
        
            }
            else{
              Displayaveragetextarea.setText("OUT OF RANGE MOTHERFATHER");  
            }
        }
        Integer avg=sum/datalist2.size();
        Displayaveragetextarea.setText(avg.toString());
        
    }
    
}
