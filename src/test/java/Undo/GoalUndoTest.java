package Undo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import design.Controller.Goal.GoalManager;
import design.Controller.Undo.GoalUndo;
import design.Model.Undo.GoalSaveHistory;
import design.Model.UserSS.User;

public class GoalUndoTest {
    User user = new User("User", 66, 160, "05-16-2005");
    GoalManager goalManager = new GoalManager(user);

    GoalSaveHistory goalSaveHistory = new GoalSaveHistory(user);
    GoalUndo goalUndo = new GoalUndo(goalSaveHistory);

    @Test
    void testSave() {
        goalUndo.storeSave();
        int actual = goalUndo.getHistory().size();
        assertEquals(1, actual);
    }

    @Test
    void testUndo() {
        //inital conditions
        user.updateTargetWeight(180);
        goalManager.updateGoal();
        user.getGoal().addDailyCalories(100);
        goalUndo.storeSave();
        int expectedTC = goalManager.getTargetCalories();

        user.getGoal().addDailyCalories(100);
        goalUndo.restoreSave();
        int actualTC = goalManager.getTargetCalories();

        assertEquals(expectedTC, actualTC);
        assertEquals(100, goalManager.getDailyCalories());
    }
}
