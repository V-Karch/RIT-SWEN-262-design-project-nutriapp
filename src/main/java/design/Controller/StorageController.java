package design.Controller;

import design.Controller.History.HistoryController;
import design.Controller.User.UserBuilder;
import design.Model.UserSS.User;


public class StorageController {
    private Storage storage = Storage.getInstance();

    public StorageController() {}

    public void store(UserBuilder userBuilder, HistoryController historyController) {
        storage.addUser(userBuilder.getUser());
    }

    public Boolean checkUser(String name) {
        //true if user exists, false if user doesn't
        return storage.getUserByName(name) != null;
    }

    public User getUser(String name) {
        //true if user exists, false if user doesn't
        return storage.getUserByName(name);
    }

    public User getUserWithPassword(String name, String hash) {
        return storage.getUserByNameAndPassword(name, hash);
    }

    public void updateUser (String name){
        User user = this.getUser(name);
        storage.updateUser(user);
    }
}
