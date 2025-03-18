
package design.View.Food;

import java.util.Scanner;
import design.View.Action;

import design.Controller.Food.FoodManager;
import design.Model.Food.Ingredient;


public class SearchIngredient implements Action{
    private FoodManager foodManager;
    private Ingredient ingredient;
    private Scanner input;

    public SearchIngredient(FoodManager foodManager, Scanner input)
    {
        this.foodManager = foodManager;
        this.input = input;
    }

    public void execute(){
        System.out.println("Type an ingredient to search.");
        String choice = input.nextLine();
            try{
                ingredient = foodManager.getIngredient(choice);
                System.out.println("This ingredient was found in the database!");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                return;
            }
    }
}
