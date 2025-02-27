package design.View.Food;

import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.View.Action;


public class CreateRecipe implements Action{
    private FoodManager foodManager;
    private String name;
    private String[] cookInstructions;
    private Scanner input;

    public CreateRecipe(FoodManager foodManager, Scanner input)
    {
        this.foodManager = foodManager;
        this.input = input;
    }

    public void execute()
    {
        System.out.println("What would you like to name your recipe?");
        name = input.nextLine();

        System.out.println("How many steps does your recipe's cooking instructions have?");
        int cookingSteps;
        try{
            cookingSteps = Integer.parseInt(input.nextLine());
        }
        catch(Exception e){
            System.out.println("Invalid input.");
            return;
        }

        if(cookingSteps <= 0){ 
            System.out.println("Number of steps invalid.");
            return;
        }

        cookInstructions = new String[cookingSteps];

        for(int i = 0; i < cookingSteps; i++){
            System.out.println("Please enter step " + (i + 1));
            String step = input.nextLine();
            cookInstructions[i] = step;
        }

        foodManager.createRecipe(name, cookInstructions);

        System.out.println("Recipe created!");
        
    }

}
