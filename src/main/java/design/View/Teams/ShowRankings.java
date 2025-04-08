package design.View.Teams;

import java.util.List;
import java.util.Scanner;

import design.Controller.Teams.TeamController;
import design.View.Action;

public class ShowRankings implements Action{
    private TeamController teamController;
    
    public ShowRankings(TeamController teamController){
        this.teamController = teamController;
    }

    public void execute(){

        if(teamController.challengeExists()){
            System.out.println("Current Rankings:");

            List<String> rankings = teamController.getRankings();
            
            for(int i = 0; i < rankings.size(); i++){
                System.out.println((i + 1) + ": " + rankings.get(i));
            }
        }
        else{
            System.out.println("No challenge currently active.");
        }


        
        
    }
}
