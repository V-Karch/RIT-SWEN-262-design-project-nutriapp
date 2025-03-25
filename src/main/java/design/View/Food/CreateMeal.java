package design.View.Food;

import java.util.List;
import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.Model.Food.Meal;
import design.Model.Food.Recipe;
import design.View.Action;

public class CreateMeal implements Action {
    private FoodManager foodManager;
    private String name;
    private Scanner input;

    public CreateMeal(FoodManager foodManager, String name, Scanner input)
    {
        this.foodManager = foodManager;
        this.input = input;
    }

    public void execute()
    {
        System.out.println("What would you like to name your meal?");
        name = input.nextLine();

        Meal meal = foodManager.createMeal(name);
        System.out.println("Meal created.");

        List<Recipe> Recipes = foodManager.getAllRecipes();
        String choice = "";

        if (Recipes.size() > 0) {
            while(!choice.equals("f")){
            
                System.out.println("Choose a recipe to add to this meal. Enter f to finish.");
                int i = 0;
                for (Recipe r : Recipes) {
                    System.out.print(i + ": ");
                    System.out.println(r.getName());
                    i++;
                }

                if(choice.equals("f")){
                    break;
                }

    
                choice = input.nextLine();
                int recipeChoice;
                Recipe recipe;
                try {
                    recipeChoice = Integer.parseInt(choice);
                } catch (Exception e) {
                    System.out.println("Invalid choice.");
                    continue;
                }
    
                if (recipeChoice >= 0 && recipeChoice < Recipes.size()) {
                    recipe = Recipes.get(recipeChoice);
                } else {
                    System.out.println("Choice is out of bounds.");
                    continue;
                }
    
                foodManager.addRecipe(meal, recipe);
                System.out.println("Recipe added!");
            } 
        }
        else {
            System.out.println("No recipes to add to this meal.");
        }
    }
}