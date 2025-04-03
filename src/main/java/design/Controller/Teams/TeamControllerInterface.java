package design.Controller.Teams;

import java.util.Map;

import design.Model.Teams.TeamInterface;
import design.Model.Workout.Workout;

public interface TeamControllerInterface {
    public void newWorkout(Workout workout);
    public void notifyOfWorkout(String username);
    public void createTeam();
    public void joinTeam();
    public void recieveInvite(TeamInterface team);
    public int getRank();
    public void setRank();
    public int getChallengeMinutes();
    public void seeWorkoutHistory();
    public Map<String, Workout> getWorkoutHistory();
}
