package design.View;

import java.util.Scanner;

import design.Controller.FoodManager;
import design.Model.Ingredient;

public class StockIngredient implements Action{
    private FoodManager foodManager;

    public void execute()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Which ingredient are you stocking?");
        Ingredient i;
        try{
            String ingredient = input.nextLine();
            i = foodManager.getIngredient(ingredient);
        }
        catch(Exception e)
        {
            System.out.println("Could not find ingredient.");
            return;
        }
        

        
        System.out.println("How much do you want to stock?");
        String amount = input.nextLine();
        int intAmount = 0;
        try{
            intAmount = Integer.parseInt(amount);
        }
        catch(Exception e)
        {
            System.out.println("Invalid amount.");
            return;
        }
        
        foodManager.updateStock(i, intAmount);
        System.out.println("Stock updated");
    }
}
