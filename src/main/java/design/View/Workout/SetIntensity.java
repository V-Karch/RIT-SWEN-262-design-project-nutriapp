package design.View.Workout;

import java.util.Scanner;
import design.View.Action;
import design.Model.Workout.Intensity;
import design.Model.Workout.WorkoutBuilder;
import design.Controller.Workout.WorkoutController;

public class SetIntensity implements Action {

    private WorkoutController workoutController;
    private Scanner scanner;

    public SetIntensity(WorkoutController workoutController, Scanner scanner) {
        this.workoutController = workoutController;
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

        this.workoutController.setIntensity(intensity);
        
    }

}