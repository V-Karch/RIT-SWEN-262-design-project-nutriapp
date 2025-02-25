package design.Controller.Food;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import design.Model.Food.Food;
import design.Model.Food.Ingredient;
import design.Model.Food.IngredientDatabase;
import design.Model.Food.Meal;
import design.Model.Food.Recipe;
import design.Model.Food.ShoppingList;

public class FoodManager {
    private List<Ingredient> Stock;
    private ArrayList<Food> MealsAndRecipes;
    private IngredientDatabase Ingredients;
    private ArrayList<ShoppingList> ShoppingLists;

    public FoodManager(String file) throws IOException {
        Ingredients = new IngredientDatabase(file);
        MealsAndRecipes = new ArrayList<Food>();
        Stock = Ingredients.getIngredients();
    }

    public void updateStock(Ingredient ingredient, int amount) {
        ingredient.addStock(amount);
    }

    /**
     * Adds an ingredient to a recipe
     * 
     * @param recipe
     * @param ingredient
     * @param quantity
     */
    public void addIngredient(Recipe recipe, String ingredient, int quantity) throws Exception {
        Ingredient ingredient_Obj = getIngredient(ingredient);
        recipe.addIngredient(ingredient_Obj, quantity);
    }

    public void addRecipe(Meal meal, Recipe recipe) {
        meal.addRecipe(recipe);
    }

    public void createRecipe(String name, String[] Instructions) {
        MealsAndRecipes.add(new Recipe(name, Instructions));
    }

    public void createMeal(String name) {
        MealsAndRecipes.add(new Meal(name));
    }

    public ShoppingList createShoppingList(List<Food> FoodList) {
        ShoppingList list = new ShoppingList(FoodList, "");
        ShoppingLists.add(list);
        return list;
    }

    /**
     * Gets a recommended shopping list based on ingredients that are low in stock
     * 
     * @return string list of recommended shopping items
     */
    public ArrayList<String> getRecommendedShoppingList() {
        ArrayList<String> recommended = new ArrayList<String>();
        for (Ingredient i : Stock) {
            if (i.getStock() <= 5) {
                recommended.add(i.getName());
            }
        }

        return recommended;
    }

    // public List<String> getRecommendedShoppingList(Recipe recipe) {

    // }

    public Ingredient getIngredient(String name) throws Exception {
        for (Ingredient i : Stock) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        throw new Exception("Could not find ingredient.");
    }

    public String[] getMealInstructions(Meal meal) {
        return new String[5]; // Temporary
    }
}
