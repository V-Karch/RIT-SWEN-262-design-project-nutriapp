package design.Controller.Workout;

import design.Model.Workout.Intensity;
import design.Model.Workout.Workout;
import design.Model.Workout.WorkoutBuilder;
import design.Model.Workout.WorkoutManager;


public class WorkoutController {
    private WorkoutBuilder workoutBuilder;
    private WorkoutManager workoutManager;

    public WorkoutController(WorkoutBuilder workoutBuilder, WorkoutManager workoutManager) {
        this.workoutBuilder = workoutBuilder;
        this.workoutManager = workoutManager;
    }

    public Workout createWorkout() {
        Workout workout = this.workoutBuilder.createWorkout();
        this.workoutManager.addWorkout(workout);
        return workout;
    }

    public Workout recommendWorkout(int calories) { // needs a View Command
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

    public void setName(String name) { //needs a View Command
        this.workoutBuilder.setName(name); 
    }

    public void setDateTime() {
        this.workoutBuilder.setDateTime();
    }

}
