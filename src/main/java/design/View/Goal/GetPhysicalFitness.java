package design.View.Goal;

import design.Controller.Goal.GoalManager;
import design.View.Action;

public class GetPhysicalFitness implements Action {
  private GoalManager goalManager;

  public GetPhysicalFitness(GoalManager goalManager) {
    this.goalManager = goalManager;
  }

  @Override
  public void execute() {
    boolean physicalFitness = goalManager.getPhysicalFitness();
    System.out.println("Include physical fitness: " + physicalFitness);
  }
}
