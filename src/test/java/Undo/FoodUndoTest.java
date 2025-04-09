package Undo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import design.Controller.Food.FoodManager;
import design.Controller.Goal.GoalManager;
import design.Controller.Undo.FoodUndo;
import design.Model.Food.Ingredient;
import design.Model.History.DailyActivity;
import design.Model.Undo.FoodSaveHistory;
import design.Model.UserSS.User;

public class FoodUndoTest {
    DailyActivity dA = new DailyActivity();
    User user = new User("User", 66, 160, "05-16-2005", dA, "hash");
    GoalManager goalManager = new GoalManager(user, dA);
    

    @Test
    void testSave() {
        try {
            FoodManager foodManager = new FoodManager("src/main/java/design/ingredients.csv");
            FoodSaveHistory foodSaveHistory = new FoodSaveHistory(foodManager);
            FoodUndo foodUndo = new FoodUndo(foodSaveHistory);
            foodUndo.storeSave();
            int actual = foodUndo.getHistory().size();
            assertEquals(1, actual);

        } catch(Exception e) {
            System.out.println("test failed");
        }
    }

    @Test
    void testUndo() {
        try {
            FoodManager foodManager = new FoodManager("src/main/java/design/ingredients.csv");
            FoodSaveHistory foodSaveHistory = new FoodSaveHistory(foodManager);
            FoodUndo foodUndo = new FoodUndo(foodSaveHistory);
            foodUndo.storeSave();
            Ingredient ingredient = foodManager.getIngredient("TURTLE GREEN RAW");
            foodManager.updateStock(ingredient, 100);
            assertEquals(100, ingredient.getStock());
            foodUndo.restoreSave();
            int actual = ingredient.getStock();
            assertEquals(0, actual);

        } catch(Exception e) {
            System.out.println("test failed");
        }
    }
}
