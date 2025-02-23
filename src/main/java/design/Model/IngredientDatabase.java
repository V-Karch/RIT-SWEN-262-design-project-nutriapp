package design.Model;

import java.util.List;


public class IngredientDatabase {
    private List<Ingredient> ingredients;

    public IngredientDatabase(String filename){
        CSVReader reader = new CSVReader(filename);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Ingredient getIngredient(String name){
        for(Ingredient ingredient : ingredients){
            if(ingredient.getName().equals(name)){
                return ingredient;
            }
        }
        return new Ingredient();
    }
    
}
