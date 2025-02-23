package design.Model;

import java.util.HashMap;

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
    
    public void addIngredient(Ingredient ingredient, int quantity){
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
    public int getCalories(){
        int calories = 0;
        for (Ingredient ingredient : ingredients.keySet()){
            calories += ingredient.getCalories();
        }
        return calories;
    }
    public int getFat(){
        int fat = 0;
        for (Ingredient ingredient : ingredients.keySet()){
            fat += ingredient.getFat();
        }
        return fat;
    }
    public int getCarbs(){
        int carbs = 0;
        for (Ingredient ingredient : ingredients.keySet()){
            carbs += ingredient.getCarbs();
        }
        return carbs;
    }
    public int getProtein(){
        int protein = 0;
        for (Ingredient ingredient : ingredients.keySet()){
            protein += ingredient.getProtein();
        }
        return protein;
    }
    public int getFiber(){
        int fiber = 0;
        for (Ingredient ingredient : ingredients.keySet()){
            fiber += ingredient.getFiber();
        }
        return fiber;
    }
}
