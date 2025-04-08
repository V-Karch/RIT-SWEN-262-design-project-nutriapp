package design.Model.Undo;

import java.util.ArrayDeque;

import design.Model.UserSS.User;

public class UserSaveHistory {
    private ArrayDeque<UserSave> history;
    private User user;

    public UserSaveHistory(User user) {
        this.user = user;
        this.history = new ArrayDeque<UserSave>();
    }

    public void storeSave() {
        UserSave newSave = user.createSave();
        history.add(newSave);
    }

    public void restoreSave() {
        UserSave save = history.remove();
        user.restoreSave(save);
    }

    public ArrayDeque<UserSave> getHistory() {
        return history;
    }

    public void purge(int number) {
        for (int index = 0; index < number; index++) {
            history.removeFirst();
        }
    }
}
