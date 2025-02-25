package design.View.Food;

import design.Controller.Food.FoodManager;
import design.Model.Food.Ingredient;
import design.View.Action;

public class StockIngredient implements Action{
    private FoodManager foodManager;
    private Ingredient ingredient;
    private int amount;

    public StockIngredient(FoodManager foodManager, String ingredient, int amount) throws Exception
    {
        this.foodManager = foodManager;
        Ingredient ingredient_Obj = foodManager.getIngredient(ingredient);
        this.ingredient = ingredient_Obj;
        this.amount = amount;
    }


    public void execute(){
        foodManager.updateStock(ingredient, amount);
    }
}
