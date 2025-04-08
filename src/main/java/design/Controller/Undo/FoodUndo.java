package design.Controller.Undo;

import java.util.ArrayDeque;

import design.Model.Undo.FoodSave;
import design.Model.Undo.FoodSaveHistory;

public class FoodUndo {
     private FoodSaveHistory foodHistory;

    public FoodUndo(FoodSaveHistory foodHistory) {
        this.foodHistory = foodHistory;
    }

    public void storeSave() {
        foodHistory.storeSave();
    }

    public void restoreSave() {
        foodHistory.restoreSave();
    }

    public ArrayDeque<FoodSave> getHistory() {
        return foodHistory.getHistory();
    }

    public void purge(int number) {
        foodHistory.purge(number);
    }
}
