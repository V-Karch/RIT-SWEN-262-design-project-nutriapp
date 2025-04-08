package design.Controller.Teams;

import java.util.List;
import java.util.Map;

import design.Storage;
import design.Model.Teams.Team;
import design.Model.Teams.TeamInterface;
import design.Model.Teams.TeamUser;
import design.Model.Teams.TeamUserInterface;
import design.Model.Teams.UserTracker;
import design.Model.Workout.Workout;
import design.Model.Workout.WorkoutManager;

public class TeamController{
    private Storage storage;
    private UserTracker userTracker;
    private TeamUserInterface teamUser;

    public TeamController(UserTracker userTracker, TeamUserInterface teamUser){
        storage = storage.getInstance();
        this.userTracker = userTracker;
        this.teamUser = teamUser;
    }

    public String getAllUsernames(){
        List<String> allUsernames = storage.getUserNames();
        String usernamesString = "";
        for(int i = 0; i < allUsernames.size(); i++)
        {
            usernamesString += allUsernames.get(i);
            usernamesString += "\n";
        }

        return usernamesString;
    }

    public boolean inviteUser(String username){
        if(!teamExists()){
            Team newTeam = new Team();
            teamUser.joinTeam(newTeam);
        }
            return userTracker.inviteUser(username, teamUser);
    }

    public boolean teamExists(){
        return teamUser.getTeam() != null;
    }

    public String getInviter(){
        try{
            return teamUser.getInviter().getUsername();
        }
        catch(Exception e){
            return null;
        }
    }

    public boolean invitationsExist(){
        if(teamUser.getInviter() != null){
            return true;
        }
        else{
            return false;
        }
    }

    public void acceptInvite(){
        teamUser.acceptInvite();
    }

    public void declineInvite(){
        teamUser.declineInvite();
    }

    public void createChallenge(){
        teamUser.createChallenge();
    }

    public boolean challengeExists(){
        return teamUser.inChallenge();
    }

    public List<String> getRankings(){
        return teamUser.getTeam().getRankings();
    }

    public List<String> readNotifications(){
        return teamUser.readNotifications();
    }

    public Map<String, Map<String, Workout>> seeWorkoutHistory(){
        return teamUser.seeWorkoutHistory();
    }

}
