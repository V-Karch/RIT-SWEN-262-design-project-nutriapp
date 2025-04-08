package design.Model.Workout;

import java.util.Map;

import design.Model.Teams.TeamUserInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class WorkoutManager {
    private Map<String, Workout> workouts;
    private TeamUserInterface teamUser;
    

    public WorkoutManager(TeamUserInterface teamUser) {
        this.workouts = new HashMap<>();
        this.teamUser = teamUser;
    }

    public void addWorkout(Workout workout) {
        this.workouts.put(workout.getName(), workout);
        teamUser.newWorkout(workout);
    }

    public Workout getWorkout(String date) {
        return this.workouts.get(date);
    }

    public Map<String, Workout> getWorkouts() {
        return this.workouts;
    }

    public Workout recommendWorkout(int calories) {
        HashMap<Intensity, Integer> intensityCount = new HashMap<>();

        for (Workout workout : this.workouts.values()) {
            Intensity intensity = workout.getIntensity();
            intensityCount.put(intensity, intensityCount.getOrDefault(intensity, 0) + 1);
        }

        Intensity mostCommonIntensity = Intensity.MEDIUM;
        int maxCount = 0;

        for (Map.Entry<Intensity, Integer> entry : intensityCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonIntensity = entry.getKey();
            }
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String date = now.format(formatter);

        return new Workout((int) (calories / 7.5), mostCommonIntensity, date, "Recommended Workout");
    }
}
