package design.View.Undo;

import design.Controller.Undo.DailyActivityUndo;
import design.Controller.Undo.FoodUndo;
import design.Controller.Undo.GoalUndo;
import design.View.Action;
import design.View.NALogger;

public class UndoFood implements Action {
    private FoodUndo foodUndo;
    private GoalUndo goalUndo;
    private DailyActivityUndo dailyActivityUndo;
    private NALogger logger;

    public UndoFood(FoodUndo foodUndo, GoalUndo goalUndo, DailyActivityUndo dailyActivityUndo, NALogger logger) {
        this.foodUndo = foodUndo;
        this.goalUndo = goalUndo;
        this.dailyActivityUndo = dailyActivityUndo;
        this.logger = logger;
    }

    @Override
    public void execute() {
        foodUndo.restoreSave();
        goalUndo.restoreSave();
        dailyActivityUndo.restoreSave();
        logger.message("Action undone");   
    }
}
