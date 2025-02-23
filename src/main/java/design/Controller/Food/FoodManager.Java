package design.Controller.Food;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import design.Model.Food;
import design.Model.Ingredient;
import design.Model.Recipe;

public class FoodManager {

    private ArrayList<Ingredient> Stock;
    private ArrayList<Food> MealsAndRecipes;
    private IngredientDatabase Ingredients;
    private ArrayList<ShoppingList> ShoppingLists;

    public FoodManager() {
        Ingredients = new IngredientDatabase();
        MealsAndRecipes = new ArrayList<Food>();
        Stock = Ingredients.getIngredients();
    }

    public void updateStock(Ingredient ingredient, int amount) {
        ingredient.addStock(amount);
    }

    /**
     * Adds an ingredient to a recipe
     * @param recipe
     * @param ingredient
     * @param quantity
     */
    public void addIngredient(Recipe recipe, Ingredient ingredient, int quantity)
    {
        recipe.addIngredient(ingredient, quantity);
    }

    public void addRecipe(Meal meal, Recipe recipe)
    {
        meal.addRecipe(recipe);
    }

    public void createRecipe(String name, String[] Instructions) {
        Stock.add(new Recipe(name, Instructions));
    }

    public void createRecipe(String name){
        Stock.add(new Recipe(name, ""));
    }

    public void createMeal(String name) {
        Stock.add(new Meal(name));
    }

    public List<String> createShoppingList(List<Food> FoodList) {
        ShoppingLists.add(new ShoppingList(FoodList));
    }

    /**
     * Gets a recommended shopping list based on ingredients that are low in stock
     * @return string list of recommended shopping items
     */
    public ArrayList<String> getRecommendedShoppingList() {
        ArrayList<String> recommended = new ArrayList<String>();
        for(Ingredient i : Stock)
        {
            if(i.getStock() <= 5)
            {
                recommended.add(i.getName());
            }
        }

        return recommended;
    }

    // public List<String> getRecommendedShoppingList(Recipe recipe) {
        
    // }

    public Ingredient getIngredient(String name) {
        for(Ingredient i : Stock)
        {
            if(i.getName().equals(name))
            {
                return i;
            }
        }
        throw new Exception("Could not find ingredient.");
    }

    public String[] getMealInstructions(Meal meal) {  
    }
}
