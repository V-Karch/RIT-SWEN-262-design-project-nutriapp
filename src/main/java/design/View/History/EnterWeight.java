package design.View.History;

import design.Controller.History.HistoryController;
import design.View.Action;

public class EnterWeight implements Action {

    private HistoryController historyController;

    public EnterWeight(HistoryController historyController) {
        this.historyController = historyController;

    }

    @Override
    public void execute() {
       //unimplemented
    }
}
