package design.View.Food;

import design.Controller.FoodManager;
import design.Model.Food.Meal;
import design.Model.Food.Recipe;
import design.View.Action;

public class AddRecipe implements Action {
    private FoodManager foodManager;
    private Recipe recipe;
    private Meal meal;

    public AddRecipe(Recipe recipe, Meal meal)
    {
        this.recipe = recipe;
        this.meal = meal;
    }

    public void execute()
    {
        foodManager.addRecipe(meal, recipe);
    }
}
