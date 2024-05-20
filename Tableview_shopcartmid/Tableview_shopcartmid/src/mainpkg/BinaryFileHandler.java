package mainpkg;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BinaryFileHandler {
    // Generate Files
    public static void main(String[] args) {
        File dir = new File("cartitem");
        dir.mkdir(); // Create directory if not exists
        File file1 = new File("C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/shopcartmid/cartitem/Product Details.bin");
        File file2 = new File("C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/shopcartmid/cartitem/VAT Details.bin");

        try {
            file1.createNewFile();
            file2.createNewFile();
            System.out.println("Binary Files created SUCCESSFULLY!!!");
        } catch (IOException e) {
            System.out.println("Error creating Binary Files: " + e.getMessage());
        }

        // Call the method to read and display the text files
        readTextFiles();
    }

    // Method to append data to Product Details.bin
    public static void updateProductDetails(String data) {
        File file1 = new File("C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/shopcartmid/cartitem/Product Details.bin");
        try (RandomAccessFile raf = new RandomAccessFile(file1, "rw")) {
            raf.seek(file1.length()); // Move the file pointer to the end of the file
            raf.write(data.getBytes()); // Write data as bytes
            System.out.println("Data updated in Product Details.bin successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to Product Details.bin: " + e.getMessage());
        }
    }

    // Method to append data to VAT Details.bin
    public static void updateVATDetails(String data) {
        File file2 = new File("C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/shopcartmid/cartitem/VAT Details.bin");
        try (RandomAccessFile raf = new RandomAccessFile(file2, "rw")) {
            raf.seek(file2.length()); // Move the file pointer to the end of the file
            raf.write(data.getBytes()); // Write data as bytes
            System.out.println("Data updated in VAT Details.bin successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to VAT Details.bin: " + e.getMessage());
        }
    }

    // Read TextFiles Method
    public static void readTextFiles() {
        File productDetailsFile = new File("C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/shopcartmid/cartitem/Product Details.bin");
        File vatDetailsFile = new File("C:/Users/Mustaqueem Alam/Documents/NetBeansProjects/shopcartmid/cartitem/VAT Details.bin");

        try {
            // Read Product Details.bin
            RandomAccessFile productReader = new RandomAccessFile(productDetailsFile, "r");
            byte[] productData = new byte[(int) productReader.length()];
            productReader.readFully(productData);
            String productLine = new String(productData);
            System.out.println("Contents of Product Details.bin:");
            System.out.println(productLine);
            productReader.close();

            System.out.println(); // Add a new line for separation

            // Read VAT Details.bin
            RandomAccessFile vatReader = new RandomAccessFile(vatDetailsFile, "r");
            byte[] vatData = new byte[(int) vatReader.length()];
            vatReader.readFully(vatData);
            String vatLine = new String(vatData);
            System.out.println("Contents of VAT Details.bin:");
            System.out.println(vatLine);
            vatReader.close();

        } catch (IOException e) {
            System.out.println("Error reading binary files: " + e.getMessage());
        }
    }
}
