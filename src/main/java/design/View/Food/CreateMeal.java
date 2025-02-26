package design.View.Food;

import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.View.Action;

public class CreateMeal implements Action {
    private FoodManager foodManager;
    private String name;
    private Scanner input;

    public CreateMeal(FoodManager foodManager, Scanner input)
    {
        this.foodManager = foodManager;
        this.input = input;
    }

    public void execute()
    {
        System.out.println("What would you like to name your meal?");
        name = input.nextLine();

        foodManager.createMeal(name);
        System.out.println("Meal created.");
    }
}