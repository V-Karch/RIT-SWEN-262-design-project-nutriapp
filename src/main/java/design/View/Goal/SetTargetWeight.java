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
      double calories = scanner.nextDouble();
      this.goalManager.setTargetWeight(calories);
      System.out.println("Target weight updated.");
    }
    catch(Exception e) {
      System.out.println("Invalid weight");
    }
    scanner.close();
    
  }
}
