package design.Model.UserSS;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import design.Model.Goal.Goal;
import design.Model.Goal.MaintainWeight;
import design.Model.Undo.UserSave;

public class User {
    // user attributes
    private String name;
    private float height;
    private String birthdate;
    private int age;

    // goal attributes
    private double currentWeight;
    private double targetWeight;
    public Goal currentGoal;

    public User(String name, float height, float weight, String birthdate) {
        this.name = name;
        this.height = height;
        this.currentWeight = weight;
        this.birthdate = birthdate;

        // getting age from birthdate based on current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate birthDate = LocalDate.parse(birthdate, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        this.age = period.getYears();

        this.currentGoal = new MaintainWeight(this, false, 0);
    }

    //most functions are self explanatory


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

    public Goal getGoal(){
        return this.currentGoal;
    }

    public void updateCurrentWeight(double weight) {
        // should also send a call to history
        this.currentWeight = weight;
        currentGoal.handleWeightChange();
    }

    public void updateTargetWeight(double weight) {
        this.targetWeight = weight;
        currentGoal.handleWeightChange();
    }

    public UserSave createSave() {
        UserSave save = new UserSave(name, height, birthdate, age, currentWeight, targetWeight, currentGoal);
        return save;
    }

    public void restoreSave(UserSave save) {
        this.name = save.getName();
        this.height = save.getHeight();
        this.birthdate = save.getBirthdate();
        this.age = save.getAge();
        this.currentWeight = save.getCurrentWeight();
        this.targetWeight = save.getTargetWeight();
        this.currentGoal = save.getCurrentGoal();
    }
}