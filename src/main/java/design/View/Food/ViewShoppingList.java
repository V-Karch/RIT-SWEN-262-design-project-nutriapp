package design.View.Food;

import java.util.List;
import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.Model.Food.Recipe;
import design.Model.Food.ShoppingList;
import design.View.Action;

public class ViewShoppingList implements Action{
    private FoodManager foodManager;
    private ShoppingList list;
    private Scanner input;

    public ViewShoppingList(FoodManager foodManager, Scanner input){
        this.foodManager = foodManager;
        this.input = input;
    }

    public void execute(){
        System.out.println("Which shopping list would you like to view?");

        List<ShoppingList> ShoppingLists = foodManager.getAllShoppingLists();

        for (ShoppingList s : ShoppingLists) {
                System.out.println(s.getName());
            }

        String choice = input.nextLine();
        try{
            list = foodManager.getShoppingList(choice);
            List<String> items = list.getShoppingList();
            for(String s : items){
                System.out.println(s);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
    }
}
