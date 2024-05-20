package main_pkg;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FACULTY_DATA_FILE = "facultyData.bin";
    private static final String COURSE_DATA_FILE = "courseData.bin";

    public static void saveFacultyData(List<Faculty> facultyList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FACULTY_DATA_FILE))) {
            oos.writeObject(facultyList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Faculty> loadFacultyData() {
        List<Faculty> facultyList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FACULTY_DATA_FILE))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                facultyList = (List<Faculty>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return facultyList;
    }

    // Method to load course data from the binary file
    public static List<Course> loadCourseData() {
        List<Course> courseList = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Course.bin"))) {
            courseList = (List<Course>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return courseList;
    }

    // Method to save course data to the binary file
    public static void saveCourseData(List<Course> courseList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Course.bin"))) {
            oos.writeObject(courseList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<RegisteredCourse> loadRegisteredCourseData() {
        List<RegisteredCourse> registeredCourseList = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("RegisteredCourse.bin"))) {
            registeredCourseList = (List<RegisteredCourse>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return registeredCourseList;
    }

    public static void saveRegisteredCourseData(List<RegisteredCourse> registeredCourseList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("RegisteredCourse.bin"))) {
            oos.writeObject(registeredCourseList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
