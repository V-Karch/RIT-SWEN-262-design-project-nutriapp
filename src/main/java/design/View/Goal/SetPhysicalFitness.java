package design.View.Goal;

import java.util.Scanner;

import design.Controller.Goal.GoalManager;
import design.View.Action;

public class SetPhysicalFitness implements Action {
  private GoalManager goalManager;
  private Scanner scanner;

  public SetPhysicalFitness(GoalManager goalManager, Scanner scanner) {
    this.goalManager = goalManager;
    this.scanner = scanner;
  }

  @Override
  public void execute() {
    System.out.println("Enter target weight:");
    try {
      boolean doesFitness = scanner.nextBoolean();
      this.goalManager.setPhysicalFitness(doesFitness);
      System.out.println("Physical fitness updated.");
    }
    catch(Exception e) {
      System.out.println("Invalid input, true or false required");
    }
  }
}
