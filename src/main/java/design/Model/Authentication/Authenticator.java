package design.Model.Authentication;

public interface Authenticator {
    public String isAuthenticated();
    public String read();
    public String write();    
}
