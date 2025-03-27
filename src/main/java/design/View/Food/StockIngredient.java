package design.View.Food;

import java.util.List;
import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.Model.Food.Ingredient;
import design.View.Action;

public class StockIngredient implements Action{
    private FoodManager foodManager;
    private Ingredient ingredient;
    private int quantity;
    private Scanner input;

    public StockIngredient(FoodManager foodManager, Scanner input)
    {
        this.foodManager = foodManager;
        this.input = input;
    }


    public void execute() {
        List<String> ingredients = foodManager.getIngredients();
        System.out.println(ingredients.toString());
        System.out.println("Which ingredient would you like to stock?");
        String choice = input.nextLine();

        boolean searchFinished = false;
        while(!searchFinished){
            System.out.println("Search for ingredients to stock.");
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
                        System.out.println("Which of these ingredients would you like to stock? Enter 's' to search again.");
                        choice = input.nextLine();
                        if(choice.equals("s")){
                            break;
                        }
                        else{
                            try{
                                ingredient = foodManager.getIngredient(searched.get(Integer.parseInt(choice)));

                                boolean amountFinished = false;
                                
                                while(!amountFinished){
                                    System.out.println("How many grams would you like to stock?");
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
                        
                                    foodManager.updateStock(ingredient, quantity);
                                    System.out.println("Ingredient stocked!");
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
                            System.out.println("Would you like to stock any more ingredients? y/n");
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
}
