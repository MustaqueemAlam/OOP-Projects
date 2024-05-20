import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

public class AlertSceneController implements Initializable {
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int[] arr = {11,22,33,44,55};
        //System.out.println(arr[5]);
        try {
            FileInputStream fis = new FileInputStream("abc.bin");
            // TODO
        } catch (FileNotFoundException e) {
            //System.out.println(e);
            e.printStackTrace();
        }
        
        
        
    }    

    @FXML
    private void alert1ButtonOnClick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Warning Alert");
        a.setContentText("This is a simple warning message!");
        a.setHeaderText(null);
        a.showAndWait();           
    }

    @FXML
    private void alert2ButtonOnClick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Dessemination of Notice...");
        a.setContentText("There might be an exam soon. Get prepared.");
        a.showAndWait();         
    }

    @FXML
    private void alert3ButtonOnClick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Alert on exception!");
                
        Exception e = new FileNotFoundException("Illegal file access attemt");
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        
        //PrintStream myOut; myOut = new PrintStream(sw);   //error       
        //e.printStackTrace(myOut);     //error
        
        a.setContentText("Oops! "+ e.getClass().getName() +" occured....");
        
        TextArea exceptionTextArea = new TextArea(sw.toString());
        a.getDialogPane().setExpandableContent(exceptionTextArea);
        a.showAndWait();   
    }

    @FXML
    private void alert4ButtonOnClick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirm your opinion...");
        a.setContentText("Are you sure to <yourTaskName> ?");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
            //you need to write the code to perform the actual task 
            showCustomInformationAlert("The task is performed.");
        }
        else{
            //show appropriate cancellation message
            showCustomInformationAlert("The task is cancelled!"); 
        }
    }



    @FXML
    private void alert5ButtonOnClick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirmation Alert with Custom Actions...");
        a.setContentText("Choose your option below:");
        
        ButtonType buttonTypeOne = new ButtonType("One");
        ButtonType buttonTypeTwo = new ButtonType("Two");
        ButtonType buttonTypeThree = new ButtonType("Three");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        
        a.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);
        
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == buttonTypeOne){
            //you need to write the code to perform the actual task 
            showCustomInformationAlert("Custom choice one is performed.");
        }
        else if(result.get() == buttonTypeTwo){
            //you need to write the code to perform the actual task 
            showCustomInformationAlert("Custom choice two is performed.");
        }
        else if(result.get() == buttonTypeThree){
            //you need to write the code to perform the actual task 
            showCustomInformationAlert("Custom choice three is performed.");
        }
        else{
            //show appropriate cancellation message
            showCustomInformationAlert("None of the custom tasks is chosen!"); 
        }        
    }
 
    @FXML
    private void alert6ButtonOnClick(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input Alert");
        dialog.setHeaderText("Enter OTP");
        dialog.setContentText("User authenticity need to be established to open the file. Please enter the OTP sent to your registered mobile.");
     
        Optional<String> result = dialog.showAndWait();
        if(result.isPresent()){
            //you need to write the code to verify OTP for authenticity and open the file 
            showCustomInformationAlert("OTP verified. File is loaded and ready to view.");
        }
        else {
            //you need to write the code to perform the actual task 
            showCustomInformationAlert("File opening aborted! ");
        }        
    }
    private void showCustomInformationAlert(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();         
    }    

    @FXML
    private void alert7ButtonOnClick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error Alert");
        a.setHeaderText("Fatal Error!");
        a.setContentText("Oops! Something went wrong...");
        a.showAndWait();        
    }
}
