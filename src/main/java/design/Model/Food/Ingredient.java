package design.Model.Food;

public class Ingredient implements Food {
    private Integer protein;
    private Integer carbs;
    private Integer fiber;
    private Integer calories;
    private Integer fat;
    private Integer stock;
    private String name;
    
    public Ingredient(String name, Integer calories, Integer protein, Integer carbs, Integer fat, Integer fiber) {
        this.protein = protein;
        this.carbs = carbs;
        this.fiber = fiber;
        this.calories = calories;
        this.fat = fat;
        this.name = name;
    }
    public Ingredient() {
        //TODO Auto-generated constructor stub
    }
    public Integer getProtein() {
        return protein;
    }
    public Integer getCarbs() {
        return carbs;
    }
    public Integer getFiber() {
        return fiber;
    }
    public Integer getCalories() {
        return calories;
    }
    public Integer getFat() {
        return fat;
    }
    public Integer getStock() {
        return stock;
    }
    public String getName() {
        return name;
    }
    public void addStock(Integer amount){
        this.stock += amount;
    }
    public void use(Integer amount){
        this.stock -= amount;
    }
}
