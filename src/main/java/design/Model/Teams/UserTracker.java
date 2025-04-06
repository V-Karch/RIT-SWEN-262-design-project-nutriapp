package design.Model.Teams;

import java.util.ArrayList;
import java.util.List;

import design.Storage;

public class UserTracker {
    private List<TeamUserInterface> allTeamUsers;
    private Storage storage;

    public UserTracker(){
        allTeamUsers = new ArrayList<TeamUserInterface>();
        storage = storage.getInstance();
    }

    public void inviteUser(TeamInterface team){
        
    }

    public List<String> getAllUsernames(){

    }

    public List<TeamUserInterface> getAllTeamUsers(){
        
    }
}
