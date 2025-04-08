package design.Controller.Undo;

import java.util.ArrayDeque;

import design.Model.Undo.GoalSave;
import design.Model.Undo.GoalSaveHistory;

public class GoalUndo {
    private GoalSaveHistory goalHistory;

    public GoalUndo(GoalSaveHistory goalHistory) {
        this.goalHistory = goalHistory;
    }

    public void storeSave() {
        goalHistory.storeSave();
    }

    public void restoreSave() {
        goalHistory.restoreSave();
    }

    public ArrayDeque<GoalSave> getHistory() {
        return goalHistory.getHistory();
    }

    public void purge(int number) {
        goalHistory.purge(number);
    }
}
