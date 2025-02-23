package design.View;

import java.util.Scanner;

import design.Controller.FoodManager;

public class CreateMeal implements Action {
    private FoodManager foodManager;

    public void execute()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a name for you meal:");
        foodManager.createMeal(input.nextLine());
        System.out.println("Meal created");
    }
}
