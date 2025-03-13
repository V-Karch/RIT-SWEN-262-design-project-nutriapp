package design.Model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import design.Controller.History.HistoryController;
public class DayScheduler {
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private CurrentDay currentDay;
    private HistoryController historyController;

    public DayScheduler(CurrentDay currentDay, HistoryController historyController) {
        this.currentDay = currentDay;
        this.historyController = historyController;
    }

    public void startScheduler(long period, TimeUnit unit) {
        scheduler.scheduleAtFixedRate(() -> {
            historyController.logTodaysActivity(currentDay.getDay()); // Log the activity of the current day
            currentDay.nextDay(); // Increment the day by 1
            this.stopScheduler(); // stop the day , will continue after entering new weight
        }, 0, period, unit);    
    }

    public void stopScheduler() {
        scheduler.shutdown();
    }
}
