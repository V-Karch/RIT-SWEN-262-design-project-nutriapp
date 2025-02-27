package design.Controller;

import design.Controller.History.HistoryController;
import design.Controller.User.UserBuilder;
import design.Model.Goal.Goal;
import design.Model.History.HistoryManager;
import design.Model.UserSS.User;
import design.Storage;


public class StorageController {
    User user;
    Goal goal;
    HistoryManager historyManager;
    Storage storage;

    public StorageController() {
        Storage storage = new Storage();
    }

    public void store(UserBuilder userBuilder, HistoryController historyController) {
        //do a thing!
    }

    public Boolean checkUser(String name) {
        //true if user exists, false if user doesn't
        return this.storage.getUserByName(name) != null;
    }

    public User getUser(String name) {
        //true if user exists, false if user doesn't
        return this.storage.getUserByName(name);
    }
}
