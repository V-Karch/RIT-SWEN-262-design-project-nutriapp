package design.Controller;

import java.util.HashMap;

import design.Controller.History.HistoryController;
import design.Controller.User.UserBuilder;
import design.Model.Goal.Goal;
import design.Model.History.HistoryManager;
import design.Model.History.Mediator;
import design.Model.UserSS.User;
import design.Storage;


public class StorageController {

    private User user;
    private Goal goal;
    private HistoryManager historyManager;
    private Mediator dailyA;
    private Storage storage = Storage.getInstance();

    public StorageController() {}

    public void store(UserBuilder userBuilder, HistoryController historyController, Mediator dailyA) {
        storage.addUser(userBuilder.getUser(), dailyA);
        storage.updateDailyHistory(historyController.getHistoryManager(), userBuilder.getUser().getName());
        this.dailyA = dailyA;


    }

    public Boolean checkUser(String name, Mediator dailyA) {
        //true if user exists, false if user doesn't
        return storage.getUserByName(name, dailyA) != null;

    }

    public User getUser(String name, Mediator dailyA) {
        //true if user exists, false if user doesn't
        return storage.getUserByName(name, dailyA);
    }

    public User getUserWithPassword(String name, String hash, Mediator dailyA) {
        return storage.getUserByNameAndPassword(name, hash, dailyA);
    }

    public void updateUser (String name,  Mediator dailyA, HistoryManager historyManager){
        User user = this.getUser(name, dailyA);
        storage.updateUser(user, dailyA);
        storage.updateDailyHistory(historyManager, name);

    }

    public HashMap<String, String> getDailyHistory(String name){
        return storage.getDailyHistory(name);
    }
}
