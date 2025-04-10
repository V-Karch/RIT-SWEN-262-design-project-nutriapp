package design.Controller.History;

import design.Model.History.HistoryManager;

public class HistoryController {
    private HistoryManager historyManager;

    public HistoryController(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    public HistoryManager getHistoryManager(){
        return this.historyManager;
    }



    public void logTodaysActivity(String date) { 
        this.historyManager.logTodaysActivity(date);
    }
    
    public String searchForDailyActivity(String date) {  //searches for the daily activity of a specific date
        return this.historyManager.getDailyActivity(date);
    }
}
