package main_pkg;

import java.io.Serializable;

public class RegisteredCourse implements Serializable {
    private String studentId;
    private String courseId;
    private String semester;
    private String sec;

    public RegisteredCourse(String studentId, String courseId, String semester, String sec) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.semester = semester;
        this.sec = sec;
    }

    // Getters and setters as needed
}
