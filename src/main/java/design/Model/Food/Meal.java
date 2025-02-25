package design.Model.Food;

import java.util.List;

public class Meal implements Food{
    private String name;
    private List<Recipe> recipes;
    private String[] mealInstructions;

    public Meal(String name){
        this.name = name;
    }

    @Override
    public Integer getCalories() {
        Integer calories = 0;
        for (Recipe recipe : recipes){
            calories += recipe.getCalories();
        }
        return calories;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getFat() {
        Double fat = 0.0;
        for (Recipe recipe : recipes){
            fat += recipe.getFat();
        }
        return fat;
    }

    @Override
    public Double getProtein() {
        Double protein = 0.0;
        for (Recipe recipe : recipes){
            protein += recipe.getProtein();
        }
        return protein;
    }

    @Override
    public Double getFiber() {
        Double fiber = 0.0;
        for (Recipe recipe : recipes){
            fiber += recipe.getFiber();
        }
        return fiber;
    }

    @Override
    public Double getCarbs() {
        Double carbs = 0.0;
        for (Recipe recipe : recipes){
            carbs += recipe.getCarbs();
        }
        return carbs;
    }
    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
    }

    @Override
    public String toString() {
        return "Meal[Name: " + name + ", Calories: " + getCalories() + ", Fat: " + getFat() + 
            ", Protein: " + getProtein() + ", Fiber: " + getFiber() + ", Carbs: " + getCarbs() + "]";
    }
}
