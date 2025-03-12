package design.View.User;

import design.Controller.User.UserBuilder;
import design.View.Action;
import design.View.NALogger;

public class AddName implements Action {
    private UserBuilder userBuilder;
    private NALogger logger;

    public AddName(UserBuilder userBuilder, NALogger logger) {
        this.userBuilder = userBuilder;
        this.logger = logger;
    }

    @Override
    public void execute() {
        //Asks the user their name and passes the information to the userbuilder
        logger.print("Enter your name: ");
        try {
            String name = logger.readString();
            this.userBuilder.setName(name);
        } catch (Exception e) {
            logger.error("Invalid name");
        }
    }

}
