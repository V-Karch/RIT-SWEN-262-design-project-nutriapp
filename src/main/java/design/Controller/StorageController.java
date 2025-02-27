package design.Controller;

import design.Storage;
import design.Controller.History.HistoryController;
import design.Controller.User.UserBuilder;
import design.Model.Goal.Goal;
import design.Model.History.HistoryManager;
import design.Model.UserSS.User;


public class StorageController {
    User user;
    Goal goal;
    HistoryManager historyManager;

    public StorageController(UserBuilder userBuilder, HistoryController historyController) {
        this.user = userBuilder.getUser();
        this.goal = user.currentGoal;
        this.historyManager = historyController.getHistoryManager();
    }

    public void store() {
        Storage.addUser(user);
    }
}
