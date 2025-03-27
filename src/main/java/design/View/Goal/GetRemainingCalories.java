package design.View.Goal;

import design.Controller.Goal.GoalManager;
import design.View.Action;
import design.View.NALogger;

public class GetRemainingCalories implements Action {
    private GoalManager goalManager;
    private NALogger logger;

    public GetRemainingCalories(GoalManager goalManager, NALogger logger) {
        this.goalManager = goalManager;
        this.logger = logger;
    }

    @Override
    public void execute() {
        int remainingCalories = goalManager.getTargetCalories() - goalManager.getDailyCalories();
        if (remainingCalories >= 0) {
            logger.print("You have " + remainingCalories + " calories remaining today.\n");
        } else {
            logger.print("You are " + remainingCalories + " calories over your target!\n");
        }
    }
}
