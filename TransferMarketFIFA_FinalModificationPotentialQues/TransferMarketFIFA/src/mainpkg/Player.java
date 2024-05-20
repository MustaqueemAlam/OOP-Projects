/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author Mustaqueem Alam
 */
import java.io.Serializable;
import java.time.LocalDate;

public class Player implements Serializable{
    private String name;
    private String position;
    private double price;
    private LocalDate dateOfScheduling;

    public Player(String name, String position, double price, LocalDate dateOfScheduling) {
        this.name = name;
        this.position = position;
        this.price = price;
        this.dateOfScheduling = dateOfScheduling;
    }

    // Getters and setters for the properties
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDateOfScheduling() {
        return dateOfScheduling;
    }

    public void setDateOfScheduling(LocalDate dateOfScheduling) {
        this.dateOfScheduling = dateOfScheduling;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", price=" + price +
                ", dateOfScheduling=" + dateOfScheduling +
                '}';
    }
}
