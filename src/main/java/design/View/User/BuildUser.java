package design.View.User;

import design.View.Action;
import design.Controller.User.UserBuilder;

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
