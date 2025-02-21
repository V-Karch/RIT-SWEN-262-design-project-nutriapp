package design.View.User;

import design.View.Action;
import design.Controller.User.UserBuilder;

public class AddWeight implements Action {
    private UserBuilder userBuilder;

    public AddWeight(UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    @Override
    public void execute() {
        this.userBuilder.setWeight();
    }

}
