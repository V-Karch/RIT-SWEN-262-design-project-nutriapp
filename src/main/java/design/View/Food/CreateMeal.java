package design.View.Food;

import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.View.Action;

public class CreateMeal implements Action {
    private FoodManager foodManager;
    private String name;
    private Scanner input;

    public CreateMeal(FoodManager foodManager, String name, Scanner input)
    {
        this.name = name;
        this.foodManager = foodManager;
        this.input = input;
    }

    public void execute()
    {
        foodManager.createMeal(name);
    }
}