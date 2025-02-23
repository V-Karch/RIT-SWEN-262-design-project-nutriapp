package design.View.Workout;

import design.View.Action;

import java.util.Scanner;

import design.Controller.Workout.WorkoutBuilder;

public class SetMinutes implements Action {

    private WorkoutBuilder workoutBuilder;

    public SetMinutes(WorkoutBuilder workoutBuilder) {
        this.workoutBuilder = workoutBuilder;
    }

    @Override
    public void execute() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter an amount of time in minutes: ");
            String line = scanner.nextLine().toLowerCase();

            int value = Integer.parseInt(line);
            value = value < 0 ? 0 : value; // Ensure value is >= 0
            
            this.workoutBuilder.setMinutes(value);
        }
    }

}
