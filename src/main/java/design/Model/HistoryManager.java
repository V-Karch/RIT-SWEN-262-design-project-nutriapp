package design.Model;

import java.util.HashMap;

public class HistoryManager {
    HashMap<String, DailyActivity> history;

    public HashMap<String, DailyActivity> getHistory() {
        return history;
    }

    public DailyActivity getDailyActivity(String date) {
        return history.get(date);
    }

    public void addDailyActivity(String date, DailyActivity dailyActivity) {
        history.put(date, dailyActivity);
    }
}
