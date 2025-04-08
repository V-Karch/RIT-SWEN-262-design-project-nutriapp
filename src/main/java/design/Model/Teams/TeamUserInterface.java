package design.Model.Teams;

import java.util.List;
import java.util.Map;

import design.Model.Workout.Workout;

public interface TeamUserInterface {
    public void newWorkout(Workout workout);
    public void notifyOfWorkout(String username);
    public void joinTeam(TeamInterface team);
    public void recieveInvite(TeamUserInterface sender);
    public int getRank();
    public void setRank();
    public int getChallengeMinutes();
    public Map<String, Map<String, Workout>> seeWorkoutHistory();
    public Map<String, Workout> getWorkoutHistory();
    public String getUsername();
    public Team getTeam();
    public TeamUserInterface getInviter();
    public void acceptInvite();
    public void declineInvite();
    public void createChallenge();
    public boolean inChallenge();
    public List<String> readNotifications();
}
