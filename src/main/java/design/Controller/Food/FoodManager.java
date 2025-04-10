package design.Controller.Food;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import design.Controller.History.HistoryController;
import design.Model.Food.Ingredient;
import design.Model.Food.IngredientDatabase;
import design.Model.Food.Meal;
import design.Model.Food.Recipe;
import design.Model.Food.ShoppingList;
import design.Model.Goal.Goal;

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

    public Recipe createRecipe(String name, String[] Instructions) {
        Recipes.add(new Recipe(name, Instructions));
        return Recipes.get(Recipes.size()-1);
    }

    public Meal createMeal(String name) {
        Meals.add(new Meal(name));
        return Meals.get(Meals.size()-1);
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

    public List<String> getMealList(){
        List<String> mealList = new ArrayList<String>();
        for(Meal m : Meals){
            mealList.add(m.getName());
        }

        return mealList;
    }

    public List<String> getMealInstructions(int index){
        return Meals.get(index).getInstructions();
    }

    public void prepareMeal(int index, Goal goal, HistoryController hc){
        Meal meal = Meals.get(index);
        meal.prepareMeal();
        goal.addDailyCalories(meal.getCalories());
        // hc.logMeal(meal);
    }

    public List<String> getMealIngredients(int index){
        List<String> ingredientStrings = new ArrayList<String>();
        List<Ingredient> ingredients = Meals.get(index).getIngredients();
        for(Ingredient i: ingredients){
            ingredientStrings.add(i.getName());
        }

        return ingredientStrings;
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

    public List<Ingredient> getStock() {
        return this.Stock;
    }

    public String getMeal(int index){
        return Meals.get(index).toString();
    }

}
