/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Mustaqueem Alam
 */
public class CalculateScController implements Initializable {

    @FXML
    private TextArea inputTextArea;
    
    private StringBuilder inputBuffer = new StringBuilder();
    private double result = 0.0;
    private String operator = "";
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void clearInput(ActionEvent event) {
        inputBuffer.setLength(0);
        inputTextArea.clear();
    }

    @FXML
    private void calculateResult(ActionEvent event) {
        String input = inputBuffer.toString();
        String[] tokens = input.split("(?<=[-+*/])|(?=[-+*/])");
        try {
            if (tokens.length >= 3) {
                double firstOperand = Double.parseDouble(tokens[0]);
                String currentOperator = tokens[1];
                double secondOperand = Double.parseDouble(tokens[2]);
                double result = performCalculation(firstOperand, currentOperator, secondOperand);
                for (int i = 3; i < tokens.length; i += 2) {
                    currentOperator = tokens[i - 1];
                    secondOperand = Double.parseDouble(tokens[i]);
                    result = performCalculation(result, currentOperator, secondOperand);
                }
                inputTextArea.setText(Double.toString(result));
                inputBuffer.setLength(0);
                inputBuffer.append(result);
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid Input", "Please enter valid numbers and operators.");
        }
    }

    private double performCalculation(double firstOperand, String operator, double secondOperand) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    showAlert("Error", "Division by zero", "You cannot divide by zero.");
                }
        }
        return 0;
    }
    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    private void handleNumberButtonClick(String number) {
       inputBuffer.append(number);
       inputTextArea.setText(inputBuffer.toString());
    }
    private void handleOperatorButtonClick(String operator) {
        this.operator = operator;
        inputBuffer.append(operator);
        inputTextArea.setText(inputBuffer.toString());
    }


    @FXML
    private void SevenButtonClick(ActionEvent event) {
        handleNumberButtonClick("7");
    }

    @FXML
    private void EightButtonClick(ActionEvent event) {
        handleNumberButtonClick("8");
    }

    @FXML
    private void NineButtonClick(ActionEvent event) {
        handleNumberButtonClick("9");
    }

    @FXML
    private void DivideButtonClick(ActionEvent event) {
        handleOperatorButtonClick("/");
        
    }

    @FXML
    private void FourButtonClick(ActionEvent event) {
        handleNumberButtonClick("4");
    }

    @FXML
    private void FiveButtonClick(ActionEvent event) {
        handleNumberButtonClick("5");
    }

    @FXML
    private void SixButtonClick(ActionEvent event) {
        handleNumberButtonClick("6");
    }

    @FXML
    private void MultiplyButtonClick(ActionEvent event) {
        handleOperatorButtonClick("*");
    }

    @FXML
    private void OneButtonClick(ActionEvent event) {
        handleNumberButtonClick("1");
    }

    @FXML
    private void TwoButtonClick(ActionEvent event) {
        handleNumberButtonClick("2");
    }

    @FXML
    private void ThreeButtonClick(ActionEvent event) {
        handleNumberButtonClick("3");
    }

    @FXML
    private void SubtractButtonClick(ActionEvent event) {
        handleOperatorButtonClick("-");
    }

    @FXML
    private void ZeroButtonClick(ActionEvent event) {
        handleNumberButtonClick("0");
    }

    @FXML
    private void AddButtonClick(ActionEvent event) {
        handleOperatorButtonClick("+");
    }
    
    
}
