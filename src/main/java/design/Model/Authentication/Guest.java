package design.Model.Authentication;

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
    
}
