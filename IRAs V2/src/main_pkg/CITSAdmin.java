/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_pkg;

import java.io.EOFException;
import java.time.LocalDate;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cis101
 */
public class CITSAdmin {
    public static boolean writeObjectsToFile(List<Object> objects, String fileName) {
           try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
               for (Object obj : objects) {
                   oos.writeObject(obj);
               }
               return true;
           } catch (IOException ex) {
               ex.printStackTrace();
               return false;
           }
       }

       // Deserialize objects from the specified file
       public static List<Object> readObjectsFromFile(String fileName) {
           List<Object> objects = new ArrayList<>();
           try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
               while (true) {
                   try {
                       Object obj = ois.readObject();
                       if (obj != null) {
                           objects.add(obj);
                       }
                   } catch (EOFException e) {
                       break; // End of file reached
                   }
               }
           } catch (IOException | ClassNotFoundException ex) {
               ex.printStackTrace();
           }
           return objects;
       }

       public static boolean addNewFaculty(Faculty faculty, String fileName) {
           List<Object> faculties = readObjectsFromFile(fileName);
           faculties.add(faculty);
           return writeObjectsToFile(faculties, fileName);
       }
   }


