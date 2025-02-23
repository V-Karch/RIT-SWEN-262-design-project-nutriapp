package design.View.Workout;

import design.View.Action;
import design.Controller.Workout.WorkoutBuilder;

public class SetMinutes implements Action {

    private int minutes;
    private WorkoutBuilder workoutBuilder;

    public SetMinutes(WorkoutBuilder workoutBuilder, int minutes) {
        this.workoutBuilder = workoutBuilder;
        this.minutes = minutes;
    }

    @Override
    public void execute() {
        this.workoutBuilder.setMinutes(minutes);
    }

}
