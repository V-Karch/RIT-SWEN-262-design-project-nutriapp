package design.Controller.History;

import design.Model.Workout.Workout;
import design.Model.History.HistoryManager;

public class HistoryController {
    private HistoryManager historyManager;

    public HistoryController(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    public void logMeal(String meal) { // Meal class not created yet
        this.historyManager.getTodaysActivity().addMeal(meal);
    }

    public void logWorkout(Workout workout) { 
        this.historyManager.getTodaysActivity().addWorkout(workout);
    }

    public void logCaloriesConsumed(int calories) {
        this.historyManager.getTodaysActivity().setCaloriesConsumed(calories);
    }

    public void logTargetCalories(int targetCalories) {
        this.historyManager.getTodaysActivity().setTargetCalories(targetCalories);
    }

    public void logDailyActivity(String date) { 
        this.historyManager.saveTodaysActivityToHistory(date);
    }
    
    public DailyActivity searchforDailyActivity(String date) {  //searches for the daily activity of a specific date
        return this.historyManager.getDailyActivity(date);
      
    }
   
    public void logWeight(int weight) {
        this.historyManager.setTodaysWeight(weight);
    }
}
