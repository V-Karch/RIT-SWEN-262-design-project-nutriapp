package design.View.Undo;

import design.Controller.Goal.GoalManager;
import design.Controller.Undo.UserUndo;
import design.View.Action;
import design.View.NALogger;

public class UndoProfile implements Action{
    private UserUndo userUndo;
    private GoalManager goalManager;
    private NALogger logger;

    public UndoProfile(UserUndo userUndo, GoalManager goalManager, NALogger logger) {
        this.userUndo = userUndo;
        this.goalManager = goalManager;
        this.logger = logger;
    }

    @Override
    public void execute() {
        userUndo.restoreSave(goalManager); 
        logger.message("Action undone");       
    }
}
