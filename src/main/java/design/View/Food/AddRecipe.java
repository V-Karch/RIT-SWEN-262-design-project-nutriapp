package design.View.Food;

import design.Controller.FoodManager;
import design.Model.Recipe;

public class AddRecipe implements Action {
    private FoodManager foodManager;
    private Recipe recipe;
    private Meal meal;

    public AddRecipe(Recipe recipe, Meal meal)
    {
        foodManager.addRecipe(meal, recipe);
    }
}
