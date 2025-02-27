package design.Model.Food;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private String name;
    private List<Ingredient> ingredients;

    public ShoppingList(List<Ingredient> ingredients, String name){
        this.ingredients = ingredients;
        this.name = name;
    }

    public List<String> getShoppingList(){
        List<String> shoppingList = new ArrayList<String>();
        for (Food ingredient : ingredients){
            shoppingList.add(ingredient.getName());
        }
        return shoppingList;
    }
    public List<String> addToShoppingList(Ingredient ingredient){
        List<String> shoppingList = this.getShoppingList();
        shoppingList.add(ingredient.getName());
        return shoppingList;
    }
    public List<String> removeFromShoppingList(Ingredient ingredient){
        List<String> shoppingList = this.getShoppingList();
        shoppingList.remove(ingredient.getName());
        return shoppingList;
    }

    public String getName() {
        return this.name;
    }
}
