/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPkg;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author cis101
 */
public class Employee {

    public static boolean writeObjectsToFile(List<Object> objects, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Object obj : objects) {
                oos.writeObject(obj);
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static List<Object> readObjectsFromFile(String fileName) {
        List<Object> objects = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj != null) {
                        objects.add(obj);
                    } else {
                        break; // End of file reached
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

    public static void writeSupplierDataToFile(List<Supplier> suppliers, String fileName) {
        List<Object> supplierList = new ArrayList<>(suppliers);
        writeObjectsToFile(supplierList, fileName);
    }

    public static ArrayList<Supplier> readSuppliersFromFile(String fileName) {
        ArrayList<Supplier> existingSuppliers = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    Supplier supplier = (Supplier) ois.readObject();
                    existingSuppliers.add(supplier);
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return existingSuppliers;
    }

    public static ObservableList<Supplier> ObjectsFromFile(String fileName) {
        ArrayList<Supplier> displayedSuppliers = readSuppliersFromFile(fileName);
        ObservableList<Supplier> observableList = FXCollections.observableArrayList(displayedSuppliers);
        return observableList;
    }
    

}
