package design.Model.Goal;

import java.lang.Math;

public class GainWeight implements Goal{
  private User user;
  private boolean physicalFitness;
  private int targetCalories;
  private int dailyCalories;

  public GainWeight(User user, boolean physicalFitness, int targetCalories, int dailyCalories) {
    this.user = user;
    this.physicalFitness = physicalFitness;
    this.targetCalories = targetCalories;
    this.dailyCalories = dailyCalories;
  }

  @Override
  public int getTargetCalories() {
    return targetCalories;
  }

  @Override
  public int removeDailyCalories(int calories) {
    dailyCalories -= calories;
    return dailyCalories;
  }

  @Override
  public int addDailyCalories(int calories) {
    dailyCalories += calories;
    return dailyCalories;
  }

  @Override
  public void handleWeightChange() {
    //context
    double currentWeight = user.getCurrentWeight();
    double targetWeight = user.getTargetWeight();

    if(Math.abs(currentWeight - targetWeight) < 5.0) {
      user.setGoal(new MaintainWeight(user, physicalFitness, targetCalories, dailyCalories));
    }
  }
}
