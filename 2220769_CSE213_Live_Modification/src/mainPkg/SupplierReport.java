/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPkg;

import java.io.Serializable;

/**
 *
 * @author cis101
 */
public class SupplierReport implements Serializable{
    private Integer id;

    private String nationality;
    
    private String empName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public SupplierReport(Integer id, String nationality, String empName) {
        this.id = id;
        this.nationality = nationality;
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "SupplierReport{" + "id=" + id + ", nationality=" + nationality + ", empName=" + empName + '}';
    }
    
}
