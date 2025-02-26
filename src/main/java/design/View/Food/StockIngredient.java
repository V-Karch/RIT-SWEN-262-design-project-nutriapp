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

    public StockIngredient(FoodManager foodManager, String ingredient, int amount) throws Exception
    {
        this.foodManager = foodManager;
        Ingredient ingredient_Obj = foodManager.getIngredient(ingredient);
        this.ingredient = ingredient_Obj;
        this.amount = amount;
        this.input = input;
    }


    public void execute(){
        foodManager.updateStock(ingredient, amount);
    }
}
