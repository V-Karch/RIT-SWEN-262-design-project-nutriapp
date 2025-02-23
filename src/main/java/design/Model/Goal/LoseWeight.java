package design.Model.Goal;

public class LoseWeight implements Goal {
  private User user;
  private boolean physicalFitness;
  private int targetCalories;
  private int dailyCalories;

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
