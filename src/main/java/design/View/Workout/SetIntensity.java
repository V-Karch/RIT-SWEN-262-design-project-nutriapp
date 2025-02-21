package design.View.Workout;

import design.Controller.WorkoutBuilder;
import design.Model.Workout.Intensity;
import design.View.Action;

public class SetIntensity implements Action {
    
    private Intensity intensity;
    private WorkoutBuilder workoutBuilder;

    public SetIntensity(WorkoutBuilder workoutBuilder, Intensity intensity) {
        this.workoutBuilder = workoutBuilder;
        this.intensity = intensity;
    }

    @Override
    public void execute() {
        this.workoutBuilder.setIntensity(this.intensity);
    }
    
}
