package design.View;

import design.View.Action;

public class Request{
    private Action action;

    private void sent()
    {
        action.execute();
    }
}
