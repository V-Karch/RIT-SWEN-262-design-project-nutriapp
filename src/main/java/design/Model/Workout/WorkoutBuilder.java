package design.Model.Workout;


import design.Model.CurrentDay;

public class WorkoutBuilder {
    private Intensity intensity;
    private int minutes;
    private String name;
    private CurrentDay currentDay;

    public WorkoutBuilder(CurrentDay currentDay) {
        this.currentDay = currentDay;   
        this.intensity = Intensity.MEDIUM;
        this.minutes = 0;
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
        
        return new Workout(minutes, intensity, this.currentDay.getDay(), name);
    }
}
