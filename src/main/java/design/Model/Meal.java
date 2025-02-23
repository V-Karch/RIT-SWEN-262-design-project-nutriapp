package design.Model;

import java.util.List;

public class Meal implements Food{
    private String name;
    private List<Recipe> recipes;

    public Meal(String name, List<Recipe> recipes){
        this.name = name;
        this.recipes = recipes;
    }

    @Override
    public int getCalories() {
        int calories = 0;
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
    public int getFat() {
        int fat = 0;
        for (Recipe recipe : recipes){
            fat += recipe.getFat();
        }
        return fat;
    }

    @Override
    public int getProtein() {
        int protein = 0;
        for (Recipe recipe : recipes){
            protein += recipe.getProtein();
        }
        return protein;
    }

    @Override
    public int getFiber() {
        int fiber = 0;
        for (Recipe recipe : recipes){
            fiber += recipe.getFiber();
        }
        return fiber;
    }

    @Override
    public int getCarbs() {
        int carbs = 0;
        for (Recipe recipe : recipes){
            carbs += recipe.getCarbs();
        }
        return carbs;
    }
    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
    }
}
