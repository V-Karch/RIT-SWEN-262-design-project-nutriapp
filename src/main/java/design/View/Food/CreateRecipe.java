package design.View.Food;

import design.Controller.FoodManager;
import design.View.Action;

public class CreateRecipe implements Action{
    private FoodManager foodManager;
    private String name;
    private String[] cookInstructions;

    public CreateRecipe(FoodManager foodManager, String name, String[] cookInstructions)
    {
        this.foodManager = foodManager;
        this.name = name;
        this.cookInstructions = cookInstructions;
    }

    public void execute()
    {
        foodManager.createRecipe(name, cookInstructions);
    }

}
