package design.View.User;

import design.View.Action;
import design.Controller.User.UserBuilder;

public class AddName implements Action {
    private UserBuilder userBuilder;

    public AddName(UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    @Override
    public void execute() {
        this.userBuilder.setName();
    }

}
