package design.Model.Workout;

import design.Model.History.Colleague;
import design.Model.History.Mediator;

public class Workout implements Colleague{
    private int minutes;
    private Intensity intensity;
    private String date;
    private String name;
    private int calories;
    private Mediator dailyA;

    public Workout(int minutes, Intensity intensity, String date, String name, Mediator dailyA) {
        this.minutes = minutes;
        this.intensity = intensity;
        this.date = date;
        this.name = name;
        this.dailyA = dailyA;

        this.calories = (int)(minutes * intensity.getValue());
        this.sendMessage();
    }

    public int getMinutes() { return this.minutes; }
    public Intensity getIntensity() { return this.intensity; }
    public int getCalories() { return this.calories; }
    public String getDate() { return this.date; }
    public String getName() { return this.name; }

    
    @Override
    public String toString() {
        return "Workout[Name: " + getName() + ", Date: " + getDate() + ", Minutes: " + 
            getMinutes() + ", Intensity: " + getIntensity() + ", Calories: " + getCalories() + "]"; 
    }

    @Override
    public void sendMessage() {
        dailyA.logWorkout(this.toString());
    }
}
