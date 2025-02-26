package design.View.Workout;

import design.View.Action;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import design.Controller.Workout.WorkoutController;

public class SetName implements Action {

    private WorkoutController workoutController;
    private Scanner scanner;

    public SetName(WorkoutController workoutController, Scanner scanner) {
        this.workoutController = workoutController;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter a name for this workout: ");
            String line = this.scanner.nextLine().toLowerCase();
            this.workoutController.setName(line);

        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

}
