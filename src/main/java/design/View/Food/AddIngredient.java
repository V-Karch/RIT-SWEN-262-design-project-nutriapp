package design.View.Food;

import java.util.List;
import java.util.Scanner;
import design.View.Action;

import design.Controller.Food.FoodManager;
import design.Model.Food.Ingredient;
import design.Model.Food.Recipe;

public class AddIngredient implements Action{
    private FoodManager foodManager;
    private Ingredient ingredient;
    private Recipe recipe;
    private int quantity;
    private Scanner input;

    public AddIngredient(FoodManager foodManager, Scanner input)
    {
        this.foodManager = foodManager;
        this.input = input;
    }

    public void execute() {
        List<Recipe> Recipes = foodManager.getAllRecipes();

        if (Recipes.size() > 0) {
            System.out.println("Choose a recipe to add an ingredient to:");
            int i = 1;
            for (Recipe r : Recipes) {
                System.out.print(i + ": ");
                System.out.println(r.getName());
                i++;
            }
            
            String choice = input.nextLine();
            int recipeChoice;
            try{
                recipeChoice = Integer.parseInt(choice);
            }
            catch(Exception e){
                System.out.println("Invalid choice.");
                return;
            }

            recipeChoice--;
            if(recipeChoice >= 0 && recipeChoice < Recipes.size()){
                recipe = Recipes.get(recipeChoice);
            }
            else{
                System.out.println("Choice is out of bounds.");
                return;
            }


            boolean searchFinished = false;
            while(!searchFinished){
                System.out.println("Search for ingredients to add to this recipe:");
                choice = input.nextLine();
    
                try{
                    List<String> searched = foodManager.searchForIngredients(choice);

                    if(searched.size() > 0){
                        System.out.println("Results found:");
                        int index = 0;
                        for(String s : searched){
                            System.out.println(index++ + ": " + s);
                        }

                        boolean addingFinished = false;
                        while(!addingFinished){
                            System.out.println("Which of these ingredients would you like to add? Enter 's' to search again.");
                            choice = input.nextLine();
                            if(choice.equals("s")){
                                break;
                            }
                            else{
                                try{
                                    ingredient = foodManager.getIngredient(searched.get(Integer.parseInt(choice)));
    
                                    boolean amountFinished = false;
                                    
                                    while(!amountFinished){
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
                                        amountFinished = true;
                                    }
                                    addingFinished = true;
                                }
                                catch(Exception e){
                                    System.out.println("Error: " + e.getMessage());
                                    continue;
                                }
                            }
    
                            boolean addMoreFinished = false;
                            while(!addMoreFinished){
                                System.out.println("Would you like to add any more ingredients? y/n");
                                choice = input.nextLine();
            
                                if(choice.equals("y")){
                                    break;
                                }
                                else if(choice.equals("n")){
                                    searchFinished = true;
                                    break;
                                }
                                else{
                                    System.out.println("Invalid response.");
                                }
                            }
    
                        }
                    }
                    else{
                        System.out.println("No results found.");
                        break;
                    }
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        else{
            System.out.println("No recipes to add an ingredient to.");
            return;
        }
    }
}
