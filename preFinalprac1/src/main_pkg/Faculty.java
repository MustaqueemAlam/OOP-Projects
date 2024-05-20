package main_pkg;

import java.io.Serializable;
import java.time.LocalDate;

public class Faculty implements Serializable {
    private int facultyId;
    private String name;
    private String designation;
    private String dept;
    private double salary;
    private LocalDate dateOfBirth;

    public Faculty(int facultyId, String name, String designation, String dept, double salary, LocalDate dateOfBirth) {
        this.facultyId = facultyId;
        this.name = name;
        this.designation = designation;
        this.dept = dept;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDept() {
        return dept;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
