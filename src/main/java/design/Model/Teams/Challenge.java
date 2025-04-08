package design.Model.Teams;

import java.util.ArrayList;
import java.util.List;

public class Challenge {
    private String name;
    private List<TeamUserInterface> rankings;

    public Challenge(){
        rankings = new ArrayList<TeamUserInterface>();
    }

    public void updateRankings(List<TeamUserInterface> competitors){
        List<TeamUserInterface> competitorsCopy = new ArrayList<>(competitors);
        
        for(int i = 0; i < competitors.size(); i++){
            TeamUserInterface mostWorkoutMinutes = competitorsCopy.get(0);
            for(int j = 1; j < competitorsCopy.size(); j++){
                if(mostWorkoutMinutes.getChallengeMinutes() < competitorsCopy.get(j).getChallengeMinutes()){
                    mostWorkoutMinutes = competitorsCopy.get(j);
                }
            }
            rankings.add(mostWorkoutMinutes);
            competitorsCopy.remove(mostWorkoutMinutes);
        }

        rankings = competitorsCopy;
    }

    public List<TeamUserInterface> getRankings(){
        updateRankings();
        return rankings;
    }
}
