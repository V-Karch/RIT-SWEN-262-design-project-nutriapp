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
    System.out.println("Would you like to include physical fitness? (true or false)");
    try {
      String doesFitness_S = scanner.nextLine();
      Boolean doesFitness = Boolean.getBoolean(doesFitness_S);
      this.goalManager.setPhysicalFitness(doesFitness);
      System.out.println("Physical fitness updated.");
    }
    catch(Exception e) {
      System.out.println("Invalid input, true or false required");
    }
  }
}
