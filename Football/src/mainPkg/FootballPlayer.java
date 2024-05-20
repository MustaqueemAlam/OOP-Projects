/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPkg;

/**
 *
 * @author Mustaqueem Alam
 */
import java.io.Serializable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


    public class FootballPlayer  implements Serializable {
        private StringProperty name;
        private IntegerProperty age;
        private StringProperty position;
        private IntegerProperty goals;

        public FootballPlayer(String name, int age, String position, int goals) {
            this.name = new SimpleStringProperty(name);
            this.age = new SimpleIntegerProperty(age);
            this.position = new SimpleStringProperty(position);
            this.goals = new SimpleIntegerProperty(goals);
        }

        // Getters for properties
        public StringProperty nameProperty() {
            return name;
        }

        public IntegerProperty ageProperty() {
            return age;
        }

        public StringProperty positionProperty() {
            return position;
        }

        public IntegerProperty goalsProperty() {
            return goals;
        }
        
    public StringProperty getName() {
        return name;
    }

    public IntegerProperty getAge() {
        return age;
    }

    public StringProperty getPosition() {
        return position;
    }

    public IntegerProperty getGoals() {
        return goals;
    }

    public void setName(StringProperty name) {
        this.name = name;
    }

    public void setAge(IntegerProperty age) {
        this.age = age;
    }

    public void setPosition(StringProperty position) {
        this.position = position;
    }

    public void setGoals(IntegerProperty goals) {
        this.goals = goals;
    }

          
    
}