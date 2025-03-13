package design.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import design.Controller.History.HistoryController;
import design.Model.CurrentDay;
public class DayScheduler {
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private CurrentDay currentDay;
    private HistoryController historyController;

    public DayScheduler(CurrentDay currentDay, HistoryController historyController) {
        this.currentDay = currentDay;
        this.historyController = historyController;
    }

    public void startScheduler(long period) {
        scheduler.scheduleAtFixedRate(() -> {
            historyController.logTodaysActivity(currentDay.getDay()); // Log the activity of the current day
            currentDay.nextDay(); // Increment the day by 1
            this.stopScheduler(); // stop the day , will continue after entering new weight
        }, 0, period, TimeUnit.SECONDS);    
    }

    public void stopScheduler() {
        scheduler.shutdown();
    }
}
