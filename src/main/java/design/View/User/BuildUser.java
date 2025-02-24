package design.View.User;

import design.Controller.User.UserBuilder;
import design.View.Action;

public class BuildUser implements Action {
    private UserBuilder userBuilder;

    public BuildUser(UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    @Override
    public void execute() {
        this.userBuilder.buildUser();
    }

}
