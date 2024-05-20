
package mainpkg;

import java.util.ArrayList;

public class Employee {
    int id, salary;
    String name, gender, department, designation, dob, doj, infoStr;
    public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    
    public Employee(int id, String name, String gender, String department, String designation, int salary, String dob, String doj) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.dob = dob;
        this.doj = doj;
        employeeList.add(this);
    }
    
    public String getDetails() {
        infoStr = "ID: " + id + 
                  ", Name: " + name + 
                  ", Gender: " + gender + 
                  ", Dept: " + department + 
                  ", Desig: " + designation + 
                  ", Salary: " + salary + 
                  ", Dob: " + dob + 
                  ", Doj: " + doj + "\n";
        
        return infoStr;
    }

    public static String Data = " ";
 
}
