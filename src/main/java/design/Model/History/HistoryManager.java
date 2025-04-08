package design.Model.History;

import java.util.HashMap;

public class HistoryManager implements Colleague{
    private HashMap<String, String> history; // date is a string 
    private Mediator todaysActivity;
    private String date;
   

    public HistoryManager(Mediator dailyA) {
        this.history = new HashMap<String, String>();
        this.todaysActivity = dailyA; // create a new DailyActivity object for today 
    }

    public HashMap<String, String> getHistory() {
        return history;
    }

    public String getDailyActivity(String date) { 
        return history.get(date);
    }

    public void logTodaysActivity(String date) { 
        this.date = date;
        this.sendMessage();
    }


    @Override
    public void sendMessage() {

        String activity = todaysActivity.logDayActivities();
        history.put(date, activity);
    }

    
    
}
