package design.Model;


public class CurrentDay {
    private int day;
    

    public CurrentDay() {
        this.day = 1;
    }

    public String getDay() {
        return String.valueOf(this.day);
    }

    public void nextDay() { // Increment the day by 1
        this.day++;
        System.out.println("\nToday is Day " + (getDay()) );
    }

    
}
