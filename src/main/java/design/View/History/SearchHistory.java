package design.View.History;


import java.util.Scanner;
import java.util.Set;

import design.Controller.History.HistoryController;
import design.View.Action;

public class SearchHistory implements Action{
    
    private Scanner input;
    private HistoryController historyController;


    public SearchHistory(Scanner input, HistoryController historyController) {
        this.input = input;
        this.historyController = historyController;
    }

    @Override
    public void execute() {
        System.out.println("Enter the number of a previous day to view that day's activities : ");
        
        System.out.println("Previous days:"); // Displays all the previous days that have been logged
        Set<String> dates = historyController.getHistoryManager().getHistory().keySet();
        for (String date : dates) {
            System.out.println("Day " + date);
        }


        try {
            String date = input.nextLine();
            String dailyActivity = historyController.searchForDailyActivity(date);

            System.out.println("\n***ACTIVITY FOR DAY " + date + "***");

            System.out.println(dailyActivity);

        } catch (Exception e) {
            System.out.println("Invalid Date.");
        }
        
    }
}
