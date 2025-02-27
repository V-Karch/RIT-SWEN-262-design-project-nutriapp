package design.View.Food;

import java.util.List;
import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.Controller.History.HistoryController;
import design.Model.Food.Meal;
import design.Model.Goal.Goal;
import design.View.Action;

public class PrepareMeal implements Action{
    private FoodManager foodManager;
    private Scanner input;
    private List<Meal> Meals;
    private Meal meal;
    private Goal goal;
    private List<String> instructions;
    private HistoryController historyController;

    public PrepareMeal(FoodManager foodManager, Goal goal, Scanner input, HistoryController historyController) {
        this.foodManager = foodManager;
        this.goal = goal;
        this.input = input;

        Meals = foodManager.getAllMeals();
    }

    public void execute(){
        if (Meals.size() > 0) {
            System.out.println("Which meal would you like to prepare?");
            int i = 1;
            for (Meal m : Meals) {
                System.out.print(i + ": ");
                System.out.println(m.getName());
                i++;
            }

            String choice = input.nextLine();
            int mealChoice;
            try {
                mealChoice = Integer.parseInt(choice);
            } catch (Exception e) {
                System.out.println("Invalid choice.");
                return;
            }

            mealChoice--;
            if (mealChoice >= 0 && mealChoice < Meals.size()) {
                meal = Meals.get(mealChoice);
            } else {
                System.out.println("Choice is out of bounds.");
                return;
            }

            System.out.println("Instructions:");
            instructions = meal.getInstructions();
            for(String s : instructions)
            {
                System.out.println(s);
            }

            System.out.println("Enter 1 to prepare meal.");
            choice = input.nextLine();
            if(choice.equals("1")){
                meal.prepareMeal();
                goal.addDailyCalories(meal.getCalories());
                historyController.logMeal(meal);
            }

        }
        else{
            System.out.println("No meals to prepare.");
            return;
        }
        
    }
}
