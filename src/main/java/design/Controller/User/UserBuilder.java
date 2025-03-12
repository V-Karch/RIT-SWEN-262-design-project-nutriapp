package design.Controller.User;

import design.Model.UserSS.User;


public class UserBuilder {
    private String name;
    private float height;
    private float weight;
    private String birthdate;
    private User user;
    

    public UserBuilder() {
    }
    
    //most functions are self explanatory

    public String getName(){
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(float height) {
        this.height  = height;
    }

    public void setWeight(float weight) {
        this.weight  = weight;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate  = birthdate;
    }

    public User buildUser() {
        this.user = new User(name, height, weight, birthdate);
        return this.user;
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }
    
}
