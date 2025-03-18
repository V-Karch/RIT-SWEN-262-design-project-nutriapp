package design.View.Food;

import java.util.List;
import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.Model.Food.Ingredient;
import design.View.Action;

public class StockIngredient implements Action{
    private FoodManager foodManager;
    private Ingredient ingredient;
    private int amount;
    private Scanner input;

    public StockIngredient(FoodManager foodManager, Scanner input)
    {
        this.foodManager = foodManager;
        this.input = input;
    }


    public void execute() {
        List<String> ingredients = foodManager.getIngredients();
        System.out.println(ingredients.toString());
        System.out.println("Which ingredient would you like to stock?");
        String choice = input.nextLine();
            try{
                ingredient = foodManager.getIngredient(choice);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                return;
            }

            System.out.println("How many grams would you like to stock?");
            choice = input.nextLine();
            try{
                amount = Integer.parseInt(choice);
            }
            catch(Exception e){
                System.out.println("Invalid amount.");
                return;
            }

            if(amount <= 0){
                System.out.println("Amount out of range.");
                return;
            }

        foodManager.updateStock(ingredient, amount);
        System.out.println("Stock updated!");
    }
}
