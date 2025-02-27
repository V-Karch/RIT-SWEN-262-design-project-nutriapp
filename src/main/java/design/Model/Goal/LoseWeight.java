package design.Model.Goal;

import design.Model.UserSS.User;

public class LoseWeight implements Goal {
  private User user;
  private boolean physicalFitness;
  private int targetCalories;
  private int dailyCalories;

  public LoseWeight(User user, boolean physicalFitness, int dailyCalories) {
    this.user = user;
    this.physicalFitness = physicalFitness;
    this.dailyCalories = dailyCalories;
    this.targetCalories = calculateTargetCalories();
  }

  @Override
  public int calculateTargetCalories() {
    double kg = user.getCurrentWeight() / 2.205;
    double cm = user.getHeight() * 2.54;
    int age = user.getAge();
    double calories = 10 * kg + 6.25 * cm - 5 * age;
    return (int)calories - 750;
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
      user.setGoal(new MaintainWeight(user, physicalFitness, dailyCalories));
    }
  }

  @Override
  public int getDailyCalories() {
    return dailyCalories;
  }

  @Override
  public boolean getPhysicalFitness() {
    return physicalFitness;
  }

  @Override
  public void setPhysicalFitness(boolean doesFitness) {
    physicalFitness = doesFitness;
  }

	@Override
	public User getUser() {
    return user;
  }
}
