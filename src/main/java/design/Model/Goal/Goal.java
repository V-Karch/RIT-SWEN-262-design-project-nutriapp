package design.Model.Goal;

public interface Goal {
  public int calculateTargetCalories();
  public int getTargetCalories();
  public int removeDailyCalories(int calories);
  public int addDailyCalories(int calories);
  public void handleWeightChange();
  public void setPhysicalFitness();
}
