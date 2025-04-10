package design.Model.Undo;

import design.Model.Goal.Goal;

public class UserSave {
    private String name;
    private float height;
    private String birthdate;
    private int age;
    private double currentWeight;
    private double targetWeight;
    private Goal currentGoal;

    public UserSave(String name, float height, String birthdate, int age, double currentWeight, double targetWeight, Goal currentGoal) {
        this.name = name;
        this.height = height;
        this.birthdate = birthdate;
        this.age = age;
        this. currentWeight = currentWeight;
        this.targetWeight = targetWeight;
        this.currentGoal = currentGoal;
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

    public Goal getCurrentGoal() {
        return currentGoal;
    }

}
