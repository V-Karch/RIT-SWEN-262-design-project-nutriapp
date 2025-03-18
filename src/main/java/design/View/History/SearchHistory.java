package design.View.History;


import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
        System.out.println("Enter the number of a previous day to view that day's activities : ");
        
        System.out.println("Previous days:"); // Displays all the previous days that have been logged
        Set<String> dates = historyController.getHistoryManager().getHistory().keySet();
        for (String date : dates) {
            System.out.println("Day " + date);
        }


        try {
            String date = input.nextLine();
            DailyActivity dailyActivity = historyController.searchForDailyActivity(date);

            System.out.println("\n***ACTIVITY FOR DAY " + date + "***");

            int weight = dailyActivity.getWeight();
            int calories_consumed = dailyActivity.getCaloriesConsumed();
            int target_calories = dailyActivity.getTargetCalories();
            List<Meal> meals = dailyActivity.getMeals(); 
            List<Workout> workouts = dailyActivity.getWorkouts();

            System.out.println("Weight: " + weight + " lbs");
            System.out.println("Calories Consumed: " + calories_consumed + " cal");
            System.out.println("Target Calories: " + target_calories + " cal");
            
            //Meal information
            System.out.println("\n***MEALS*** ");
            if( meals.isEmpty()) {
                System.out.println("No meals logged for this day.");
            } else {
                for (Meal meal : meals) {
                    System.out.println(meal.toString());
                }
            }
            
            //Workout information
            System.out.println("\n***WORKOUTS*** ");
            if( workouts.isEmpty()) {
                System.out.println("No workouts logged for this day.");
            } else {
                for (Workout workout : workouts) {
                    System.out.println(workout.toString());
                }
            }

        } catch (Exception e) {
            System.out.println("Invalid Date.");
        }
        
    }
}
