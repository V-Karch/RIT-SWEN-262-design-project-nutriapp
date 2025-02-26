package design.Controller.Workout;

import design.Controller.History.HistoryController;
import design.Model.Workout.Intensity;
import design.Model.Workout.Workout;


public class WorkoutController {
    private WorkoutBuilder workoutBuilder;
    private WorkoutManager workoutManager;
    private HistoryController historyController;

    public WorkoutController(WorkoutBuilder workoutBuilder, WorkoutController workoutController, HistoryController historyController) {
        this.workoutBuilder = workoutBuilder;
        this.workoutManager = workoutController.workoutManager;
        this.historyController = historyController;
    }

    public void createWorkout() {
        Workout workout = this.workoutBuilder.createWorkout();
        this.workoutManager.addWorkout(workout);
        this.historyController.logWorkout(workout);
    }

    public Workout recommendWorkout(int calories) {
        return this.workoutManager.recommendWorkout(calories);
    }

    public Workout getWorkout(String date) {
        return this.workoutManager.getWorkout(date);
    }

    public void setMinutes(int minutes) {
        this.workoutBuilder.setMinutes(minutes);
    }

    public void setIntensity(Intensity intensity) { 
        this.workoutBuilder.setIntensity(intensity);
    }  

    public void setName(String name) {
        this.workoutBuilder.setName(name);
    }

    public void setDateTime() {
        this.workoutBuilder.setDateTime();
    }

}
