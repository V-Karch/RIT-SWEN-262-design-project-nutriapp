package design.View.Goal;

import design.Controller.Goal.GoalManager;
import design.View.Action;

public class GetDailyCalories implements Action { 
  private GoalManager goalManager;

  public GetDailyCalories(GoalManager goalManager) {
    this.goalManager = goalManager;
  }

  @Override
  public void execute() {
    int dailyCalories = goalManager.getTargetCalories();
    System.out.println("Daily calories: " + dailyCalories);
  }
}
