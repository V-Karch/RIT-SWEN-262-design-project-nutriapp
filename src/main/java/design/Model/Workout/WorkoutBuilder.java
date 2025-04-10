package design.Model.Workout;


import design.Model.CurrentDay;
import design.Model.History.Mediator;

public class WorkoutBuilder {
    private Intensity intensity;
    private int minutes;
    private String name;
    private CurrentDay currentDay;
    private Mediator dailyA;

    public WorkoutBuilder(CurrentDay currentDay, Mediator dailyA) {
        this.currentDay = currentDay;   
        this.intensity = Intensity.MEDIUM;
        this.minutes = 0;
        this.dailyA = dailyA;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }


    public void setName(String name) {
        this.name = name;
    }
    

    public Workout createWorkout() {
        // Make call to Goal subsystem so workout can be added to daily calories
        
        return new Workout(minutes, intensity, this.currentDay.getDay(), name, dailyA);
    }
}
