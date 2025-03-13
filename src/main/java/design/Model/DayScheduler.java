package design.Model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DayScheduler {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final CurrentDay currentDay;

    public DayScheduler(CurrentDay currentDay) {
        this.currentDay = currentDay;
    }

    public void startScheduler(long initialDelay, long period, TimeUnit unit) {
        scheduler.scheduleAtFixedRate(() -> currentDay.nextDay(), initialDelay, period, unit);
    }

    public void stopScheduler() {
        scheduler.shutdown();
    }
}
