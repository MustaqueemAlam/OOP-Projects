/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ToggleGroup;
/**
 * FXML Controller class
 *
 * @author cis101
 */


public class FXMLController implements Initializable {
    ToggleGroup toggleGroup = new ToggleGroup();
    @FXML
    private TextField studentIdTextFeild;
    @FXML
    private TextField scholarshipTextFeild;
    @FXML
    private RadioButton YesSchRadioButton;
    @FXML
    private RadioButton NoSchRadioButton;
    @FXML
    private ComboBox<String> SelectCourseComboBox;
    @FXML
    private Label selectCourseComboBox;
    @FXML
    private TextField numberOfcreditsTextFeild;
    @FXML
    private ComboBox<Integer> SelectSectionComboBox;
    @FXML
    private TextArea display1;
    @FXML
    private RadioButton theoryRadioButton;
    @FXML
    private RadioButton LabRadioButton;
    @FXML
    private ComboBox<Integer> selectsSectionComboBoxForDis2;
    @FXML
    private TextArea display2;
    private ArrayList<student> datalist1= new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        YesSchRadioButton.setToggleGroup(toggleGroup);
        NoSchRadioButton.setToggleGroup(toggleGroup);
        theoryRadioButton.setToggleGroup(toggleGroup);
        LabRadioButton.setToggleGroup(toggleGroup);
        SelectCourseComboBox.getItems().addAll("CSE101", "CSE201", "CSE203", "CSE211", "CSE213", "CSE210",
                "ENG101", "ENG102", "ENG105", "MAT104");
        SelectSectionComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        ,11,12,13,14,15,16,17,18,19,20,
        21,22,23,24,25,26,27,28,29,30);
        selectsSectionComboBoxForDis2.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        ,11,12,13,14,15,16,17,18,19,20,
        21,22,23,24,25,26,27,28,29,30);
        // TODO
    }    


    private void AddCourseToRegisterOnClick(ActionEvent event, student student) {

       int studentId= Integer.parseInt(studentIdTextFeild.getText());
        int scholarship=Integer.parseInt(scholarshipTextFeild.getText());
       student= new student(studentId,scholarship);
        datalist1.add(student);
        display1.appendText("Student ID:"+ student.getID() + " Scholarship Percentage " + student.getScholarshipPercentage() + "\n");
        
    }

    @FXML
    private void ProceedToRegisterOnClick(ActionEvent event) {
         int numberOfcreditsTextFeild=Integer.parseInt(studentIdTextFeild.getText());;
        String SelectCourseComboBo1x=SelectCourseComboBox.getValue();
         

        display1.appendText("Course enrolled " + "\n");
    }

    @FXML
    private void Display2OutputButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void selectCourseComboBoxOnClick(MouseEvent event) {
    }

    @FXML
    private void AddCourseToRegisterOnClick(ActionEvent event) {
    }
    
}
