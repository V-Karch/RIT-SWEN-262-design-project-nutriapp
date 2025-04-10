package design.View.Goal;

import java.util.Scanner;

import design.Controller.Goal.GoalManager;
import design.Controller.Undo.UserUndo;
import design.View.Action;

public class SetTargetWeight implements Action {
  private GoalManager goalManager;
  private Scanner scanner;
  private UserUndo userUndo;

  public SetTargetWeight(GoalManager goalManager, Scanner scanner, UserUndo userUndo) {
    this.goalManager = goalManager;
    this.scanner = scanner;
    this.userUndo = userUndo;
  }

  @Override
  public void execute() {
    //save before executing
    userUndo.storeSave();

    System.out.println("Enter target weight:");
    System.out.print("$ ");
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
