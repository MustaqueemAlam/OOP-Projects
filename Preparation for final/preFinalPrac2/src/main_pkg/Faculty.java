/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_pkg;

/**
 *
 * @author cis101
 */


import java.io.Serializable;
import java.time.LocalDate;
   
    public class Faculty extends User implements Serializable{
       private String Designation,Department;
       private Float Salary;

  
    public Faculty(){
    }
    
    public Faculty(int id,String name,String Designation,String Department,Float Salary, LocalDate dob){
        this.id = id;
        this.name = name;
        this.Designation = Designation;
        this.Department = Department;
        this.Salary = Salary;
        this.dob = dob;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public Float getSalary() {
        return Salary;
    }

    public void setSalary(Float Salary) {
        this.Salary = Salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Faculty{id=" + id +",name=" + name+
                ", dob=" + dob + ",Designation=" +
                Designation + ", Department=" + Department + ", Salary=" + Salary + "}\n";
  

    }

 
    
    
    
}

