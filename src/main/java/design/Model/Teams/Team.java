package design.Model.Teams;

import java.util.List;

import design.Model.Teams.TeamUser;
import design.Model.Teams.TeamUserInterface;

public class Team implements TeamInterface{
    private List<TeamUserInterface> userMap;
    private Challenge currentChallenge;

    public Team(){

    }

    public void addUser(TeamUserInterface teamUser){
        userMap.add(teamUser);
    }
}
