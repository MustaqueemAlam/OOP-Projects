/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Mustaqueem Alam
 */
public class UploadController implements Initializable {

    @FXML
    private TextField titleField;
    private FileChooser fileChooser;
    private static final String VIDEOS_FOLDER = "videos";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("MP4 Files", "*.mp4"));
        createVideosFolderIfNotExists();
    }

    private void createVideosFolderIfNotExists() {
        File folder = new File(VIDEOS_FOLDER);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    @FXML
    private void chooseVideo(ActionEvent event) {
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            titleField.setText(selectedFile.getName());
        }

    }

    @FXML
    private void uploadVideo(ActionEvent event) {
        String title = titleField.getText();
        if (title.isEmpty()) {
            showAlert("Error", "Please enter a title.");
            return;
        }

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile == null) {
            showAlert("Error", "Please select a video file.");
            return;
        }

        try {
            byte[] videoData = Files.readAllBytes(selectedFile.toPath());
            VideoInfo videoInfo = new VideoInfo(title, videoData);
            String fileName = VIDEOS_FOLDER + File.separator + title + ".bin";
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(videoInfo);
            oos.close();
            fos.close();
            showAlert("Success", "Video uploaded successfully.");
        } catch (IOException e) {
            showAlert("Error", "Failed to upload video.");
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
