package design.Model.Teams;

import java.util.List;

import design.Model.Workout.WorkoutManager;

public class TeamUser implements TeamUserInterface{
    private WorkoutManager workoutManager;
    private UserTracker userTracker;
    private List<String> notifications;
    private TeamInterface team;
    private int challengeMinutes;
    private boolean inChallenge;
    private String username;

    public TeamUser(WorkoutManager workoutManager, String username){
        this.workoutManager = workoutManager;
        this.username = username;
    }

    public void newWorkout(){
        
    }

    public void createTeam(){
        team = new Team();
        joinTeam(team);
    }

    public void joinTeam(TeamInterface team){
        this.team = team;
        team.addUser(this);
    }
}