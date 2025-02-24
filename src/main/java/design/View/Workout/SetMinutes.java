package design.View.Workout;

import design.View.Action;

import java.util.Scanner;

import design.Controller.Workout.WorkoutBuilder;

public class SetMinutes implements Action {

    private WorkoutBuilder workoutBuilder;
    private Scanner scanner;

    public SetMinutes(WorkoutBuilder workoutBuilder, Scanner scanner) {
        this.workoutBuilder = workoutBuilder;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter an amount of time in minutes: ");
            String line = this.scanner.nextLine().toLowerCase();

            int value = Integer.parseInt(line);
            value = value < 0 ? 0 : value; // Ensure value is >= 0
            
            this.workoutBuilder.setMinutes(value);
        } catch (NumberFormatException e) {
            System.out.println("Your input was not an integer. >:(");
        }
    }

}
