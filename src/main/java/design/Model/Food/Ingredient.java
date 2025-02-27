package design.Model.Food;

public class Ingredient implements Food {
    private Double protein;
    private Double carbs;
    private Double fiber;
    private Integer calories;
    private Double fat;
    private Integer stock;
    private String name;
    
    public Ingredient(String name, Integer calories, Double protein, Double carbs, Double fat, Double fiber) {
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
    public Ingredient(String name, Integer calories, Double protein, Double carbs, Double fat) {
        this.protein = protein;
        this.carbs = carbs;
        this.calories = calories;
        this.fat = fat;
        this.name = name;
    }
    public Double getProtein() {
        return protein;
    }
    public Double getCarbs() {
        return carbs;
    }
    public Double getFiber() {
        return fiber;
    }
    public Integer getCalories() {
        return calories;
    }
    public Double getFat() {
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
