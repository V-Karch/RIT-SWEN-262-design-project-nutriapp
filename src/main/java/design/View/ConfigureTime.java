package design.View;



import design.Controller.DayScheduler;

public class ConfigureTime implements Action {
    private DayScheduler dayScheduler;

    public ConfigureTime(DayScheduler dayScheduler) {
        this.dayScheduler = dayScheduler;
    }

    @Override
    public void execute() {
        System.out.println("Enter the period for the next day to start (in seconds): ");
        long period = Long.parseLong(System.console().readLine());
        
        System.out.println("A new day will start after every " + period + " seconds.");
        this.dayScheduler.startScheduler(period);


    }
    
}
