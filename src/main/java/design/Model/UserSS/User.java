package design.Model.UserSS;
//need import for Goal

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import design.Model.Goal.Goal;

public class User {
    //user attributes
    private String name;
    private float height;
    private String birthdate;
    private int age;


    //goal attributes
    private double currentWeight;
    private double targetWeight;
    private Goal currentGoal;

    public User(String name, float height, float weight, String birthdate) {
        this.name = name;
        this.height = height;
        this.currentWeight = weight;
        this.birthdate = birthdate;

        //getting age from birthdate based on current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate birthDate = LocalDate.parse(birthdate, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        this.age = period.getYears();
    }
    public String getName() {
        return name;
    }

    public float getHeight() {
        return height;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int getAge() {
        return age;
    }

    public double getCurrentWeight() {
      return currentWeight;
    }

    public double getTargetWeight() {
      return targetWeight;
    }

    public void setGoal(Goal goal) {
        this.currentGoal = goal; 
    }

    public void updateCurrentWeight(double weight) {
        this.currentWeight = weight; 
    }

    public void updateTargetWeight(double weight) {
        this.targetWeight = weight; 
    }
}