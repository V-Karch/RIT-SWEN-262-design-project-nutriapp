package design.View.Goal;

import design.Controller.Goal.GoalManager;
import design.View.Action;
import design.View.NALogger;

public class SetPhysicalFitness implements Action {
    private GoalManager goalManager;
    private NALogger logger;

    public SetPhysicalFitness(GoalManager goalManager, NALogger logger) {
        this.logger = logger;
    }

    @Override
    public void execute() {
        logger.print("Would you like to include physical fitness? (true or false)");
        logger.print("\n$ ");
        boolean validInput = false;
        while (!validInput) {
            try {
                String bool = logger.readString();
                //parseBoolean ALWAYS returns a boolean regardless of input, so checks for true or false before using it
                if (!bool.equalsIgnoreCase("true") && !bool.equalsIgnoreCase("false")){
                    throw new Exception();
                }
                validInput = true;
                boolean doesFitness = Boolean.parseBoolean(bool);
                System.out.println(doesFitness);
                this.goalManager.setPhysicalFitness(doesFitness); //issue is here, maybe goal manager doesn't exist?
                logger.print("Physical fitness updated.\n");
            } catch(Exception e) {
                logger.error("Invalid input, please enter true or false");
            }
        }
    }
}
