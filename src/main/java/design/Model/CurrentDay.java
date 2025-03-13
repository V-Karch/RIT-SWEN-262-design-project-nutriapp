package design.Model;

import java.util.concurrent.TimeUnit;

public class CurrentDay {
    private int day;
    private DayScheduler dayScheduler;

    public CurrentDay() {
        this.day = 1;
    }

    public String getDay() {
        return String.valueOf(this.day);
    }

    public void nextDay() { // Increment the day by 1
        this.day++;
        System.out.println("\nToday is Day " + (getDay()));
    }

    public void startDayScheduler(long initialDelay, long period, TimeUnit unit) {
        if (dayScheduler == null) {
            dayScheduler = new DayScheduler(this);
        }
        dayScheduler.startScheduler(initialDelay, period, unit);
    }

    public void stopDayScheduler() {
        if (dayScheduler != null) {
            dayScheduler.stopScheduler();
        }
    }
}
