package design.View;

import java.util.Scanner;

import design.Controller.FoodManager;
import design.Model.Ingredient;

public class StockIngredient implements Action{
    private FoodManager foodManager;
    private Ingredient ingredient;
    private int amount;

    public StockIngredient(FoodManager foodManager, Ingredient ingredient, int amount)
    {
        this.foodManager = foodManager;
        this.ingredient = ingredient;
        this.amount = amount;
    }


    public void execute()
    {
        foodManager.updateStock(ingredient, amount);
    }
}
