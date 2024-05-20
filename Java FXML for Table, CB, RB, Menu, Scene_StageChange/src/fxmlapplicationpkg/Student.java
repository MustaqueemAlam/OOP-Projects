package fxmlapplicationpkg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student implements Serializable{  
//public class Student{  
    int id;  
    String name;
    float cgpa;
    public Student(int id, String name, float f) {  
        this.id = id;  
        this.name = name;
        cgpa = f;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getCgpa() {
        return cgpa;
    }
    
    public void display(){
        System.out.println("Id="+id+", Name="+name+", Cgpa="+cgpa);
    }
    @Override
    public String toString(){
        //return id+","+name+","+cgpa+"\n";
        //return "Id="+id+"; Name="+name+"; Cgpa="+cgpa;
        return "ID of "+name+" is "+id+" and cgpa is "+cgpa;
    }  
} 

