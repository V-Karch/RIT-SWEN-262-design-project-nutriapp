package design.View;

import design.Controller.WorkoutBuilder;

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
