package design.Model.Undo;

import java.util.ArrayDeque;

import design.Model.UserSS.User;

public class UserSaveHistory {
    private ArrayDeque<UserSave> history;
    private User user;

    public UserSaveHistory(User user) {
        this.user = user;
    }

    public void storeUserSave() {
        UserSave newSave = user.createUserSave();
        history.push(newSave);
    }

    public void restoreUserSave() {
        UserSave save = history.pop();
        user.restoreUserSave(save);
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
