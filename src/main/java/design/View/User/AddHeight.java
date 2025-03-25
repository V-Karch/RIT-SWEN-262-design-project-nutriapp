package design.View.User;

import design.Controller.User.UserBuilder;
import design.View.Action;
import design.View.NALogger;

public class AddHeight implements Action {
    private UserBuilder userBuilder;
    private NALogger logger;

    public AddHeight(UserBuilder userBuilder, NALogger logger) {
        this.userBuilder = userBuilder;
        this.logger = logger;
    }

    @Override
    public void execute() {
        //Asks the user their height, parses the string as a float, and passes the information to the userbuilder
        //while loop for input validation
        logger.print("Enter your height in inches: ");

        boolean validInput = false;
        while (!validInput) {
            
            try {
                float heightNum = logger.readFloat();
                if (heightNum <= 0){
                    throw new Exception();
                }
                validInput = true;
                this.userBuilder.setHeight(heightNum);
            } catch (Exception e) {
                logger.error("Invalid height. Please enter a number (in).");
            }
        }
    }

}
