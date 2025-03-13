package design.Model;

public class CurrentDay {
    private int day;

    public CurrentDay() {
        this.day = 1;
    }

    public int getDay() {
        return this.day;
    }

    public void nextDay() { // Increment the day by 1
        this.day++;
    }
}
