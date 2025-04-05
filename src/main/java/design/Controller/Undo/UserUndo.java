package design.Controller.Undo;

import java.util.ArrayDeque;

import design.Controller.Goal.GoalManager;
import design.Model.Undo.UserSave;
import design.Model.Undo.UserSaveHistory;

public class UserUndo {
    private UserSaveHistory userHistory;

    public UserUndo(UserSaveHistory userHistory) {
        this.userHistory =  userHistory;
    }

    public void storeSave() {
        userHistory.storeUserSave();
    }

    public void restoreSave(GoalManager goalManager) {
        userHistory.restoreUserSave();
        goalManager.updateGoal();
    }

    public ArrayDeque<UserSave> getHistory() {
        return userHistory.getHistory();
    }

    public void purge(int number) {
        userHistory.purge(number);
    }
}
