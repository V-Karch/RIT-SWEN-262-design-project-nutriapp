package design.View.Food;

import design.Controller.FoodManager;
import design.View.Action;

public class CreateMeal implements Action {
    private FoodManager foodManager;
    private String name;

    public CreateMeal(FoodManager foodManager, String name)
    {
        this.name = name;
        this.foodManager = foodManager;
    }

    public void execute()
    {
        foodManager.createMeal(name);
    }
}
