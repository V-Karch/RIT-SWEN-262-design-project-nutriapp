package design.Controller;

import design.Model.Workout;
import design.Model.Intensity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WorkoutBuilder {
    private String date;
    private Intensity intensity;
    private int minutes;

    public WorkoutBuilder() {
        this.setDateTime();
        this.intensity = Intensity.MEDIUM;
        this.minutes = 0;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }

    public void setDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.date = now.format(formatter);
    }

    public Workout createWorkout() {
        return new Workout(minutes, intensity, date);
    }
}
