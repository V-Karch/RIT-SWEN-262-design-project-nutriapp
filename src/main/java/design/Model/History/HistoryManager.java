package design.Model.History;

import java.util.HashMap;

public class HistoryManager {
    private HashMap<String, DailyActivity> history; // date is a string 
    private DailyActivity todaysActivity;
   

    public HistoryManager() {
        this.history = new HashMap<String, DailyActivity>();
        setTodaysActivity(new DailyActivity()); // create a new DailyActivity object for today 
    }

    public HashMap<String, DailyActivity> getHistory() {
        return history;
    }

    public DailyActivity getDailyActivity(String date) { 
        return history.get(date);
    }

    public DailyActivity getTodaysActivity() {
        return todaysActivity;
    }

    public void setTodaysActivity(DailyActivity todaysActivity) {
        this.todaysActivity = todaysActivity;
    }

    public void setTodaysWeight(int weight) {
        this.todaysActivity.setWeight(weight);
    }

    public void saveTodaysActivityToHistory(String date) {
        history.put(date, this.todaysActivity); // save the current day's activity to the history 
        setTodaysActivity(new DailyActivity()); // create a new DailyActivity object for the next day 
    }

    
    
}
