package design.View.User;

import design.View.Action;
import design.Controller.User.UserBuilder;

public class AddBirthdate implements Action {
    private UserBuilder userBuilder;

    public AddBirthdate(UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    @Override
    public void execute() {
        this.userBuilder.setBirthdate();
    }

}
