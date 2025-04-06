package design.Controller.Teams;

import java.util.List;

import design.Storage;
import design.Model.Teams.Team;
import design.Model.Teams.TeamInterface;
import design.Model.Teams.UserTracker;
import design.Model.Workout.WorkoutManager;

public class TeamController{
    private Storage storage;
    private UserTracker userTracker;

    public TeamController(UserTracker userTracker){
        storage = storage.getInstance();
        this.userTracker = userTracker;
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
        userTracker.inviteUser(username);
    }
}
