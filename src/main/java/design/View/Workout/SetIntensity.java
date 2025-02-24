package design.View.Workout;

import java.util.Scanner;
import design.View.Action;
import design.Model.Workout.Intensity;
import design.Controller.Workout.WorkoutBuilder;

public class SetIntensity implements Action {

    private WorkoutBuilder workoutBuilder;
    private Scanner scanner;

    public SetIntensity(WorkoutBuilder workoutBuilder, Scanner scanner) {
        this.workoutBuilder = workoutBuilder;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter an intensity: ");
        String line = this.scanner.nextLine().toLowerCase();
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