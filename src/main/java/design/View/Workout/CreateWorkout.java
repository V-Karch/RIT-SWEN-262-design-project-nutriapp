package design.View.Workout;

import design.View.Action;
import design.Controller.History.HistoryController;
import design.Controller.Workout.WorkoutBuilder;
import design.Model.Workout.Workout;

public class CreateWorkout implements Action {
    private WorkoutBuilder workoutBuilder;
    private HistoryController historyController;

    public CreateWorkout(WorkoutBuilder workoutBuilder,HistoryController historyController) {
        this.workoutBuilder = workoutBuilder;
        this.historyController = historyController;
    }

    @Override
    public void execute() {
        Workout workout = this.workoutBuilder.createWorkout(); 
        
        // need to log the workout in history
        this.historyController.logWorkout(workout); 
    }

}
