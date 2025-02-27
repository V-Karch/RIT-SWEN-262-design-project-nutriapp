package design.Model.Food;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import java.util.ArrayList;


public class IngredientDatabase {
    private List<Ingredient> ingredients;
    

    public IngredientDatabase(String file) throws IOException{
        FileReader reader = new FileReader(file);
        CSVReader csvreader = new CSVReader(reader,',','"',1);
        this.ingredients = new ArrayList<Ingredient>();
        List<String[]> ingredientData = csvreader.readAll();
        for (String[] ingredient : ingredientData){
            try{
            this.ingredients.add(new Ingredient(ingredient[1], Integer.parseInt(ingredient[3]), Double.parseDouble(ingredient[4]), Double.parseDouble(ingredient[5]), Double.parseDouble(ingredient[7]), Double.parseDouble(ingredient[8])));
        } finally{
            this.ingredients.add(new Ingredient(ingredient[1], Integer.parseInt(ingredient[3]), Double.parseDouble(ingredient[4]), Double.parseDouble(ingredient[5]), Double.parseDouble(ingredient[7])));
        }
    }
        csvreader.close();
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
