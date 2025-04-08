package design.Model.Teams;

import java.util.ArrayList;
import java.util.List;

import design.Storage;

public class UserTracker {
    private List<TeamUserInterface> allTeamUsers;
    private Storage storage;

    public UserTracker(TeamUserInterface currentUser){
        allTeamUsers = new ArrayList<TeamUserInterface>();
        storage = storage.getInstance();
    }

    
    public boolean inviteUser(String reciever, TeamUserInterface inviter){

        for(TeamUserInterface t : allTeamUsers){
            if(reciever.equals(t.getUsername())){
                t.recieveInvite(inviter);
                return true;
            }
        }

        return false;
    }

    public List<String> getAllUsernames(){

    }

    public List<TeamUserInterface> getAllTeamUsers(){

    }
}
