package design.Model.Workout;

public class Workout {
    private int minutes;
    private Intensity intensity;
    private String date;
    private String name;
    private int calories;

    public Workout(int minutes, Intensity intensity, String date, String name) {
        this.minutes = minutes;
        this.intensity = intensity;
        this.date = date;
        this.name = name;

        this.calories = (int)(minutes * intensity.getValue());
    }

    public int getMinutes() { return this.minutes; }
    public Intensity getIntensity() { return this.intensity; }
    public int getCalories() { return this.calories; }
    public String getDate() { return this.date; }
    public String getName() { return this.name; }

    
    @Override
    public String toString() {
        return "Workout[Name: " + getName() + ", Date: " + getDate() + ", Minutes: " + 
            getMinutes() + ", Intensity: " + getIntensity() + ", Calories: " + getCalories() + "]"; 
    }
}
