package design.Controller;

import design.Model.DailyActivity;
import design.Model.HistoryManager;

public class HistoryController {
    private HistoryManager historyManager;

    public HistoryController(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    public void logMeal(String meal) { // Meal class not created yet
        this.historyManager.getTodaysActivity().addMeal(meal);
    }

    public void logWorkout(String workout) { // Workout class not created yet
        this.historyManager.getTodaysActivity().addWorkout(workout);
    }

    public void logWeight(int weight) {
        this.historyManager.getTodaysActivity().setWeight(weight);
    }

    public void logCaloriesConsumed(int calories) {
        this.historyManager.getTodaysActivity().setCaloriesConsumed(calories);
    }

    public void logTargetCalories(int targetCalories) {
        this.historyManager.getTodaysActivity().setTargetCalories(targetCalories);
    }

    public void logDailyActivity(String date) { // is date a string ???
        this.historyManager.saveDailyActivityToHistory(date);
    }
    
}
