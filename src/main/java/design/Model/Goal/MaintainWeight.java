package design.Model.Goal;

import design.Model.UserSS.User;

public class MaintainWeight implements Goal {
  private User user;
  private boolean physicalFitness;
  private int targetCalories;
  private int dailyCalories;

  public MaintainWeight(User user, boolean physicalFitness, int targetCalories, int dailyCalories) {
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

    if(currentWeight - targetWeight <= -5.0) {
      user.setGoal(new GainWeight(user, physicalFitness, targetCalories, dailyCalories));
    } else if(currentWeight - targetWeight >= 5.0) {
      user.setGoal(new LoseWeight(user, physicalFitness, targetCalories, dailyCalories));
    }
  }
}
