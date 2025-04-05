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
        return authenticated;
    }

    @Override
    public String read() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public String write() {
        return "Guests are not authorized to do this!";
    }
    
}
