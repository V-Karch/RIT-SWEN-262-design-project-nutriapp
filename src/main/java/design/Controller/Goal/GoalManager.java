package design.Controller.Goal;

import design.Model.Goal.Goal;
import design.Model.UserSS.User;
import design.Model.Workout.Workout;
import design.Model.Workout.WorkoutManager;

import static design.View.Goal.AddCalories.displayWorkout;

public class GoalManager {
  private User user;
  private Goal goal;

  public GoalManager(User user, Goal goal) {
    this.user = user;
    this.goal = goal;
  }

  public void setGoal(Goal goal) {
    user.setGoal(goal);
  }

  public void setTargetWeight(double weight) {
    user.updateTargetWeight(weight);
  }

  public int getTargetCalories() {
    return goal.getTargetCalories();
  }

  public void setDailyWeight(double weight) {
    user.updateCurrentWeight(weight);
  }

  public int removeDailyCalories(int calories) {
    return goal.removeDailyCalories(calories);
  }

  public int addDailyCalories(int calories, WorkoutManager workoutManager) {
    int currentCalories = goal.addDailyCalories(calories);
    int targetCalories = goal.getTargetCalories();
    int calorieDifference = currentCalories - targetCalories;
    if(calorieDifference > 0) {
      Workout workout = workoutManager.recommendWorkout(calorieDifference);
      displayWorkout(calorieDifference, workout);
    }
    return currentCalories;
  }
}
