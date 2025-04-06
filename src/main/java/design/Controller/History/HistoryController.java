package design.Controller.History;

import design.Model.History.HistoryManager;

public class HistoryController {
    private HistoryManager historyManager;

    public HistoryController(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    public HistoryManager getHistoryManager(){
        return this.historyManager;
    }

    // public void logMeal(Meal meal) { 
    //     this.historyManager.getTodaysActivity().addMeal(meal);
    // }

    // public void logWorkout(Workout workout) { 
    //     this.historyManager.getTodaysActivity().addWorkout(workout);
    // }

    // public void logCaloriesConsumed(int calories) {
    //     this.historyManager.getTodaysActivity().setCaloriesConsumed(calories);
    // }

    // public void logTargetCalories(int targetCalories) {
    //     this.historyManager.getTodaysActivity().setTargetCalories(targetCalories);
    // }

    public void logTodaysActivity(String date) { 
        this.historyManager.logTodaysActivity(date);
    }
    
    public String searchForDailyActivity(String date) {  //searches for the daily activity of a specific date
        return this.historyManager.getDailyActivity(date);
    }

    // public void logWeight(double weight) {
    //     this.historyManager.setTodaysWeight(weight);
    // }
}
