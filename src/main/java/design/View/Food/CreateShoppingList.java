package design.View.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.Model.Food.Ingredient;
import design.View.Action;

public class CreateShoppingList implements Action {
    private FoodManager foodManager;
    private Scanner input;
    private String name;
    private List<Ingredient> items;

    public CreateShoppingList(FoodManager foodManager, Scanner input) {
        this.foodManager = foodManager;
        this.input = input;
    }

    public void execute() {
        System.out.println(
                "Here is a recommended shopping list based on ingredients low in the stock or ingredients in recipes:");
        ArrayList<Ingredient> recShoppingList = foodManager.getRecommendedShoppingList();
        for (Ingredient i : recShoppingList) {
            System.out.println(i.getName());
        }

        System.out.println("Please enter a name for this shopping list.");
        name = input.nextLine();

        String choice = "";
        while (choice != "0") {
            System.out.println("What ingredient would you like to add? Enter '0' to finish list.");
            if (choice != "0") {
                choice = input.nextLine();
                try {
                    Ingredient item = foodManager.getIngredient(choice);
                    items.add(item);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }

            foodManager.createShoppingList(items, name);
            System.out.println("Your shopping list has been created!");
        }
    }
}
