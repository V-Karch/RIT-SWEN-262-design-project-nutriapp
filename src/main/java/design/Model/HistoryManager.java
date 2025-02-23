package design.Model;

import java.util.HashMap;
import java.util.Scanner;

public class HistoryManager {
    HashMap<String, DailyActivity> history;
    DailyActivity todaysActivity;
    Scanner scanner = new Scanner(System.in);

    public HashMap<String, DailyActivity> getHistory() {
        return history;
    }

    public DailyActivity getDailyActivity(String date) { 
        return history.get(date);
    }

    public DailyActivity getTodaysActivity() {
        return todaysActivity;
    }

    public void setTodaysActivity(DailyActivity todaysActivity) {
        this.todaysActivity = todaysActivity;
    }

    public void saveDailyActivityToHistory(String date) {
        history.put(date, this.todaysActivity); // save the current day's activity to the history
        System.out.println("Enter your weight for today: "); // prompt the user to enter their weight for the next day
        int weight = scanner.nextInt();
        setTodaysActivity(new DailyActivity(weight)); // create a new DailyActivity object for the next day with the user's weight for today
    }

    
    
}
