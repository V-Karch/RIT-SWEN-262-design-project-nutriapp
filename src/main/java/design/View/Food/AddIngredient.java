package design.View.Food;

import java.util.List;
import java.util.Scanner;
import design.View.Action;

import design.Controller.Food.FoodManager;
import design.Model.Food.Ingredient;
import design.Model.Food.Recipe;

public class AddIngredient implements Action{
    private FoodManager foodManager;
    private Ingredient ingredient;
    private Recipe recipe;
    private int quantity;
    private Scanner input;

    public AddIngredient(FoodManager foodManager, Scanner input)
    {
        this.foodManager = foodManager;
        this.input = input;
    }

    public void execute() {
        List<Recipe> Recipes = foodManager.getAllRecipes();

        if (Recipes.size() > 0) {
            System.out.println("Choose a recipe to add an ingredient to:");
            int i = 1;
            for (Recipe r : Recipes) {
                System.out.print(i + ": ");
                System.out.println(r.getName());
                i++;
            }
            
            String choice = input.nextLine();
            int recipeChoice;
            try{
                recipeChoice = Integer.parseInt(choice);
            }
            catch(Exception e){
                System.out.println("Invalid choice.");
                return;
            }

            recipeChoice--;
            if(recipeChoice >= 0 && recipeChoice < Recipes.size()){
                recipe = Recipes.get(recipeChoice);
            }
            else{
                System.out.println("Choice is out of bounds.");
                return;
            }

            
            System.out.println("What ingredient would you like to add?");
            choice = input.nextLine();
            try{
                ingredient = foodManager.getIngredient(choice);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                return;
            }

            System.out.println("How many grams would you like to add?");
            choice = input.nextLine();
            try{
                quantity = Integer.parseInt(choice);
            }
            catch(Exception e){
                System.out.println("Invalid amount.");
                return;
            }

            if(quantity <= 0){
                System.out.println("Amount out of range.");
                return;
            }

            recipe.addIngredient(ingredient, quantity);
            System.out.println("Ingredient added!");

        }
        else{
            System.out.println("No recipes to add an ingredient to.");
            return;
        }
    }
}
