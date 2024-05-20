package fxmlapplicationpkg;

import java.time.LocalDate;
import java.time.Period;
import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty firstName, lastName;
    private LocalDate birthday;

    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.birthday = birthday;
    }

    public void setFirstName(String firstName) {
        this.firstName = new SimpleStringProperty(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = new SimpleStringProperty(lastName);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    
    
    public String getFirstName() {
        //return firstName;
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    
    public int getAge(){
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}
