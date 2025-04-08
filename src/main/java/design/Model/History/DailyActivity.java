package design.Model.History;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyActivity implements Mediator{
    private List<String> meals;
    private List<String> workouts;
    private int targetCalories;
    private int dailyCalories;
    private double weight;
    
    
      
     

    
    public DailyActivity() {
        this.weight = 0;
        this.dailyCalories = 0;
        this.targetCalories = 0;
        this.meals = new ArrayList<>(); 
        this.workouts = new ArrayList<>(); 

        }

    @Override
    public void logWeight(double weight) {
        this.weight= weight;
    }

    @Override
    public void logWorkout(String workout) {
        this.workouts.add(workout);
    }

    @Override
    public void logMeal(String meal) {
        this.meals.add(meal);
    }

    @Override
    public void logDailyCalories( int cal) {
        this.dailyCalories = cal;
    }

    @Override
    public void logTargetCalories(int cal) {
        this.targetCalories = cal;
    }

    @Override
    public String logDayActivities() {
    
        Map<String, String> activity = new HashMap<>();
        activity.put("Weight", String.valueOf(this.weight));
        activity.put("Daily Calories", String.valueOf(this.dailyCalories));
        activity.put("Target Calories", String.valueOf(this.targetCalories));
        activity.put("Meals", this.meals.toString());
        activity.put("Workouts", this.workouts.toString());

        this.weight = 0;
        this.dailyCalories = 0;
        this.targetCalories = 0;
        this.meals = new ArrayList<>(); 
        this.workouts = new ArrayList<>(); 

        return activity.toString();
    }    
    
}    

