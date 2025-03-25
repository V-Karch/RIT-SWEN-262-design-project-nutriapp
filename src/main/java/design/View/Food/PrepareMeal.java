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
    private List<String> Meals;
    private Goal goal;
    private HistoryController historyController;

    public PrepareMeal(FoodManager foodManager, Goal goal, Scanner input, HistoryController historyController) {
        this.foodManager = foodManager;
        this.goal = goal;
        this.input = input;
        this.historyController = historyController;

        Meals = foodManager.getMealList();
    }

    public void execute(){
        if (Meals.size() > 0) {
            System.out.println("Which meal would you like to prepare?");
            int i = 0;
            for (String s : Meals) {
                System.out.print(i + ": ");
                System.out.println(s);
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

            List<String> mealInstructions;
            List<String> mealIngredients;
            if (mealChoice >= 0 && mealChoice < Meals.size()) {
                mealInstructions = foodManager.getMealInstructions(mealChoice);
                mealIngredients = foodManager.getMealIngredients(mealChoice);
            } else {
                System.out.println("Choice is out of bounds.");
                return;
            }

            //Ingredients
            System.out.println("Ingredients:");
            for(String s : mealIngredients){
                System.out.println(s);
            }
            System.out.println();

            System.out.println("Instructions:");
            for(String s : mealInstructions)
            {
                System.out.println(s);
            }

            System.out.println("Enter 1 to prepare meal.");
            choice = input.nextLine();
            if(choice.equals("1")){
                foodManager.prepareMeal(mealChoice, goal, historyController);
            }

        }
        else{
            System.out.println("No meals to prepare.");
            return;
        }
        
    }
}
