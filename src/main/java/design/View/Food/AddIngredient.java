package design.View.Food;

import design.Controller.FoodManager;
import design.Model.Ingredient;
import design.Model.Recipe;


public class AddIngredient {
    private FoodManager foodManager;
    private Ingredient ingredient;
    private Recipe recipe;
    private int quantity;

    public AddIngredient(FoodManager foodManager, Ingredient ingredient, int quantity)
    {
        this.foodManager = foodManager;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public void execute()
    {
        foodManager.addIngredient(recipe, ingredient, quantity);
    }
}
