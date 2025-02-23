package design.Controller.Goal;

import design.Model.Goal.Goal;
import design.Model.UserSS.User;

public class GoalManager {
  private User user;
  private Goal goal;

  public GoalManager(User user, Goal goal) {
    this.user = user;
    this.goal = goal;
  }

  public void setGoal(Goal goal) {
    user.setGoal(goal);
  }

  public void setTargetWeight(double weight) {
    user.updateTargetWeight(weight);
  }

  public int getTargetCalories() {
    return goal.getTargetCalories();
  }

  public void setDailyWeight(double weight) {
    user.updateCurrentWeight(weight);
  }

  public int removeDailyCalories(int calories) {
    return goal.removeDailyCalories(calories);
  }

  public int addDailyCalories(int calories) {
    return goal.addDailyCalories(calories);
  }
}
