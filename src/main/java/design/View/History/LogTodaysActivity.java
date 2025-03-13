package design.View.History;


import design.Controller.History.HistoryController;
import design.Model.CurrentDay;
import design.View.Action;

public class LogTodaysActivity implements Action {

    private HistoryController historyController;
    private CurrentDay currentDay;
    

    public LogTodaysActivity(HistoryController historyController, CurrentDay currentDay) {
        this.historyController = historyController;
        this.currentDay = currentDay;

    }

    @Override
    public void execute() {
        //Save the previous day's activity to history and create a new DailyActivity object for today
        this.historyController.logTodaysActivity(String.valueOf(currentDay.getDay())); 
        System.out.println("Activity logged for the previous day!");
    }
}
