package Goal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import design.Controller.Goal.GoalManager;
import design.Model.History.DailyActivity;
import design.Model.UserSS.User;

public class GoalTest {
    DailyActivity dA = new DailyActivity();

    @Test
    public void testUpdateGoalToLose() {
        User user = new User("User", 66, 160, "05-16-2005", "password", dA);
        GoalManager goalManager = new GoalManager(user, dA);
        goalManager.setDailyWeight(180);
        assertEquals(user.currentGoal.getTargetCalories(), goalManager.getTargetCalories());
    }

    @Test
    public void testUpdateGoalToMaintain() {
        User user = new User("User", 66, 160, "05-16-2005", "password", dA);
        GoalManager goalManager = new GoalManager(user, dA);
        goalManager.setDailyWeight(160);
        assertEquals(user.currentGoal.getTargetCalories(), goalManager.getTargetCalories());
    }

    @Test
    public void testUpdateGoalToGain() {
        User user = new User("User", 66, 160, "05-16-2005", "password", dA);
        GoalManager goalManager = new GoalManager(user, dA);
        goalManager.setDailyWeight(140);
        assertEquals(user.currentGoal.getTargetCalories(), goalManager.getTargetCalories());
    }
}
