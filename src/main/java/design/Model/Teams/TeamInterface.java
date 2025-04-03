package design.Model.Teams;

import design.Controller.Teams.TeamControllerInterface;
import design.Model.Workout.Workout;

public interface TeamInterface {
    public void newWorkout(TeamControllerInterface teamController, Workout workout);
}
