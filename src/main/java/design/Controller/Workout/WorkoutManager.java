package design.Controller.Workout;

import java.util.Map;
import java.util.HashMap;
import design.Model.Workout.Workout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WorkoutManager {
    private Map<String, Workout> workouts;

    public WorkoutManager() {
        this.workouts = new HashMap<>();
    }

    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return now.format(formatter);
    }

    public void addWorkout(Workout workout) {
        String currentTime = this.getCurrentTime();
        this.workouts.put(currentTime, workout);
    }

    public Workout getWorkout(String date) {
        return this.workouts.get(date);
    }

    public Map<String, Workout> getWorkouts() {
        return this.workouts;
    }
}
