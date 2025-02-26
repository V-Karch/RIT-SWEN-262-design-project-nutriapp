package design.View.Workout;

import design.View.Action;
import design.Controller.Workout.WorkoutBuilder;

public class CreateWorkout implements Action {
    private WorkoutBuilder workoutBuilder;

    public CreateWorkout(WorkoutBuilder workoutBuilder) {
        this.workoutBuilder = workoutBuilder;
    }

    @Override
    public void execute() {
        this.workoutBuilder.createWorkout(); 

        // need to log the workout in history
        // this.historyController.logWorkout(workout); 
    }

}
