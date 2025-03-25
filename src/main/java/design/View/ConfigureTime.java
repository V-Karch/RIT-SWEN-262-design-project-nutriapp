package design.View;



import java.util.Scanner;

import design.Controller.DayScheduler;

public class ConfigureTime implements Action {
    private DayScheduler dayScheduler;
    private Scanner scanner;

    public ConfigureTime(DayScheduler dayScheduler, Scanner scanner) {
        this.dayScheduler = dayScheduler;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter the period for the next day to start (in seconds): ");
        System.out.print("$ ");
        String period_S = scanner.nextLine();
        long period = Long.parseLong(period_S);
        
        System.out.println("A new day will start after every " + period + " seconds.");
        this.dayScheduler.setPeriod(period);


    }
    
}
