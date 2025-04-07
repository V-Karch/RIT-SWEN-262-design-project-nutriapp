package design.Model.Goal;

import design.Model.Undo.GoalSave;
import design.Model.UserSS.User;

public interface Goal {
  public int calculateTargetCalories();
  public int getTargetCalories();
  public int removeDailyCalories(int calories);
  public int addDailyCalories(int calories);
  public void handleWeightChange();
  public int getDailyCalories();
  public boolean getPhysicalFitness();
  public void setPhysicalFitness(boolean doesFitness);
  public User getUser();
  public GoalSave creatGoalSave();
  public void restoreSave(GoalSave save);
}
