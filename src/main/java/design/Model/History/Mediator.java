package design.Model.History;

public interface Mediator {
    public void logWeight(double weight);
    public void logWorkout(String workout);
    public void logMeal(String meal);
    public void logDailyCalories(int cal);
    public void logTargetCalories(int cal);
    public String logDayActivities();
}
