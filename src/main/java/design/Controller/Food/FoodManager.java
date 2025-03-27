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
    private List<Recipe> Recipes;
    private List<Meal> Meals;
    private IngredientDatabase Ingredients;
    private List<ShoppingList> ShoppingLists;

    public FoodManager(String file) throws IOException {
        Ingredients = new IngredientDatabase(file);
        Recipes = new ArrayList<Recipe>();
        Meals = new ArrayList<Meal>();
        ShoppingLists = new ArrayList<ShoppingList>();

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
        Recipes.add(new Recipe(name, Instructions));
    }

    public void createMeal(String name) {
        Meals.add(new Meal(name));
    }

    public ShoppingList createShoppingList(List<Ingredient> FoodList, String name) {
        ShoppingList list = new ShoppingList(FoodList, name);
        ShoppingLists.add(list);
        return list;
    }

    /**
     * Gets a recommended shopping list based on ingredients that are low in stock or in a recipe
     * 
     * @return string list of recommended shopping items
     */
    public ArrayList<Ingredient> getRecommendedShoppingList() {
        ArrayList<Ingredient> recommended = new ArrayList<Ingredient>();
        for (Ingredient i : Stock) {
            if (i.getStock() <= 5) {
                recommended.add(i);
            }
        }

        for(Recipe r : Recipes){
            List<Ingredient> recipeIngredients = r.getIngredients();
            for(Ingredient i : recipeIngredients){
                recommended.add(i);
            }
        }

        return recommended;
    }

    public Ingredient getIngredient(String name) throws Exception {
        for (Ingredient i : Stock) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        throw new Exception("Could not find ingredient.");
    }

    public List<String> getIngredients(){
        List<String> ingredients = new ArrayList<>();
        for (Ingredient i : Stock) {
            ingredients.add(i.getName());
        }
        return ingredients;
    }

    public String[] getMealInstructions(Meal meal) {
        return new String[5]; // Temporary
    }

    public List<Recipe> getAllRecipes()
    {
        return Recipes;
    }

    public List<Meal> getAllMeals(){
        return Meals;
    }

    public List<ShoppingList> getAllShoppingLists(){
        return ShoppingLists;
    }

    public ShoppingList getShoppingList(String name) throws Exception {
        for (ShoppingList s : ShoppingLists) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        throw new Exception("Could not find shopping list.");
    }

    public List<String> searchForIngredients(String searchTerm){
        List<Ingredient> searchedIngredients = Ingredients.searchForIngredients(searchTerm);
        List<String> ingredientStrings = new ArrayList<String>();
        for(Ingredient i : searchedIngredients){
            ingredientStrings.add(i.getName());
        }

        return ingredientStrings;
    }

}
