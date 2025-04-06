package design.Model.Teams;

import java.util.List;
import java.util.Map;

import design.Model.Teams.TeamUserInterface;
import design.Model.Workout.Workout;

public interface TeamInterface {
    public void newWorkout(TeamUserInterface teamUser, Workout workout);
    public Map<String, Map<String,Workout>> getWorkoutHistory(TeamUserInterface user);
    public List<TeamUserInterface> getAllUsers();
    public void setChallenge();
    public void recalculateRanking();
    public void addUser(TeamUserInterface teamUser);
}