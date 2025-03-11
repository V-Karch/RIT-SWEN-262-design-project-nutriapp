package Goal;

import org.junit.jupiter.api.Test;

import design.Controller.Goal.GoalManager;
import design.Model.UserSS.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoalTest {
    @Test
    public void testUpdateGoalToLose() {
        User user = new User("User", 66, 160, "05-16-2005");
        GoalManager goalManager = new GoalManager(user);
        goalManager.updateCurrentWeight(180);
        assertEquals(user.currentGoal.getTargetCalories(), goalManager.getTargetCalories());
    }

    @Test
    public void testUpdateGoalToMaintain() {
        User user = new User("User", 66, 160, "05-16-2005");
        GoalManager goalManager = new GoalManager(user);
        goalManager.updateCurrentWeight(160);
        assertEquals(user.currentGoal.getTargetCalories(), goalManager.getTargetCalories());
    }

    @Test
    public void testUpdateGoalToGain() {
        User user = new User("User", 66, 160, "05-16-2005");
        GoalManager goalManager = new GoalManager(user);
        goalManager.updateCurrentWeight(140);
        assertEquals(user.currentGoal.getTargetCalories(), goalManager.getTargetCalories());
    }
}
