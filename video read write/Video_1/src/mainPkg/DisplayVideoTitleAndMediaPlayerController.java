package mainPkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayVideoTitleAndMediaPlayerController implements Initializable {

    @FXML
    private ComboBox<String> titleComboBox;
    @FXML
    private MediaView mediaview;
    private List<VideoInfo> videoInfoList;
    private MediaPlayer mediaPlayer;
    private static final String VIDEOS_FOLDER = "videos";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadVideoTitles();
    }

    private void loadVideoTitles() {
        videoInfoList = new ArrayList<>();
        File folder = new File(VIDEOS_FOLDER);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".bin"));
        if (files != null) {
            for (File file : files) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    VideoInfo videoInfo = (VideoInfo) ois.readObject();
                    videoInfoList.add(videoInfo);
                    titleComboBox.getItems().add(videoInfo.getTitle());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void selectVideoTitle(ActionEvent event) {
        String selectedTitle = titleComboBox.getValue();
        if (selectedTitle != null) {
            for (VideoInfo videoInfo : videoInfoList) {
                if (videoInfo.getTitle().equals(selectedTitle)) {
                    playVideo(videoInfo);
                    break;
                }
            }
        }

    }

    @FXML
    private void playButtonOnClick(ActionEvent event) {
      if (mediaPlayer != null) {
        mediaPlayer.play();
    }
    }

    @FXML
    private void stopButtonOnClick(ActionEvent event) {
    if (mediaPlayer != null) {
        mediaPlayer.stop();
    }
    }

    @FXML
    private void ResumeButtonClick(ActionEvent event) {
     if (mediaPlayer != null) {
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.play();
        }
    }
    }

    private void playVideo(VideoInfo videoInfo) {
        try {
            File tempFile = File.createTempFile("temp", ".bin");
            tempFile.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(tempFile);
            fos.write(videoInfo.getVideoData());
            fos.close();
            Media media = new Media(tempFile.toURI().toString());
            if (mediaPlayer != null) {
                mediaPlayer.dispose();
            }
            mediaPlayer = new MediaPlayer(media);
            mediaview.setMediaPlayer(mediaPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
