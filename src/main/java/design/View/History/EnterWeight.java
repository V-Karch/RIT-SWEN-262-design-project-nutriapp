package design.View.History;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        //Save the previous day's activity to history
        this.historyController.logTodaysActivity(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))); 

        //Enter the user's weight
        System.out.println("Enter your weight:");
       try {
           int weight = Integer.parseInt(input.nextLine());
           this.historyController.logWeight(weight);
       } catch (Exception e) {
           System.out.println("Invalid weight");
       }
    }
}
