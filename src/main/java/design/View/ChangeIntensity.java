package design.View;

import design.Model.Intensity;
import design.Controller.WorkoutBuilder;

public class ChangeIntensity implements Action {
    
    private Intensity intensity;
    private WorkoutBuilder workoutBuilder;

    public ChangeIntensity(WorkoutBuilder workoutBuilder, Intensity intensity) {
        this.workoutBuilder = workoutBuilder;
        this.intensity = intensity;
    }

    @Override
    public void execute() {
        this.workoutBuilder.setIntensity(this.intensity);
    }
    
}
