package design.Controller;


import java.util.concurrent.TimeUnit;

import design.Model.CurrentDay;

public class DayScheduler {
    private Thread schedulerThread;
    private CurrentDay currentDay;
    private long period;
    private volatile boolean paused;
    private volatile boolean running;
    private volatile boolean dayOver;
    

    public DayScheduler(CurrentDay currentDay) {
        this.currentDay = currentDay;
        
        this.period = 30;
        this.paused = false;
        this.running = false;
        this.dayOver = false;
        
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public long getPeriod() {
        return this.period;
    }

    public boolean isDayOver() {
        return dayOver;
    }

    public boolean isPaused(){
        return paused;
    }



    public void startScheduler() {
        if (schedulerThread == null || !schedulerThread.isAlive()) {
            running = true;
            schedulerThread = new Thread(() -> {
                while (running) {
                    try {
                        if (!paused) {
                            Thread.sleep(TimeUnit.SECONDS.toMillis(period));

                            dayOver = true;
                            pauseScheduler();

                        } else {
                            Thread.sleep(500); // Sleep briefly while paused
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("[System] Scheduler thread interrupted");
                    }
                }
                System.out.println("[System] Scheduler stopped.");
            });

            schedulerThread.start();
            System.out.println("[System] Scheduler started.");
        } else {
            System.out.println("[System] Scheduler is already running.");
        }
    }

    public void pauseScheduler() {
        paused = true;
        System.out.println("[System] Scheduler paused. Please finish your current action then press enter to resume.");
    }

    public void resumeScheduler() {
        if (paused) {
            paused = false;
            dayOver = false;
            currentDay.nextDay();
            System.out.println("[System] Scheduler resumed.");
        }
    }

    public void stopScheduler() {
        running = false;
        if (schedulerThread != null) {
            schedulerThread.interrupt();
        }
        System.out.println("[System] Scheduler stopped.");
    }


}

