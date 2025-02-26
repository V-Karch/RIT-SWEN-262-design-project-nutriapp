package design.View.Food;

import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.View.Action;


public class CreateRecipe implements Action{
    private FoodManager foodManager;
    private String name;
    private String[] cookInstructions;
    private Scanner input;

    public CreateRecipe(FoodManager foodManager, String name, String[] cookInstructions, Scanner input)
    {
        this.foodManager = foodManager;
        this.name = name;
        this.cookInstructions = cookInstructions;
        this.input = input;
    }

    public void execute()
    {
        foodManager.createRecipe(name, cookInstructions);
    }

}
