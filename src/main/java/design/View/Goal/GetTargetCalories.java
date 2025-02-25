package design.View.Goal;

import design.Controller.Goal.GoalManager;
import design.View.Action;

public class GetTargetCalories implements Action {
  private GoalManager goalManager;

  public GetTargetCalories(GoalManager goalManager) {
    this.goalManager = goalManager;
  }

  @Override
  public void execute() {
    int targetCalories = goalManager.getTargetCalories();
    System.out.println("Target calories: " + targetCalories);
  }
}
