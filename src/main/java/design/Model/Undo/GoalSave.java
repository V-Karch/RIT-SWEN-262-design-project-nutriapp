package design.Model.Undo;

import design.Model.UserSS.User;

public class GoalSave {
    private User user;
    private boolean physicalFitness;
    private int targetCalories;
    private int dailyCalories;

    public GoalSave(User user, boolean physicalFitness, int targetCalories, int dailyCalories) {
        this.user = user;
        this.physicalFitness = physicalFitness;
        this.targetCalories = targetCalories;
        this.dailyCalories = dailyCalories;
    }

    public User getUser() {
        return user;
    }

    public boolean getPhysicalFitness() {
        return physicalFitness;
    }

    public int getTargetCalories() {
        return targetCalories;
    }

    public int getDailyCalories() {
        return dailyCalories;
    }
}
