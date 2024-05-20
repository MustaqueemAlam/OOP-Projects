/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author cis101
 */
public class Supplier implements Serializable{
    private Integer id;
    private String name;
    private String nationality;
    private String adress;
    private LocalDate dateOfEnlishment;
    private String empId ;

    public Supplier(Integer id, String name, String nationality, String adress, LocalDate dateOfEnlishment, String empId) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.adress = adress;
        this.dateOfEnlishment = dateOfEnlishment;
        this.empId = empId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LocalDate getDateOfEnlishment() {
        return dateOfEnlishment;
    }

    public void setDateOfEnlishment(LocalDate dateOfEnlishment) {
        this.dateOfEnlishment = dateOfEnlishment;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Supplier{" + "id=" + id + ", name=" + name + ", nationality=" + nationality + ", adress=" + adress + ", dateOfEnlishment=" + dateOfEnlishment + ", empId=" + empId + '}';
    }
    
}
