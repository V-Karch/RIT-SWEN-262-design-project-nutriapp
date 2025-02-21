package design.Model;

public class Workout {
    private int minutes;
    private Intensity intensity;
    private String date;
    private int calories;

    public Workout(int minutes, Intensity intensity, String date) {
        this.minutes = minutes;
        this.intensity = intensity;
        this.date = date;

        this.calories = (int)(minutes * intensity.getValue());
    }

    public int getMinutes() { return this.minutes; }
    public Intensity getIntensity() { return this.intensity; }
    public int getCalories() { return this.calories; }
    public String getDate() { return this.date; }
}
