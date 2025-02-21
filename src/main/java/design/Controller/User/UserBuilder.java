package design.Controller;

import design.Model.User;


public class UserBuilder {
    private String name;
    private float height;
    private float weight;
    private int[] birthdate;
    

    public UserBuilder() {
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

    public void setBirthdate(int[] birthdate) {
        this.birthdate  = birthdate;
    }

    public Workout buildUser() {
        return new User(name, height, weight, birthdate);
    }
}
