package design.Model.Authentication;

import design.Storage;
import design.Model.UserSS.User;

public class Guest implements Authenticator{
    private Boolean authenticated;
    private String name;

    public Guest(){
        this.authenticated = false;
        this.name = "Guest";
    }

    @Override
    public Boolean isAuthenticated() {
        return this.authenticated;
    }
    public String getName(){
        return this.name;
    }
    public User register(String name, String birthdate, String password){
        User newUser = new User(name, 0, 0, birthdate, password);
        return newUser;
    }
    public User logIn(String name, String password){
        User currentUser = Storage.getUser(name, password);
        return currentUser;
    }
}
