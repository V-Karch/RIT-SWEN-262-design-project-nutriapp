package design.Model;

public class User {
    //user attributes
    private String name;
    private float height;
    private float weight;
    private int[] birthdate;
    private int age;

    //goal attributes
    private double currentWeight;
    private double targetWeight;
    private Goal currentGoal;

    public User(String name, float height, float weight, int[] birthdate) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthdate = birthdate;

        //[MO,DA,YR]
        int currentYear = Year.now().getValue()
        this.age = currentYear - birthdate[2]
    }

    public void setGoal(Goal goal) {
        this.currentGoal = goal 
    }

    public void updateCurrentWeight(double weight) {
        this.currentWeight = weight 
    }

    public void updateTargetWeight(double weight) {
        this.targetWeight = weight 
    }
}