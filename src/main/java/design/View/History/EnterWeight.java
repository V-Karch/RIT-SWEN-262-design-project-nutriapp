package design.View.History;

import java.util.Scanner;

import design.Controller.History.HistoryController;
import design.View.Action;

public class EnterWeight implements Action {

    private HistoryController historyController;
    private Scanner input;

    public EnterWeight(Scanner input, HistoryController historyController) {
        this.historyController = historyController;
        this.input = input;
    }

    @Override
    public void execute() {
       System.out.println("Enter your weight:");
       try {
           int weight = Integer.parseInt(input.nextLine());
           this.historyController.logWeight(weight);
       } catch (Exception e) {
           System.out.println("Invalid weight");
       }
    }
}
