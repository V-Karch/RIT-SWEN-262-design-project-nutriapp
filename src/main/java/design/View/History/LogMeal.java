package design.View.History;

import java.util.Scanner;

import design.Controller.History.HistoryController;
import design.View.Action;

public class LogMeal implements Action {
    private HistoryController historyController;
    private Scanner input;

    public LogMeal(HistoryController historyController, Scanner input) {
        this.historyController = historyController;
        this.input = input;
    }

    @Override
    public void execute() {
        //Logs a meal to the user's history
        System.out.println("Enter the meal you would like to eat:");
        try {
            String meal = input.nextLine();
            this.historyController.logMeal(meal);
        } catch (Exception e) {
            System.out.println("Invalid meal");
        }
        input.close();
    }
}
