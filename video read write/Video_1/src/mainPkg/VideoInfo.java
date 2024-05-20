// VideoInfo.java
package mainPkg;

import java.io.Serializable;

public class VideoInfo implements Serializable {
    private String title;
    private byte[] videoData;

    public VideoInfo(String title, byte[] videoData) {
        this.title = title;
        this.videoData = videoData;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getVideoData() {
        return videoData;
    }

    public void setVideoData(byte[] videoData) {
        this.videoData = videoData;
    }
}
