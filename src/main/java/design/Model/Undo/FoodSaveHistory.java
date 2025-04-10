package design.Model.Undo;

import java.util.ArrayDeque;

import design.Controller.Food.FoodManager;

public class FoodSaveHistory {
    private ArrayDeque<FoodSave> history;
    private FoodManager foodManager;

    public FoodSaveHistory(FoodManager foodManager) {
        this.foodManager = foodManager;
        this.history = new ArrayDeque<FoodSave>();
    }

    public void storeSave() {
        FoodSave newSave = foodManager.createSave();
        history.add(newSave);
    }

    public void restoreSave() {
        FoodSave save = history.remove();
        foodManager.restoreSave(save);
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
