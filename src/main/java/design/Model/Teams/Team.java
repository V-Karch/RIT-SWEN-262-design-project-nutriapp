package design.Model.Teams;

import java.util.ArrayList;
import java.util.List;

import design.Model.Teams.TeamUser;
import design.Model.Teams.TeamUserInterface;
import design.Model.Workout.Workout;

public class Team implements TeamInterface{
    private List<TeamUserInterface> userList;
    private Challenge currentChallenge;

    public Team(){
        userList = new ArrayList<TeamUserInterface>();
        
    }

    @Override
    public void newWorkout(TeamUserInterface teamUser){
        for(TeamUserInterface tui : userList){
            tui.notifyOfWorkout(teamUser.getUsername());
        }
    }

    @Override
    public void addUser(TeamUserInterface teamUser){
        userList.add(teamUser);
    }

    @Override
    public void removeUser(TeamUserInterface teamUser){
        for(TeamUserInterface tui : userList){
            if(teamUser == tui){
                userList.remove(tui);
            }
        }
    }

    @Override
    public void setChallenge(Challenge challenge){
        currentChallenge = challenge;
        challenge.updateRankings(userList);
    }

    @Override
    public void recalculateRanking(){
        if(currentChallenge != null){
            currentChallenge.updateRankings(userList);
        }
    }

    @Override
    public List<String> getRankings(){
        recalculateRanking();

        
        List<TeamUserInterface> rankings = currentChallenge.getRankings();

        List<String> rankingsStringList = new ArrayList<String>();

        for(TeamUserInterface tui : rankings){
            rankingsStringList.add(tui.getUsername());
        }

        return rankingsStringList;
    }

    @Override
    public boolean inChallenge(){
        return currentChallenge != null;
    }
}
