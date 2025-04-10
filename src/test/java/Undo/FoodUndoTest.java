package Undo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.lang.reflect.Array;

import org.junit.jupiter.api.Test;

import design.Controller.Food.FoodManager;
import design.Controller.Goal.GoalManager;
import design.Controller.History.HistoryController;
import design.Controller.Undo.DailyActivityUndo;
import design.Controller.Undo.FoodUndo;
import design.Controller.Undo.GoalUndo;
import design.Model.Food.Ingredient;
import design.Model.Food.Meal;
import design.Model.Food.Recipe;
import design.Model.History.DailyActivity;
import design.Model.Undo.DailyActivitySaveHistory;
import design.Model.Undo.FoodSaveHistory;
import design.Model.Undo.GoalSaveHistory;
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
            assertEquals(0, 1);
        }
    }

    @Test
    void testUndo() {
        try {
            FoodManager foodManager = new FoodManager("src/main/java/design/ingredients.csv");
            FoodSaveHistory foodSaveHistory = new FoodSaveHistory(foodManager);
            FoodUndo foodUndo = new FoodUndo(foodSaveHistory);
            foodUndo.storeSave();
            Ingredient ingredient = foodManager.getIngredient("TURTLE,GREEN,RAW");
            foodManager.updateStock(ingredient, 100);
            assertEquals(100, ingredient.getStock());
            foodUndo.restoreSave();
            int actual = foodManager.getIngredient("TURTLE,GREEN,RAW").getStock();
            assertEquals(0, actual);

        } catch(Exception e) {
            System.out.println("test failed");
            assertEquals(0, 1);
        }
    }

    @Test
    void testEverything() {
        try {
            //Food setup
            FoodManager foodManager = new FoodManager("src/main/java/design/ingredients.csv");
            FoodSaveHistory foodSaveHistory = new FoodSaveHistory(foodManager);
            FoodUndo foodUndo = new FoodUndo(foodSaveHistory);
            //store ingredient
            Ingredient ingredient = foodManager.getIngredient("TURTLE,GREEN,RAW");
            foodManager.updateStock(ingredient, 100);
            //assertEquals(100, ingredient.getStock());
            //make meal
            String[] instructions = {"green", "raw"};
            Recipe recipe = foodManager.createRecipe("turtle", instructions);
            foodManager.addIngredient(recipe, ingredient.getName(), 100);
            Meal meal = foodManager.createMeal("turtle green raw");
            foodManager.addRecipe(meal, recipe);
            foodUndo.storeSave();
            DailyActivitySaveHistory dAHistory = new DailyActivitySaveHistory(dA);
            DailyActivityUndo dActivityUndo = new DailyActivityUndo(dAHistory);
            dActivityUndo.storeSave();
            String expectedActivity = dA.logDayActivities();

            GoalSaveHistory goalSaveHistory = new GoalSaveHistory(user);
            GoalUndo goalUndo = new GoalUndo(goalSaveHistory);
            goalUndo.storeSave();

            //eat meal
            foodManager.updateStock(ingredient, 100);
            foodManager.prepareMeal(0, user.getGoal(), null);
            

            foodUndo.restoreSave();
            goalUndo.restoreSave();
            dActivityUndo.restoreSave();
            int actual = ingredient.getStock();
            assertEquals(0, actual);
            assertEquals(0, goalManager.getDailyCalories());
            assertEquals(expectedActivity, dA.logDayActivities());

        } catch(Exception e) {
            System.out.println("test failed");
            assertEquals(0, 1);
        }
    }
}
