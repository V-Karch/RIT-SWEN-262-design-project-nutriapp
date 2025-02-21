package design.Controller;

import java.util.List;
import java.util.ArrayList;
import design.Model.Workout;

public class WorkoutManager {
    private List<Workout> workouts;
    
    public WorkoutManager() {
        this.workouts = new ArrayList<>();
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    public List<Workout> getWorkouts() {
        return this.workouts;
    }
}
