
package Mainpkg;
import java.time.LocalDate;

public class Employee {
    private int ID;
    private String name;
    private int Salary;
    private String designation;
    private String department;
    private LocalDate DOJ;
    private String Gender;
    private LocalDate DOB;
    
    public Employee(int ID,String name,int Salary,String designation,String department,LocalDate DOJ,String Gender,LocalDate DOB){
        this.ID=ID;
        this.name=name;
        this.Salary=Salary;
        this.designation=designation;
        this.department=department;
        this.DOJ=DOJ;
        this.Gender=Gender;
        this.DOB=DOB;
    }
        public int getID() {
        return ID;
    }
    
    public String getName() {
        return name;
    }
    public int getsalary(){
        return Salary;
    }
    public String getdesignation(){
        return designation;
    }
    public String getdepartment(){
        return department;
    }
     public LocalDate getDOJ(){
        return DOJ;
    }
     public String getGender(){
         return Gender;
     }
      public LocalDate getDOB(){
        return DOB;
    }
      
 
}
