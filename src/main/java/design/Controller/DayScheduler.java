package design.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import design.Controller.History.HistoryController;
import design.Model.CurrentDay;
import design.View.User.AddWeight;

public class DayScheduler {
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private CurrentDay currentDay;
    private HistoryController historyController;
    private AddWeight weight;
    private long period;

    public DayScheduler(CurrentDay currentDay, HistoryController historyController, AddWeight weight) {
        this.currentDay = currentDay;
        this.historyController = historyController;
        this.weight = weight;
        this.period = 30;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public void startScheduler() {
        scheduler.scheduleAtFixedRate(() -> {
            historyController.logTodaysActivity(currentDay.getDay()); // Log the activity of the current day
            currentDay.nextDay(); // Increment the day by 1
            this.stopScheduler(); // stop the day , will continue after entering new weight
            weight.execute(); // Ask the user to enter their weight
        }, period, period, TimeUnit.SECONDS);    // Start the scheduler after the given period
    }

    public void stopScheduler() {
        scheduler.shutdown();
    }
}
