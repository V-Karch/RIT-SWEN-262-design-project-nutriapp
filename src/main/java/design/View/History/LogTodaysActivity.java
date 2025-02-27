package design.View.History;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import design.Controller.History.HistoryController;
import design.View.Action;

public class LogTodaysActivity implements Action {

    private HistoryController historyController;
    

    public LogTodaysActivity(HistoryController historyController) {
        this.historyController = historyController;

    }

    @Override
    public void execute() {
        //Save the previous day's activity to history and create a new DailyActivity object for today
        this.historyController.logTodaysActivity(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))); 
        System.out.println("Activity logged for the previous day!");
    }
}
