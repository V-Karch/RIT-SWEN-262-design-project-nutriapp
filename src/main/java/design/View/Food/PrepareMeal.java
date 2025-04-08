package design.View.Food;

import java.util.List;
import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.Controller.History.HistoryController;
import design.Model.Goal.Goal;
import design.Model.History.Colleague;
import design.Model.History.Mediator;
import design.View.Action;

public class PrepareMeal implements Action, Colleague{
    private FoodManager foodManager;
    private Scanner input;
    private List<String> Meals;
    private Goal goal;
    private HistoryController historyController;
    private Mediator dailyA;
    private int index;

    public PrepareMeal(FoodManager foodManager, Goal goal, Scanner input, HistoryController historyController, Mediator dailyA) {
        this.foodManager = foodManager;
        this.goal = goal;
        this.input = input;
        this.historyController = historyController;
        this.dailyA = dailyA;

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
                this.index = mealChoice;
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
                sendMessage();
            }

        }
        else{
            System.out.println("No meals to prepare.");
            return;
        }
        
    }

    @Override
    public void sendMessage() {
        dailyA.logMeal(foodManager.getMeal(index));
    }
}