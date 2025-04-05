package design.Model.Authentication;

public interface Authenticator {
    public Boolean isAuthenticated();
    public String read();
    public String write();    
}
