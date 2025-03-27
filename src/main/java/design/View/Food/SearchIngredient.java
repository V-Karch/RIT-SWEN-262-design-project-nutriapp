
package design.View.Food;

import java.util.List;
import java.util.Scanner;
import design.View.Action;

import design.Controller.Food.FoodManager;


public class SearchIngredient implements Action{
    private FoodManager foodManager;
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
                List<String> searched = foodManager.searchForIngredients(choice);
                System.out.println("Results found:");
                for(String s : searched){
                    System.out.println(s);
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                return;
            }
    }
}
