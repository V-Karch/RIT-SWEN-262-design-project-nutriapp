package design.Controller.Undo;

import java.util.ArrayDeque;

import design.Model.Undo.DailyActivitySave;
import design.Model.Undo.DailyActivitySaveHistory;

public class DailyActivityUndo {
    private DailyActivitySaveHistory activiyHistory;

    public DailyActivityUndo(DailyActivitySaveHistory activiyHistory) {
        this.activiyHistory = activiyHistory;
    }

    public void storeSave() {
        activiyHistory.storeSave();
    }

    public void restoreSave() {
        activiyHistory.restoreSave();
    }

    public ArrayDeque<DailyActivitySave> getHistory() {
        return activiyHistory.getHistory();
    }

    public void purge(int number) {
        activiyHistory.purge(number);
    }
}
