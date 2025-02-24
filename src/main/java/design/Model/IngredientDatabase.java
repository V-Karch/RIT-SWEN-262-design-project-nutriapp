package design.Model;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;


public class IngredientDatabase {
    private List<Ingredient> ingredients;

    public IngredientDatabase(String file) throws IOException{
        FileReader reader = new FileReader(file);
        CSVReader csvreader = new CSVReader(reader);
        List<String[]> ingredientData = csvreader.readAll();
        for (String[] ingredient : ingredientData){
            ingredients.add(new Ingredient(ingredient[1], Integer.parseInt(ingredient[3]), Integer.parseInt(ingredient[4]), Integer.parseInt(ingredient[5]), Integer.parseInt(ingredient[7]), Integer.parseInt(ingredient[8])));
        }
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
