package design.View.Food;

import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.Model.Food.Ingredient;
import design.Model.Food.Recipe;
import design.View.Action;


public class CreateRecipe implements Action{
    private FoodManager foodManager;
    Recipe recipe;
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
        // Name of recipe
        System.out.println("What would you like to name your recipe?");
        name = input.nextLine();

        System.out.println();


        // Cook instructions
        boolean instructionsValid = false;
        int cookingSteps = 0;
        while(!instructionsValid){
            System.out.println("How many steps does your recipe's cooking instructions have?");
            try{
                cookingSteps = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                System.out.println("Invalid input.");
                continue;
            }
    
            if(cookingSteps <= 0){ 
                System.out.println("Number of steps invalid.");
                continue;
            }

            instructionsValid = true;
        }
        

        cookInstructions = new String[cookingSteps];

        for(int i = 0; i < cookingSteps; i++){
            System.out.println("Please enter step " + (i + 1));
            String step = input.nextLine();
            cookInstructions[i] = step;
        }

        recipe = foodManager.createRecipe(name, cookInstructions);

        System.out.println("Recipe created!");




        String choice = "";
        Ingredient ingredient;
        int quantity;

        while(!choice.equals("f")){
        System.out.println("What ingredient would you like to add? Enter 'f' to finish.");
        choice = input.nextLine();
        if(choice.equals("f")){
            break;
        }

        try{
            ingredient = foodManager.getIngredient(choice);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
           continue;
        }

        System.out.println("How many grams would you like to add?");
        choice = input.nextLine();
        try{
            quantity = Integer.parseInt(choice);
        }
        catch(Exception e){
            System.out.println("Invalid amount.");
            continue;
        }

        if(quantity <= 0){
            System.out.println("Amount out of range.");
            continue;
        }

        recipe.addIngredient(ingredient, quantity);
        System.out.println("Ingredient added!");
        }
        
    }

}
