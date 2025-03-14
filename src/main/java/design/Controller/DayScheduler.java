package design.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
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
    private ScheduledFuture<?> task;
    private boolean isPaused;
    

    public DayScheduler(CurrentDay currentDay, HistoryController historyController, AddWeight weight) {
        this.currentDay = currentDay;
        this.historyController = historyController;
        this.weight = weight;
        this.period = 30;
        this.task = null;
        this.isPaused = false;
     
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public long getPeriod() {
        return this.period;
    }


    public void startScheduler() {
        
        if (task == null || task.isCancelled()) { // If the task is not running or cancelled

            task = scheduler.scheduleAtFixedRate(() -> {
                historyController.logTodaysActivity(currentDay.getDay()); // Log the activity of the current day
                currentDay.nextDay(); // Increment the day by 1
                
            }, period, period, TimeUnit.SECONDS);    // Start the scheduler after the given period
            System.out.println("Scheduler started");
        } else {
            System.out.println("Scheduler is already running");
        }

    } 

    public void pauseScheduler() {
        if (!task.isCancelled() && task != null) { 
            task.cancel(false);
            isPaused = true;
            System.out.println("Scheduler paused");
        }
    }

    public void resumeScheduler() {
        if (isPaused) {
            startScheduler();
            isPaused = false;
            
        }
    }

    public void stopScheduler() {
        scheduler.shutdown();
    }
}
