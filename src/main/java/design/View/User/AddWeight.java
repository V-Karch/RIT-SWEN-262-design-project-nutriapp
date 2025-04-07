package design.View.User;

import design.Controller.History.HistoryController;
import design.Controller.User.UserBuilder;
import design.View.Action;
import design.View.NALogger;

public class AddWeight implements Action {
    private UserBuilder userBuilder;
    private NALogger logger;
    private HistoryController historyController;

    public AddWeight(UserBuilder userBuilder, NALogger logger, HistoryController historyController) {
        this.userBuilder = userBuilder;
        this.logger = logger;
        this.historyController = historyController;
    }

    @Override
    public void execute() {
        //Asks the user their weight, parses the string as a float, and passes the information to the userbuilder
        //while loop for input validation
        logger.print("Enter your weight in lbs: ");
        boolean validInput = false;
        while (!validInput) {
            try {
                float weightNum = logger.readFloat();
                if (weightNum <= 0){
                    throw new Exception();
                }
                validInput = true;
                this.userBuilder.setWeight(weightNum);
                // this.historyController.logWeight(weightNum);
            } catch (Exception e) {
                logger.error("Invalid weight. Please enter a number (lbs).");
            }
        }
    }
}
