package design.View.Goal;

import java.util.Scanner;

import design.Controller.Goal.GoalManager;
import design.Controller.History.HistoryController;
import design.Controller.Undo.UserUndo;
import design.View.Action;
import design.View.NALogger;

public class UpdateWeight implements Action {
    private GoalManager goalManager;
    private Scanner scanner;
    private NALogger logger;
    private UserUndo userUndo;

    public UpdateWeight(GoalManager goalManager, Scanner scanner, NALogger logger, UserUndo userUndo) {
        this.goalManager = goalManager;
        this.scanner = scanner;
        this.logger = logger;
        this.userUndo = userUndo;
    }

    @Override
    public void execute() {
    //save before executing
    userUndo.storeSave();
    
    System.out.println("Enter your weight in lbs: ");
    try {
        String weight_S = scanner.nextLine().trim();
        double weight = Double.parseDouble(weight_S);
        this.goalManager.setDailyWeight(weight);
        logger.message("Weight updated");
    }
        catch(Exception e) {
        logger.message("Invalid weight");
    }
  }
}
