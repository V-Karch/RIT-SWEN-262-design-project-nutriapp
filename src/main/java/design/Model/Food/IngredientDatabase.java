package design.Model.Food;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import java.util.ArrayList;

public class IngredientDatabase {

    private List<Ingredient> ingredients;
    

    public IngredientDatabase(String file) throws IOException {
        FileReader reader = new FileReader(file);
        CSVReader csvreader = new CSVReader(reader, ',', '"', 1);
        this.ingredients = new ArrayList<Ingredient>();
        List<String[]> ingredientData = csvreader.readAll();
        for (String[] ingredient : ingredientData) {
                this.ingredients.add(new Ingredient(ingredient[1], ensureInt(ingredient[3]), ensureDouble(ingredient[4]), ensureDouble(ingredient[5]), ensureDouble(ingredient[7]), ensureDouble(ingredient[8])));
        }
        csvreader.close();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    private int ensureInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private double ensureDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public Ingredient getIngredient(String name) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(name)) {
                return ingredient;
            }
        }
        return new Ingredient();
    }
    
    public List<Ingredient> searchForIngredients(String searchTerm){
        ArrayList<Ingredient> result = new ArrayList<Ingredient>();
        searchTerm = searchTerm.toUpperCase();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().contains(searchTerm)) {
                result.add(ingredient);
            }
        }
        return result;
    }

}
