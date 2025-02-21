package design.View.User;

import design.View.Action;
import design.Controller.User.UserBuilder;

public class AddHeight implements Action {
    private UserBuilder userBuilder;

    public AddHeight(UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    @Override
    public void execute() {
        this.userBuilder.setHeight();
    }

}
