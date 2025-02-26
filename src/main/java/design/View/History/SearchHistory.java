package design.View.History;

import java.util.List;
import java.util.Scanner;

import design.Controller.History.HistoryController;
import design.Model.History.DailyActivity;
import design.Model.Workout.Workout;
import design.View.Action;
import design.Model.Food.Meal;

public class SearchHistory implements Action{
    
    private Scanner input;
    private HistoryController historyController;

    public SearchHistory(Scanner input, HistoryController historyController) {
        this.input = input;
        this.historyController = historyController;
    }

    @Override
    public void execute() {
        System.out.println("Enter a previous date to search for: ");
        try {
            String date = input.nextLine();
            DailyActivity dailyActivity = historyController.searchForDailyActivity(date);

            int weight = dailyActivity.getWeight();
            int calories_consumed = dailyActivity.getCaloriesConsumed();
            int target_calories = dailyActivity.getTargetCalories();
            List<Meal> meals = dailyActivity.getMeals(); 
            List<Workout> workouts = dailyActivity.getWorkouts();

            System.out.println("Weight: " + weight);
            System.out.println("Calories Consumed: " + calories_consumed);
            System.out.println("Target Calories: " + target_calories);
            
            System.out.println("\nMeals: ");
            for (Meal meal : meals) {
                System.out.println(meal.toString());
            }

            System.out.println("\nWorkouts: ");
            for (Workout workout : workouts) {
                System.out.println(workout.toString());
            }

        } catch (Exception e) {
            System.out.println("Invalid Date.");
        }
        
    }
}
