package design.View.Goal;

import design.Controller.Goal.GoalManager;
import design.Model.Goal.Goal;
import design.View.Action;

public class SetGoal implements Action {
  private GoalManager goalManager;
  private Goal goal;
  
  public SetGoal(GoalManager goalManager, Goal goal) {
    this.goalManager = goalManager;
    this.goal = goal;
  }

  @Override
  public void execute() {
    this.goalManager.setGoal(goal);
  }
  
}
