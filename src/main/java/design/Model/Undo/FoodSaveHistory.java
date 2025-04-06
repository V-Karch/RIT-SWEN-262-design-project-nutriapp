package design.Model.Undo;

import java.util.ArrayDeque;

import design.Controller.Food.FoodManager;
import design.Controller.Goal.GoalManager;

public class FoodSaveHistory {
    private ArrayDeque<FoodSave> history;
    private FoodManager foodManager;

    public FoodSaveHistory(FoodManager foodManager) {
        this.foodManager = foodManager;
        this.history = new ArrayDeque<FoodSave>();
    }

    public void storeFoodSave() {
        FoodSave newSave = foodManager.createFoodSave();
        history.add(newSave);
    }

    public void restoreSave(GoalManager goalManager) {
        FoodSave save = history.remove();
        foodManager.restoreSave(save, goalManager);
    }

    public ArrayDeque<FoodSave> getHistory() {
        return history;
    }

    public void purge(int number) {
        for (int index = 0; index < number; index++) {
            history.removeFirst();
        }
    }
}
