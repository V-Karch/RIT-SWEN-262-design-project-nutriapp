package design.View;

import design.Controller.WorkoutBuilder;

public class CreateWorkout implements Action {
    private WorkoutBuilder workoutBuilder;

    public CreateWorkout(WorkoutBuilder workoutBuilder) {
        this.workoutBuilder = workoutBuilder;
    }

    // NOTE: I am not sure if this file is how this command is intended to work
    // I also made the change and assumption of a <<create>> for these Commands since they
    // are not shown in the draw.io
    // I also noticed that on the WorkoutCreation draw.io page
    // There is a Workout().addDailyCalories() method which is now shown on the Workout page
    // Is this intentional?

    @Override
    public void execute() {
        this.workoutBuilder.createWorkout();
    }

}
