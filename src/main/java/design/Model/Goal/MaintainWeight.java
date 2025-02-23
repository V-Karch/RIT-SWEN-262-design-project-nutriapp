package design.Model.Goal;

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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleWeightChange'");
  }

  @Override
  public void handleTargetWeightChange() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handleTargetWeightChange'");
  }
  
}
