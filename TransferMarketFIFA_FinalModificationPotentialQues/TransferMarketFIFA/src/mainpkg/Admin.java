/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

public class Admin {

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

    public static List<Object> readObjectsFromFile(String fileName) {
        List<Object> objects = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
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
    public static void writePlayerDataToFile(List<Player> players, String fileName) {
            List<Object> playerList = new ArrayList<>(players);
            writeObjectsToFile(playerList, fileName);
    }
    public static void buyPlayers(String playerName) {
        List<Object> objectList = readObjectsFromFile("players.bin");
        List<Object> updatedObjectList = new ArrayList<>();

        for (Object obj : objectList) {
            if (!(obj instanceof Player) || !((Player) obj).getName().equals(playerName)) {
                updatedObjectList.add(obj);
            }
        }

        writeObjectsToFile(updatedObjectList, "players.bin");
    }

}