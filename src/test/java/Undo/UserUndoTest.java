package Undo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import design.Controller.Goal.GoalManager;
import design.Controller.Undo.UserUndo;
import design.Model.History.DailyActivity;
import design.Model.Undo.UserSaveHistory;
import design.Model.UserSS.User;

public class UserUndoTest {
    DailyActivity dA = new DailyActivity();
    User user = new User("User", 66, 160, "05-16-2005", dA, "hash");
    GoalManager goalManager = new GoalManager(user, dA);
    
    UserSaveHistory userSaveHistory = new UserSaveHistory(user);
    UserUndo userUndo = new UserUndo(userSaveHistory);
    
    @Test
    void testSave() {
        userUndo.storeSave();
        int actual = userUndo.getHistory().size();
        assertEquals(1, actual);
    }

    @Test
    void testUndo() {
        //create base save
        int expected = goalManager.getTargetCalories();
        userUndo.storeSave();

        //change weight then undo
        goalManager.setDailyWeight(170);
        userUndo.restoreSave(goalManager);
        int actual = goalManager.getTargetCalories();

        assertEquals(expected, actual);
    }

    @Test
    void testUndoFurther() {
        //fill saves
        goalManager.setDailyWeight(170);
        userUndo.storeSave();
        goalManager.setDailyWeight(180);
        userUndo.storeSave();
        goalManager.setDailyWeight(190);
        userUndo.storeSave();
        int expected = goalManager.getTargetCalories();

        //change weight then undo
        goalManager.setDailyWeight(200);
        userUndo.restoreSave(goalManager);
        int actual = goalManager.getTargetCalories();

        assertEquals(expected, actual);
    }

    @Test
    void testPurge() {
        userUndo.storeSave();
        userUndo.storeSave();
        userUndo.storeSave();

        userUndo.purge(2);
        int actual = userUndo.getHistory().size();

        assertEquals(1, actual);
    }
}
