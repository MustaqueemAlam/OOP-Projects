/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;


public class MatrixOperationSceneController implements Initializable {

    @FXML
    private ComboBox<String> operationComboBox;
    @FXML
    private Label elemMat1Label;
    @FXML
    private Label elemMat2Label;
    @FXML
    private TextField elemMat1TextField;
    @FXML
    private TextField elemMat2TextField;
    @FXML
    private RadioButton mat1RadioButton;
    @FXML
    private RadioButton mat2RadioButton;
    @FXML
    private Label outputLabel;
    @FXML
    private ComboBox<Integer> mat1RowComboBox;
    @FXML
    private ComboBox<Integer> mat1ColComboBox;
    @FXML
    private RadioButton bothMatRadioButton;
    @FXML
    private TextField mat2RowTextField;
    @FXML
    private TextField mat2ColTextField;
    @FXML
    private Button addElemM1Button;
    @FXML
    private Button addElemM2Button;    

    private ToggleGroup tg;
    private Alert aError = new Alert(Alert.AlertType.ERROR);
    private Matrix matrix1, matrix2, resultMatrix;
    private int i1 = 0, j1 = 0, i2 = 0, j2 = 0;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //mat1RowComboBox.getItems is a list. So we can chain method it to minimize complications
        mat1RowComboBox.getItems().addAll(2,3,4,5,6,7,8,9,10);
        mat1RowComboBox.setValue(2);
        mat1ColComboBox.getItems().addAll(2,3,4,5,6,7,8,9,10);
        mat1ColComboBox.setValue(2);
        operationComboBox.getItems().addAll("Select Matrix Operation","Addition","Subtraction","Multiplication","Transpose","Inverse");
        operationComboBox.setValue("Select Matrix Operation");
        
        //To group the radio buttons
        tg = new ToggleGroup();
        mat1RadioButton.setToggleGroup(tg);
        mat2RadioButton.setToggleGroup(tg);
        bothMatRadioButton.setToggleGroup(tg);
        
        //To disable the radio buttons by default
        mat1RadioButton.setDisable(true);
        mat2RadioButton.setDisable(true);
        bothMatRadioButton.setDisable(true);
        
    }

    @FXML
    private void operationComboBoxOnSelect(ActionEvent event) {
        if (operationComboBox.getValue().equals("Transpose") || operationComboBox.getValue().equals("Inverse")) {
            mat1RadioButton.setDisable(false);
            mat2RadioButton.setDisable(false);
            bothMatRadioButton.setDisable(false);
        }
        else {
            mat1RadioButton.setDisable(true);
            mat2RadioButton.setDisable(true);
            bothMatRadioButton.setDisable(true);
        }
    }
    
    @FXML
    public void createMatrixButtonOnClick(ActionEvent event) {
        if(mat2RowTextField.getText().equals("") || mat2ColTextField.getText().equals("")) {
            aError.setContentText("Missing matrix dimensions!");
            aError.showAndWait();
        }
        else{
            int nRM1 = mat1RowComboBox.getValue();
            int nCM1 = mat1ColComboBox.getValue();
            int nRM2 = Integer.parseInt(mat2RowTextField.getText());
            int nCM2 = Integer.parseInt(mat2ColTextField.getText());

            matrix1 = new Matrix(nRM1, nCM1);
            matrix2 = new Matrix(nRM2, nCM2);
            outputLabel.setText("Matrix-1:\n" + matrix1.getStringEquivalent() + "\n" + "Matrix-2:\n" + matrix2.getStringEquivalent());
        }
        
        i1 = j1 = i2 = j2 = 0;
        elemMat1Label.setText("Enter " + "[" + i1 + "]" + "[" + j1 + "]" + " element of Matrix-1:");
        elemMat2Label.setText("Enter " + "[" + i2 + "]" + "[" + j2 + "]" + " element of Matrix-1:");
        addElemM1Button.setDisable(false);
        addElemM2Button.setDisable(false);
    }
    
    @FXML
    private void addMat1ElemButtonOnClick(MouseEvent event) {
        int[] mat1Size = matrix1.getMatrixDimension();
        
        matrix1.setMatrixValues(i1, j1, Integer.parseInt(elemMat1TextField.getText()));
        j1++;
        
        if (i1<mat1Size[0] && j1<mat1Size[1]) {
            elemMat1Label.setText("Enter " + "[" + i1 + "]" + "[" + j1 + "]" + " element of Matrix-1:");
        }
        else if(i1<mat1Size[0]-1) {
            j1 = 0;
            i1++;
            elemMat1Label.setText("Enter " + "[" + i1 + "]" + "[" + j1 + "]" + " element of Matrix-1:");
        }
        else {
            elemMat1Label.setText("Insertion Completed");
            addElemM1Button.setDisable(true);
        }
        
        elemMat1TextField.setText("");
        
        outputLabel.setText("Matrix-1:\n" + matrix1.getStringEquivalent() + "\n" + "Matrix-2:\n" + matrix2.getStringEquivalent());
    }
    
    @FXML
    private void addMat2ElemButtonOnClick(MouseEvent event) {
        int[] mat2Size = matrix2.getMatrixDimension();
        
        matrix2.setMatrixValues(i2, j2, Integer.parseInt(elemMat2TextField.getText()));
        j2++;
        
        if (i2<mat2Size[0] && j2<mat2Size[1]) {
            elemMat2Label.setText("Enter " + "[" + i2 + "]" + "[" + j2 + "]" + " element of Matrix-2:");
        }
        else if(i2<mat2Size[0]-1) {
            j2 = 0;
            i2++;
            elemMat2Label.setText("Enter " + "[" + i2 + "]" + "[" + j2 + "]" + " element of Matrix-2:");
        }
        else {
            elemMat2Label.setText("Insertion Completed");
            addElemM2Button.setDisable(true);
        }
        
        elemMat2TextField.setText("");
        outputLabel.setText("Matrix-1:\n" + matrix1.getStringEquivalent() + "\n" + "Matrix-2:\n" + matrix2.getStringEquivalent());
    }

    @FXML
    private void executeButtonOnClick(MouseEvent event) {
        if(operationComboBox.getValue() == "Select Matrix Operation") {
            aError.setContentText("Select an operation first");
            aError.showAndWait();
        }
        
        if(operationComboBox.getValue() == "Addition") {
            resultMatrix = matrix1.addMatrix(matrix2);
            outputLabel.setText("Matrix-1:\n" + matrix1.getStringEquivalent() + "\n" + "Matrix-2:\n" + matrix2.getStringEquivalent() + "\n" + "Result Matrix:\n" + resultMatrix.getStringEquivalent());
        }
            
        if(operationComboBox.getValue() == "Subtraction") {
            resultMatrix = matrix1.subtractMatrix(matrix2);
            outputLabel.setText("Matrix-1:\n" + matrix1.getStringEquivalent() + "\n" + "Matrix-2:\n" + matrix2.getStringEquivalent() + "\n" + "Result Matrix:\n" + resultMatrix.getStringEquivalent());
        }
//        if(operationComboBox.getValue() == "Addition") {
//            resultMatrix = matrix1.additionMatrix(matrix2);
//            outputLabel.setText("Matrix-1:\n" + matrix1.getStringEquivalent() + "\n" + "Matrix-2:\n" + matrix2.getStringEquivalent() + "\n" + "Result Matrix:\n" + resultMatrix.getStringEquivalent());
//
//        if(operationComboBox.getValue() == "Addition") {
//            resultMatrix = matrix1.additionMatrix(matrix2);
//            outputLabel.setText("Matrix-1:\n" + matrix1.getStringEquivalent() + "\n" + "Matrix-2:\n" + matrix2.getStringEquivalent() + "\n" + "Result Matrix:\n" + resultMatrix.getStringEquivalent());
//
//        if(operationComboBox.getValue() == "Addition") {
//            resultMatrix = matrix1.additionMatrix(matrix2);
//            outputLabel.setText("Matrix-1:\n" + matrix1.getStringEquivalent() + "\n" + "Matrix-2:\n" + matrix2.getStringEquivalent() + "\n" + "Result Matrix:\n" + resultMatrix.getStringEquivalent());

    }
    
           
//        mat1Array = new int[3][3]; //mat1Array is now an array instance
//        mat2Array = new int[3][3]; //mat2Array is now an array instance
//        mat3Array = new int[3][3]; //mat3Array is now an array instance
//        int i,j;
//        Random r = new Random();
//        
//        for(i=0;i<mat1Array.length;i++){
//            for(j=0;j<mat1Array[i].length;j++){
//                mat1Array[i][j] = r.nextInt(100);
//                mat2Array[i][j] = r.nextInt(100);
//                mat3Array[i][j] = mat1Array[i][j] + mat2Array[i][j];
//            }
//        }
//        
//        String str = "";
//        str+="Matrix-1:\n";
//        for(i=0;i<mat1Array.length;i++){
//            for(j=0;j<mat1Array[i].length;j++){
//                str+=mat1Array[i][j]+" ";
//            }
//            str += "\n";
//        }
//
//        str+="\nMatrix-2:\n";
//        for(i=0;i<mat2Array.length;i++){
//            for(j=0;j<mat2Array[i].length;j++){
//                str+=mat2Array[i][j]+" ";
//            }
//            str += "\n";
//        }
//        
//        str+="\nAdded Matrix:\n";
//        for(i=0;i<mat3Array.length;i++){
//            for(j=0;j<mat3Array[i].length;j++){
//                str+=mat3Array[i][j]+" ";
//            }
//            str += "\n";
//        }
//        
//        outputLabel.setText(str);
}