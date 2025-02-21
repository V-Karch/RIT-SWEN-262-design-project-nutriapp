package design.View;

import design.Controller.WorkoutBuilder;

public class CreateWorkout implements Action {
    private WorkoutBuilder workoutBuilder;

    public CreateWorkout(WorkoutBuilder workoutBuilder) {
        this.workoutBuilder = workoutBuilder;
    }

    @Override
    public void execute() {
        this.workoutBuilder.createWorkout();
    }

}
