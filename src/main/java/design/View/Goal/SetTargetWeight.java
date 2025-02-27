package design.View.Goal;

import java.util.Scanner;

import design.Controller.Goal.GoalManager;
import design.View.Action;

public class SetTargetWeight implements Action {
  private GoalManager goalManager;
  private Scanner scanner;

  public SetTargetWeight(GoalManager goalManager, Scanner scanner) {
    this.goalManager = goalManager;
    this.scanner = scanner;
  }

  @Override
  public void execute() {
    System.out.println("Enter target weight:");
    try {
      String weight_S = scanner.nextLine();
      Double weight = Double.parseDouble(weight_S);
      this.goalManager.setTargetWeight(weight);
      System.out.println("Target weight updated.");
    }
      catch(Exception e) {
      System.out.println("Invalid weight");
    }
  }
}
