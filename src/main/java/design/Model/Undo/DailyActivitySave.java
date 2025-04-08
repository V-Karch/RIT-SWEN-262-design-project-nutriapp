package design.Model.Undo;

import java.util.List;

public class DailyActivitySave {
    private List<String> meals;
    private List<String> workouts;
    private int targetCalories;
    private int dailyCalories;
    private double weight;

    public DailyActivitySave(List<String> meals, List<String> workouts, int targetCalories, int dailyCalories, double weight) {
        this.meals = meals;
        this.workouts = workouts;
        this.targetCalories = targetCalories;
        this.dailyCalories = dailyCalories;
        this.weight = weight;
    }

    public int getDailyCalories() {
        return dailyCalories;
    }

    public List<String> getMeals() {
        return meals;
    }

    public int getTargetCalories() {
        return targetCalories;
    }

    public double getWeight() {
        return weight;
    }

    public List<String> getWorkouts() {
        return workouts;
    }
}
