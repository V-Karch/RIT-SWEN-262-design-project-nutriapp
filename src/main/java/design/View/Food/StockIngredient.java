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

    public StockIngredient(FoodManager foodManager, Scanner input) throws Exception
    {
        this.foodManager = foodManager;
    }


    public void execute(){
        System.out.println("What ingredient would you like to stock? Type 'Options' to get ingredient options.");
        String response = input.nextLine();
        String ingredient_S;
        response = response.toLowerCase();
        if (response.equals("options")) {
            List<String> ingredients = this.foodManager.getIngredients();
            for (String i : ingredients){
                System.out.println(i);
            }
            System.out.println("What ingredient would you like to stock?");
            ingredient_S = input.nextLine();
        } else {
            ingredient_S = response;
        }

        try {
            Ingredient ingredient = foodManager.getIngredient(ingredient_S);
            System.out.println("How much stock would you like to add?");
                String amount_S = input.nextLine();
                int amount = Integer.parseInt(amount_S);
                try {
                    foodManager.updateStock(ingredient, amount);
                    System.out.println("Successfully stocked!");
                } catch (Exception e) {
                    System.out.println("Problem!");
                }
        } catch (Exception ex) {
            System.out.println("unable to get ingredient");
        }
        

        
    }
}
