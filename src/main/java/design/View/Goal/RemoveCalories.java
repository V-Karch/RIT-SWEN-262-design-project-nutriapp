package design.View.Goal;

import java.util.Scanner;

import design.Controller.Goal.GoalManager;
import design.View.Action;

public class RemoveCalories implements Action {
  private GoalManager goalManager;
  private Scanner scanner;

  public RemoveCalories(GoalManager goalManager, Scanner scanner) {
    this.goalManager = goalManager;
    this.scanner = scanner;
  }

  @Override
  public void execute() {
    System.out.println("Enter calories to remove:");
    try {
      int calories = scanner.nextInt();
      int newCalories = this.goalManager.removeDailyCalories(calories);
      System.out.println("Total daily calories:" + newCalories);
    }
    catch(Exception e) {
      System.out.println("Invalid calories");
    }
  }
}
