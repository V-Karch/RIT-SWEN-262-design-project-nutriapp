package design.Controller;

import design.Controller.History.HistoryController;
import design.Controller.User.UserBuilder;
import design.Model.Goal.Goal;
import design.Model.History.HistoryManager;
import design.Model.History.Mediator;
import design.Model.UserSS.User;
import design.Storage;


public class StorageController {
    User user;
    Goal goal;
    HistoryManager historyManager;
    Mediator dailyA;

    public StorageController() {}

    public void store(UserBuilder userBuilder, HistoryController historyController, Mediator dailyA) {
        Storage.addUser(userBuilder.getUser());
        this.dailyA = dailyA;

    }

    public Boolean checkUser(String name, Mediator dailyA) {
        //true if user exists, false if user doesn't
        return Storage.getUserByName(name, dailyA) != null;
    }

    public User getUser(String name, Mediator dailyA) {
        //true if user exists, false if user doesn't
        return Storage.getUserByName(name, dailyA);
    }
}
