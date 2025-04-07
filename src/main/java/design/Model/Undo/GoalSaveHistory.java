package design.Model.Undo;

import java.util.ArrayDeque;

import design.Model.Goal.Goal;

public class GoalSaveHistory {
    private ArrayDeque<GoalSave> history;
    private Goal goal;

    public GoalSaveHistory(Goal goal) {
        this.goal = goal;
        this.history = new ArrayDeque<GoalSave>();
    }

    public void storeGoalSave() {
        GoalSave save = goal.creatGoalSave();
        history.add(save);
    }

    public void restoreSave() {
        GoalSave save = history.remove();
        goal.restoreSave(save);
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
