package design.View.Food;

import design.Controller.Food.FoodManager;
import design.Model.Food.Meal;
import design.Model.Food.Recipe;
import design.View.Action;

import java.util.Scanner;
import java.util.List;

public class AddRecipe implements Action {
    private FoodManager foodManager;
    private Recipe recipe;
    private Meal meal;
    private Scanner input;

    public AddRecipe(FoodManager foodManager, Scanner input) {
        this.foodManager = foodManager;
        this.input = input;
    }

    public void execute() {
        List<Meal> Meals = foodManager.getAllMeals();

        if (Meals.size() > 0) {
            System.out.println("Choose a meal to add a recipe to:");
            int i = 0;
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

            if (mealChoice >= 0 && mealChoice < Meals.size()) {
                meal = Meals.get(mealChoice);
            } else {
                System.out.println("Choice is out of bounds.");
                return;
            }
        } else {
            System.out.println("No meals to add a recipe to.");
            return;
        }

        List<Recipe> Recipes = foodManager.getAllRecipes();

        if (Recipes.size() > 0) {
            System.out.println("Choose a recipe to add to this meal:");
            int i = 0;
            for (Recipe r : Recipes) {
                System.out.print(i + ": ");
                System.out.println(r.getName());
                i++;
            }

            String choice = input.nextLine();
            int recipeChoice;
            try {
                recipeChoice = Integer.parseInt(choice);
            } catch (Exception e) {
                System.out.println("Invalid choice.");
                return;
            }

            if (recipeChoice >= 0 && recipeChoice < Recipes.size()) {
                recipe = Recipes.get(recipeChoice);
            } else {
                System.out.println("Choice is out of bounds.");
                return;
            }  

            foodManager.addRecipe(meal, recipe);
            System.out.println("Recipe added!");
        } else {
            System.out.println("No recipes to add to this meal.");
        }

    }
}
