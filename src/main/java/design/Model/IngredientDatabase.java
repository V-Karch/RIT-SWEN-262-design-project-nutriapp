package design.Model;

import java.util.List;

import javax.naming.NameNotFoundException;

public class IngredientDatabase {
    private List<Ingredient> ingredients;

    public IngredientDatabase(){

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
