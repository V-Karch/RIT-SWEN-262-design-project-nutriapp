package design.View.Workout;

import java.util.Scanner;
import design.View.Action;
import design.Model.Workout.Intensity;
import design.Controller.Workout.WorkoutBuilder;

public class SetIntensity implements Action {

    private WorkoutBuilder workoutBuilder;

    public SetIntensity(WorkoutBuilder workoutBuilder) {
        this.workoutBuilder = workoutBuilder;
    }

    @Override
    public void execute() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter an intensity: ");

            String line = scanner.nextLine().toLowerCase();

            Intensity intensity;

            if (line == "high") {
                intensity = Intensity.HIGH;
            } else if (line == "medium") {
                intensity = Intensity.MEDIUM;
            } else { // Defaults to low
                intensity = Intensity.LOW;
            }

            this.workoutBuilder.setIntensity(intensity);
        }
    }

}