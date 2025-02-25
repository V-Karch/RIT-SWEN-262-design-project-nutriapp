package design.View.Food;

import design.Controller.Food.FoodManager;
import design.Model.Food.Meal;
import design.Model.Food.Recipe;
import design.View.Action;

import java.util.Scanner;

public class AddRecipe implements Action {
    private FoodManager foodManager;
    private Recipe recipe;
    private Meal meal;
    private Scanner input;

    public AddRecipe(Recipe recipe, Meal meal, Scanner input)
    {
        this.recipe = recipe;
        this.meal = meal;
        this.input = input;
    }

    public void execute()
    {
        foodManager.addRecipe(meal, recipe);
    }
}
