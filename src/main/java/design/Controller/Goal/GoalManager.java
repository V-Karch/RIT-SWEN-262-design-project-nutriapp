package design.Controller.Goal;

import design.Model.Goal.Goal;
import design.Model.History.Colleague;
import design.Model.History.Mediator;
import design.Model.UserSS.User;
import design.Model.Workout.Workout;
import design.Model.Workout.WorkoutManager;
import static design.View.Goal.AddCalories.displayWorkout;

public class GoalManager implements Colleague{
  private User user;
  private Goal goal;
  private Mediator dailyA;

  public GoalManager(User user, Mediator dailyA) {
    this.user = user;
    this.goal = user.getGoal();
    this.dailyA = dailyA;
  }

  public void setGoal(Goal goal) {
    this.goal = goal;
    user.setGoal(goal);
  }

  public void setTargetWeight(double weight) {
    user.updateTargetWeight(weight);
    this.goal = user.getGoal();
  }

  public int getTargetCalories() {
    return goal.getTargetCalories();
  }

  public void setDailyWeight(double weight) {
    user.updateCurrentWeight(weight);
    goal = user.getGoal();
  }

  public int removeDailyCalories(int calories) {
    return goal.removeDailyCalories(calories);
  }

  public int addDailyCalories(int calories, WorkoutManager workoutManager) {
    int currentCalories = goal.addDailyCalories(calories);
    int targetCalories = goal.getTargetCalories();
    int calorieDifference = currentCalories - targetCalories;
    boolean physicalFitness = goal.getPhysicalFitness();
    if(calorieDifference > 0 && physicalFitness == true) {
      Workout workout = workoutManager.recommendWorkout(calorieDifference);
      displayWorkout(calorieDifference, workout);
    }
    return currentCalories;
  }

  public int getDailyCalories() {
    return goal.getDailyCalories();
  }

  public boolean getPhysicalFitness() {
    return goal.getPhysicalFitness();
  }

  public void setPhysicalFitness(boolean doesFitness) {
    goal.setPhysicalFitness(doesFitness);
  }

  public User getUser() {
    return goal.getUser();
  }

    @Override
    public void sendMessage() {
      dailyA.logDailyCalories(goal.getDailyCalories());
      dailyA.logTargetCalories(goal.getTargetCalories());
      goal.resetDailyCalories();
    }
}
