
package mainpkg;

import java.io.Serializable;

public class Employee implements Serializable{
    private int id;
    private String name, desig;
    private float salary;
    public int getId() {
        return id;
    }

    public void submitReport(){}
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, String desig, float salary) {
        this.id = id;
        this.name = name;
        this.desig = desig;
        this.salary = salary;
    }

    public Employee() {
    }

    @Override
    public String toString() {
            return "Employee{" + "id=" + id + ", name=" + name + ", desig=" + desig + ", salary=" + salary + "}\n";
    }
}
