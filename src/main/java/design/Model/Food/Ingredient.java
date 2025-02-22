package design.Model.Food;

public class Ingredient implements Food {
    private int protein;
    private int carbs;
    private int fiber;
    private int calories;
    private int fat;
    private int stock;
    private String name;
    
    public Ingredient(String name, int protein, int carbs, int fiber, int calories, int fat) {
        this.protein = protein;
        this.carbs = carbs;
        this.fiber = fiber;
        this.calories = calories;
        this.fat = fat;
        this.name = name;
    }
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
    public int getStock() {
        return stock;
    }
    public String getName() {
        return name;
    }
    public void addStock(int amount){
        this.stock += amount;
    }
    public void use(int amount){
        this.stock -= amount;
    }
}
