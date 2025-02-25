package design.View.Food;

import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.Model.Food.Ingredient;
import design.View.Action;

public class StockIngredient implements Action{
    private FoodManager foodManager;
    private Ingredient ingredient;
    private int amount;
    private Scanner input;

    public StockIngredient(FoodManager foodManager, Ingredient ingredient, int amount, Scanner input)
    {
        this.foodManager = foodManager;
        this.ingredient = ingredient;
        this.amount = amount;
        this.input = input;
    }


    public void execute(){
        foodManager.updateStock(ingredient, amount);
    }
}
