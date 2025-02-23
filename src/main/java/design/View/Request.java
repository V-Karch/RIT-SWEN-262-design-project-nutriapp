package design.View;

public class Request {
    private Action action;

    public Request(Action action) {
        this.action = action;
    }

    public void send() {
        action.execute();
    }
}
