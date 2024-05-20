/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_pkg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Mustaqueem Alam
 */
public class HOD {
        public static boolean saveCourse(Course course, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName, true);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(course);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
