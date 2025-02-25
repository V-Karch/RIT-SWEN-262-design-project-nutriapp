package design.View.Goal;

import java.util.Scanner;

import design.Controller.Goal.GoalManager;
import design.View.Action;

public class SetDailyWeight  implements Action {
  private GoalManager goalManager;
  private Scanner scanner;

  public SetDailyWeight(GoalManager goalManager, Scanner scanner) {
    this.goalManager = goalManager;
    this.scanner = scanner;
  }

  @Override
  public void execute() {
    System.out.println("Enter daily weight:");
    try {
      double weight = scanner.nextDouble();
      this.goalManager.setDailyWeight(weight);
      System.out.println("Daily weight updated.");
    }
    catch(Exception e) {
      System.out.println("Invalid weight");
    }
  }
}
