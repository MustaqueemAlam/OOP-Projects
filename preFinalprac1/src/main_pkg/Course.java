package main_pkg;

import java.io.Serializable;

public class Course implements Serializable {
    private String courseId;
    private String title;
    private int noOfCredits;
    private String courseType;
    private String courseCategory;

    public Course(String courseId, String title, int noOfCredits, String courseType, String courseCategory) {
        this.courseId = courseId;
        this.title = title;
        this.noOfCredits = noOfCredits;
        this.courseType = courseType;
        this.courseCategory = courseCategory;
    }

    public String getCourseId() {
        return courseId;
    }

    // Other getters and setters as needed

    @Override
    public String toString() {
        return courseId; // Display the courseId in the ComboBox
    }
    
}
