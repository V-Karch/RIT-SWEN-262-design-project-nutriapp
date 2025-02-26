package design.View.Workout;

import design.View.Action;
import design.Controller.History.HistoryController;
import design.Controller.Workout.WorkoutController;
import design.Model.Workout.Workout;
import design.Model.Workout.WorkoutBuilder;

public class CreateWorkout implements Action {
    private WorkoutController workoutController;
    private HistoryController historyController;

    public CreateWorkout(WorkoutController workoutController,HistoryController historyController) {
        this.workoutController = workoutController;
        this.historyController = historyController;
    }

    @Override
    public void execute() {
        Workout newWorkout = this.workoutController.createWorkout(); 
        
        //log the new workout in history
        this.historyController.logWorkout(newWorkout); 

        System.out.println("Workout created! Name: " + newWorkout.getName() + ", Intensity: " + newWorkout.getIntensity() + ", Minutes: " + newWorkout.getMinutes());
    }

}
