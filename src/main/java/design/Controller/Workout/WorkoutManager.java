package design.Controller.Workout;

import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import design.Model.Workout.Intensity;
import design.Model.Workout.Workout;

public class WorkoutManager {
    private Map<String, Workout> workouts;

    public WorkoutManager() {
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

    public Workout recommendWorkout(int calories) {
        for (Workout workout: this.workouts.values()) {
            if (workout.getCalories() == calories) {
                return workout;
            }
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String date = now.format(formatter);

        return new Workout((int)(calories / 7.5), Intensity.MEDIUM, date, "Recommended Workout");
    }
}
