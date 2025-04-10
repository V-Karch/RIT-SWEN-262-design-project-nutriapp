package design.Model.Undo;

import java.util.List;

import design.Model.Food.Ingredient;
import design.Model.Food.IngredientDatabase;
import design.Model.Food.Meal;
import design.Model.Food.Recipe;
import design.Model.Food.ShoppingList;

public class FoodSave {
    private List<Ingredient> stock;
    private List<Recipe> recipes;
    private List<Meal> meals;
    private IngredientDatabase ingredients;
    private List<ShoppingList> shoppingLists;

    public FoodSave(List<Ingredient> stock, List<Recipe> recipes, List<Meal> meals, IngredientDatabase ingredients, List<ShoppingList> shoppingLists) {
        this.stock = stock;
        this.recipes = recipes;
        this.meals = meals;
        this. ingredients = ingredients;
        this. shoppingLists = shoppingLists;
    }

    public List<Ingredient> getStock() {
        return stock;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public IngredientDatabase getIngredients() {
        return ingredients;
    }

    public List<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }
}
