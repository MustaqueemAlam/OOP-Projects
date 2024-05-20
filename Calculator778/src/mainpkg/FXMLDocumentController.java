package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Mustaqueem Alam
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField valueofX;
    @FXML
    private TextField valueofY;
    @FXML
    private Button addButton;
    @FXML
    private Button subtractButton;
    @FXML
    private Button findModuleButton;
    @FXML
    private TextField ResultFeild;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button divideButton;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickonADD(MouseEvent event) {
                String xStr ,yStr,resultStr;
        xStr = valueofX.getText();
        yStr = valueofY.getText();
        int xVal,yVal,resultVal;
        xVal=  Integer.parseInt(xStr);
        yVal=  Integer.parseInt(yStr);
        resultVal = xVal + yVal;
        resultStr= Integer.toString(resultVal);
        ResultFeild.setText(resultStr);
    }

    @FXML
    private void clickOnSubtract(MouseEvent event) {
        String xStr, yStr, resultStr;
        xStr = valueofX.getText();
        yStr = valueofY.getText();
        int xVal, yVal, resultVal;
        xVal = Integer.parseInt(xStr);
        yVal = Integer.parseInt(yStr);
        resultVal = xVal - yVal;
        resultStr = Integer.toString(resultVal);
        ResultFeild.setText(resultStr);
    }

    @FXML
    private void clickOnFindModule(MouseEvent event) {
         String xStr, yStr, resultStr;
        xStr = valueofX.getText();
        yStr = valueofY.getText();
        int xVal, yVal, resultVal;
        xVal = Integer.parseInt(xStr);
        yVal = Integer.parseInt(yStr);
        resultVal = xVal % yVal;
        resultStr = Integer.toString(resultVal);
        ResultFeild.setText(resultStr);
    }

    @FXML
    private void clickOnMultiply(MouseEvent event) {
              String xStr, yStr, resultStr;
        xStr = valueofX.getText();
        yStr = valueofY.getText();
        int xVal, yVal, resultVal;
        xVal = Integer.parseInt(xStr);
        yVal = Integer.parseInt(yStr);
        resultVal = xVal*yVal;
        resultStr = Integer.toString(resultVal);
        ResultFeild.setText(resultStr);
    }

    @FXML
    private void clickonDivide(MouseEvent event) {
              String xStr, yStr, resultStr;
        xStr = valueofX.getText();
        yStr = valueofY.getText();
        int xVal, yVal, resultVal;
        xVal = Integer.parseInt(xStr);
        yVal = Integer.parseInt(yStr);
        resultVal = xVal/yVal;
        resultStr = Integer.toString(resultVal);
        ResultFeild.setText(resultStr);
    }
    
}
