package mainpkg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    //generate Files
    public static void main(String[] args) {
        // File dir = new File("C:/Users/Mustaqueem Alam/Desktop/Notepad1"); //for add shortcut on desktop
        // String dirLocation= dir.getAbsolutePath(); // for getting folder path
        // System.out.println(dirLocation); 
        // System.out.println(dir.getName());
        File dir = new File("cartitem");
        dir.mkdir();//create file
        File file1 = new File("C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/shopcartmid/cartitem/Product Details.txt");
        File file2 = new File("C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/shopcartmid/cartitem/VAT Details.txt");
        try {
            file1.createNewFile();
            file2.createNewFile();
            System.out.println("Files created SUCCESSFULLY!!!");
        } catch (IOException e) {
            System.out.println(e);
        }

        // Call the method to read and display the text files
        readTextFiles();
    }

    // Method to append data to Product Details.txt
    public static void updateProductDetails(String data) {
        File file1 = new File("C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/shopcartmid/cartitem/Product Details.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1, false))) {
            writer.write(data+"\n"); // Add a new line after each data entry
            System.out.println("Data updated in Product Details.txt successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to Product Details.txt: " + e.getMessage());
        }
    }

    // Method to append data to VAT Details.txt
    public static void updateVATDetails(String data) {
        File file2 = new File("C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/shopcartmid/cartitem/VAT Details.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file2, false))) {
            writer.write(data+"\n"); // Add a new line after each data entry
            System.out.println("Data updated in VAT Details.txt successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to VAT Details.txt: " + e.getMessage());
        }
    }

    // Read TextFiles Method
    public static void readTextFiles() {
        File productDetailsFile = new File("C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/shopcartmid/cartitem/Product Details.txt");
        File vatDetailsFile = new File("C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/shopcartmid/cartitem/VAT Details.txt");

        try {
            // Read Product Details.txt
            BufferedReader productReader = new BufferedReader(new FileReader(productDetailsFile));
            String productLine;
            System.out.println("Contents of Product Details.txt:");
            while ((productLine = productReader.readLine()) != null) {
                System.out.println(productLine);
            }
            productReader.close();

            System.out.println(); // Add a new line for separation

            // Read VAT Details.txt
            BufferedReader vatReader = new BufferedReader(new FileReader(vatDetailsFile));
            String vatLine;
            System.out.println("Contents of VAT Details.txt:");
            while ((vatLine = vatReader.readLine()) != null) {
                System.out.println(vatLine);
            }
            vatReader.close();

        } catch (IOException e) {
            System.out.println("Error reading text files: " + e.getMessage());
        }
    }
}