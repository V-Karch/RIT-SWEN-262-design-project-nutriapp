package design.Model.Undo;

import java.util.ArrayDeque;

import design.Model.UserSS.User;

public class GoalSaveHistory {
    private ArrayDeque<GoalSave> history;
    private User user;

    public GoalSaveHistory(User user) {
        this.user = user;
        this.history = new ArrayDeque<GoalSave>();
    }

    public void storeSave() {
        GoalSave save = user.getGoal().createSave();
        history.add(save);
    }

    public void restoreSave() {
        GoalSave save = history.remove();
        user.getGoal().restoreSave(save);
    }

    public ArrayDeque<GoalSave> getHistory() {
        return history;
    }

    public void purge(int number) {
        for (int index = 0; index < number; index++) {
            history.removeFirst();
        }
    }
}
