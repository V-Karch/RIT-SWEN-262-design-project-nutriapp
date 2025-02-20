package design.Model.Food;

public class Ingredient implements Food {
    private int protein;
    private int carbs;
    private int fiber;
    private int calories;
    private int fat;
    private String name;
    
    public int getProtein() {
        return protein;
    }
    public int getCarbs() {
        return carbs;
    }
    public int getFiber() {
        return fiber;
    }
    public int getCalories() {
        return calories;
    }
    public int getFat() {
        return fat;
    }
    public String getName() {
        return name;
    }
}
