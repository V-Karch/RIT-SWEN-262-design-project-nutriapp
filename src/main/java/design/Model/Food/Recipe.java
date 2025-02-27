package design.Model.Food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recipe implements Food{
    private String name;
    private HashMap<Ingredient, Integer> ingredients;
    private String[] CookInstructions;

    public Recipe(String name, String[] CookInstructions){
        this.name = name;
        this.CookInstructions = CookInstructions;
    }

    public String getName() {
        return name;
    }

    public String[] getCookInstructions() {
        return CookInstructions;
    }
    
    public void addIngredient(Ingredient ingredient, Integer quantity){
        this.ingredients.put(ingredient, quantity);
    }
    public void addCookInstructions(String[] CookInstructions){
        this.CookInstructions = CookInstructions;
    }
    public void useIngredients(){
        for (Ingredient ingredient : ingredients.keySet()){
            ingredient.use(ingredients.get(ingredient));
        }
    }
    public Integer getCalories(){
        Integer calories = 0;
        for (Ingredient ingredient : ingredients.keySet()){
            calories += ingredient.getCalories();
        }
        return calories;
    }
    public Double getFat(){
        Double fat = 0.0;
        for (Ingredient ingredient : ingredients.keySet()){
            fat += ingredient.getFat();
        }
        return fat;
    }
    public Double getCarbs(){
        Double carbs = 0.0;
        for (Ingredient ingredient : ingredients.keySet()){
            carbs += ingredient.getCarbs();
        }
        return carbs;
    }
    public Double getProtein(){
        Double protein = 0.0;
        for (Ingredient ingredient : ingredients.keySet()){
            protein += ingredient.getProtein();
        }
        return protein;
    }
    public Double getFiber(){
        Double fiber = 0.0;
        for (Ingredient ingredient : ingredients.keySet()){
            fiber += ingredient.getFiber();
        }
        return fiber;
    }

    public List<Ingredient> getIngredients(){
        List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
        for(Ingredient i : ingredients.keySet()){
            ingredientsList.add(i);
        }

        return ingredientsList;
    }
}
