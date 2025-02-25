package design.View.Food;

import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.Model.Food.Ingredient;
import design.Model.Food.Recipe;


public class AddIngredient {
    private FoodManager foodManager;
    private Ingredient ingredient;
    private Recipe recipe;
    private int quantity;
    private Scanner input;

    public AddIngredient(FoodManager foodManager, Ingredient ingredient, int quantity, Scanner input)
    {
        this.foodManager = foodManager;
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.input = input;
    }

    public void execute()
    {
        foodManager.addIngredient(recipe, ingredient, quantity);
    }
}
