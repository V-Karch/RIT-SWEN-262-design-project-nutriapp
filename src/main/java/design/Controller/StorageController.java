package design.Controller;

import design.Controller.History.HistoryController;
import design.Controller.User.UserBuilder;
import design.Model.Goal.Goal;
import design.Model.History.HistoryManager;
import design.Model.UserSS.User;


public class StorageController {
    User user;
    Goal goal;
    HistoryManager historyManager;

    public StorageController() {
    }

    public void store(UserBuilder userBuilder, HistoryController historyController) {
        //do a thing!
    }

    public Boolean checkUser(String name) {
        //true if user exists, false if user doesn't
        return true;
    }

    public User getUser(String name) {
        //true if user exists, false if user doesn't
        return user;
    }
}
