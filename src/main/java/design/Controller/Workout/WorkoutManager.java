package design.Controller.Workout;

import java.util.Map;
import java.util.HashMap;

import design.Controller.History.HistoryController;
import design.Model.Workout.Workout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WorkoutManager {
    private Map<String, Workout> workouts;
    private HistoryController historyController;

    public WorkoutManager(HistoryController historyController) {
        this.workouts = new HashMap<>();
        this.historyController = historyController;
    }

    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return now.format(formatter);
    }

    public void addWorkout(Workout workout) {
        String currentTime = this.getCurrentTime();
        this.workouts.put(currentTime, workout);
        this.historyController.logWorkout(workout); // history controller logs the workout to todays daily activity when a workout is added
    }

    public Workout getWorkout(String date) {
        return this.workouts.get(date);
    }

    public Map<String, Workout> getWorkouts() {
        return this.workouts;
    }
}
