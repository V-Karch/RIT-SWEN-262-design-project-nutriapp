package design.View.User;

import design.Controller.User.UserBuilder;
import design.View.Action;
import design.View.NALogger;

public class AddBirthdate implements Action {
    private UserBuilder userBuilder;
    private NALogger logger;

    public AddBirthdate(UserBuilder userBuilder, NALogger logger) {
        this.userBuilder = userBuilder;
        this.logger = logger;
    }

    @Override
    public void execute() {
        //Asks the user their birthday in mm-dd-yyyy format and passes the information to the userbuilder
        //while loop for input validation
        
        logger.print("Enter your birthdate (mm-dd-yyyy): ");

        boolean validInput = false;
        while (!validInput) {
            try {
                String birthdate = logger.readBirthday();
                validInput = true;
                this.userBuilder.setBirthdate(birthdate);
            }
            catch(Exception e){
                logger.error("Invaid birthdate. Please use mm-dd-yyyy format.");
            }
        }
    }

}
