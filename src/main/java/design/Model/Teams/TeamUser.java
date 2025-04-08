package design.Model.Teams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import design.Model.Workout.Workout;
import design.Model.Workout.WorkoutManager;

public class TeamUser implements TeamUserInterface{
    private WorkoutManager workoutManager;
    private UserTracker userTracker;
    private List<String> notifications;
    private List<TeamUserInterface> inviters;
    private TeamInterface team;
    private int challengeMinutes;
    private String username;

    public TeamUser(WorkoutManager workoutManager, String username){
        this.workoutManager = workoutManager;
        this.username = username;
        notifications = new ArrayList<String>();
        inviters = new ArrayList<TeamUserInterface>();
        challengeMinutes = 0;
    }

    @Override
    public void newWorkout(Workout workout){
        if(inChallenge()){
            challengeMinutes += workout.getMinutes();
        }

        team.newWorkout(this);
    }

    @Override
    public void notifyOfWorkout(String username){
        notifications.add(username);
    }

    @Override
    public List<String> readNotifications(){
        List<String> workouts = new ArrayList<String>(notifications);
        notifications.clear();
        return workouts;
    }

    @Override
    public void joinTeam(TeamInterface team){
        this.team = team;
        team.addUser(this);
    }

    private void leaveTeam(){
        team.removeUser(this);
        this.team = null;
    }

    @Override
    public void recieveInvite(TeamUserInterface sender){
        inviters.add(sender);
    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public Team getTeam(){
        return (Team)team;
    }

    @Override
    public TeamUserInterface getInviter(){
        return inviters.getFirst();
    }

    @Override
    public void acceptInvite(){
        if(team != null){
            leaveTeam();
        }
        joinTeam(inviters.getFirst().getTeam());

        inviters.removeFirst();
    }

    @Override
    public void declineInvite(){
        inviters.removeFirst();
    }

    @Override
    public void createChallenge(){
        Challenge challenge = new Challenge();
        team.setChallenge(challenge);
    }

    @Override
    public boolean inChallenge(){
        return team.inChallenge();
    }

    @Override 
    public Map<String, Map<String, Workout>> seeWorkoutHistory(){
        team.getWorkoutHistory()
    }

}