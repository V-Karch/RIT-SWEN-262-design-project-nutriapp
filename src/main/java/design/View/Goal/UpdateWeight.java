package design.View.Goal;

import java.util.Scanner;

import design.Controller.Goal.GoalManager;
import design.Controller.History.HistoryController;
import design.View.Action;

public class UpdateWeight implements Action {
    private GoalManager goalManager;
    private Scanner scanner;
    private HistoryController historyController;

    public UpdateWeight(GoalManager goalManager, Scanner scanner, HistoryController historyController) {
        this.goalManager = goalManager;
        this.scanner = scanner;
        this.historyController = historyController;
    }

    @Override
    public void execute() {
    System.out.println("Enter your weight in lbs: ");
    try {
        String weight_S = scanner.nextLine().trim();
        System.out.println(weight_S);
        double weight = Double.parseDouble(weight_S);
        System.out.println(weight);
        System.out.println(goalManager.getUser().getName());
        this.goalManager.setDailyWeight(weight);
        System.out.println("got here");
        this.historyController.logWeight(((int)(weight))); // cast float to int
        System.out.println("also got here");
        System.out.println("Weight updated.");
    }
        catch(Exception e) {
        System.out.println("Invalid weight");
    }
  }
}
