package fxmlapplicationpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileChooserViewController implements Initializable {

    private ArrayList<String> fileTypeList, fileTypeList2;  
    @FXML private Label fileContentLabel;
    @FXML private MenuItem singleFileChooserMenuItem; //extra
    @FXML private TextArea editTextArea;
    @FXML private CheckBox editFileContentCheckBox;
    @FXML private Button saveEtittedTextButton; //Extra
    @FXML private MenuItem multipleFileChooserMenuItem; //extra
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileTypeList = new ArrayList<String>();
        fileTypeList.add("*.txt");
        fileTypeList.add("*.doc");
        fileTypeList.add("*.docx");
        fileTypeList.add("*.TXT");
        fileTypeList.add("*.DOC");
        fileTypeList.add("*.DOCX");

        fileTypeList2 = new ArrayList<String>();
        fileTypeList2.add("*.*");

        editTextArea.setEditable(false);
        
    }
    
    @FXML 
    void singleFileChooserMenuItemOnClick(){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text files", fileTypeList));
        fc.getExtensionFilters().add(new ExtensionFilter("All files", fileTypeList2));
        //File f2 = fc.showSaveDialog(null);
        File f = fc.showOpenDialog(null);
        if(f != null){
            try {
                Scanner sc = new Scanner(f);
                String str="";
                while(sc.hasNextLine()){
                    str+=sc.nextLine()+"\n";
                }
                fileContentLabel.setText(str);
            } catch (FileNotFoundException ex) {
                //Logger.getLogger(FileChooserViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void multipleFileChooserMenuItemOnClick(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text files", fileTypeList));
        List<File> files = fc.showOpenMultipleDialog(null);
        String str="";
        for(File f: files){
            if(f != null){
                try {
                    Scanner sc = new Scanner(f);
                    
                    while(sc.hasNextLine()){
                        str+=sc.nextLine()+"\n";
                    }
                    str+="\n";
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FileChooserViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        fileContentLabel.setText(str);
    }
    
    @FXML
    private void editFileContentCheckBoxOnClick(ActionEvent event) {
        if(editFileContentCheckBox.isSelected()){
            editTextArea.setEditable(true);
            editTextArea.setText(fileContentLabel.getText());
        }
        else{
            editTextArea.setText(null);
            editTextArea.setEditable(false);
        }
    }

    @FXML
    private void saveEtittedTextButtonOnClick(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File f = fc.showSaveDialog(null);
        System.out.println("Edited Content will be written in: "+f.getAbsolutePath());
        //now use f to write text area content to the file
    }
}
