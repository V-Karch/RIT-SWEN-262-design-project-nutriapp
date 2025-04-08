package design.Model.UserSS;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import design.Model.Goal.Goal;
import design.Model.Goal.MaintainWeight;
import design.Model.History.Colleague;
import design.Model.History.Mediator;

public class User implements Colleague{
    // user attributes
    private String name;
    private float height;
    private String birthdate;
    private int age;

    // goal attributes
    private double currentWeight;
    private double targetWeight;
    public Goal currentGoal;
    public Mediator dailyA;

    public User(String name, float height, float weight, String birthdate, Mediator dailyA, String hash) {
        this.name = name;
        this.height = height;
        this.currentWeight = weight;
        this.birthdate = birthdate;
        this.dailyA = dailyA;

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

    public String getHash(){
        return null;
    }


    public void updateCurrentWeight(double weight) {
        // should also send a call to history
        this.currentWeight = weight;
        currentGoal.handleWeightChange();
        sendMessage();
    }

    public void updateTargetWeight(double weight) {
        this.targetWeight = weight;
        currentGoal.handleWeightChange();
    }

    @Override
    public void sendMessage() {
        dailyA.logWeight(currentWeight);
    }
}