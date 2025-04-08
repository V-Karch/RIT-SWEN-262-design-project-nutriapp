package design.Model.Undo;

import java.util.ArrayDeque;

import design.Model.History.DailyActivity;

public class DailyActivitySaveHistory {
    private ArrayDeque<DailyActivitySave> history;
    private DailyActivity dailyActivity;

    public DailyActivitySaveHistory(DailyActivity dailyActivity) {
        this.dailyActivity = dailyActivity;
        this.history = new ArrayDeque<DailyActivitySave>();
    }

    public void storeSave() {
        DailyActivitySave save = dailyActivity.createSave();
        history.add(save);
    }

    public void restoreSave() {
        DailyActivitySave save = history.remove();
        dailyActivity.restoreSave(save);
    }

    public ArrayDeque<DailyActivitySave> getHistory() {
        return history;
    }

    public void purge(int number) {
        for (int index = 0; index < number; index++) {
            history.removeFirst();
        }
    }
}
