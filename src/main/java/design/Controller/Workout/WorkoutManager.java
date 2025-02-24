package design.Controller.Workout;

import java.util.Map;
import java.util.HashMap;

import design.Controller.History.HistoryController;
import design.Model.Workout.Workout;

public class WorkoutManager {
    private Map<String, Workout> workouts;
    private HistoryController historyController;

    public WorkoutManager(HistoryController historyController) {
        this.workouts = new HashMap<>();
    }

    public void addWorkout(Workout workout) {
        this.workouts.put(workout.getName(), workout);
    }

    public Workout getWorkout(String date) {
        return this.workouts.get(date);
    }

    public Map<String, Workout> getWorkouts() {
        return this.workouts;
    }
}
