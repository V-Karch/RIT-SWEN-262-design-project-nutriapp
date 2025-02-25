package design.View.Goal;

import java.util.Scanner;

import design.Controller.Goal.GoalManager;
import design.Controller.Workout.WorkoutManager;
import design.Model.Workout.Workout;
import design.View.Action;

public class AddCalories implements Action{
  private GoalManager goalManager;
  private WorkoutManager workoutManager;
  private Scanner scanner;

  public AddCalories(GoalManager goalManager, WorkoutManager workoutManager, Scanner scanner) {
    this.goalManager = goalManager;
    this.workoutManager = workoutManager;
    this.scanner = scanner;
  }

  public static void displayWorkout(int calorieDifference, Workout workout) {
    System.out.println("You are " + calorieDifference + " calories over your target.");
    System.out.println("To burn " + calorieDifference + " calories, workout for " + workout.getMinutes() + " minutes at " + workout.getIntensity() + " intensity.");
  }

  @Override
  public void execute() {
    System.out.println("Enter calories to add:");
    try {
      int calories = scanner.nextInt();
      int newCalories = this.goalManager.addDailyCalories(calories, workoutManager);
      System.out.println("Total daily calories:" + newCalories);
    }
    catch(Exception e) {
      System.out.println("Invaid calories");
    }
    scanner.close();
  }
  
}
