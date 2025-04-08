package design.View.Teams;

import java.util.Scanner;

import design.Controller.Teams.TeamController;
import design.View.Action;

public class CreateChallenge implements Action{
    private TeamController teamController;
    private Scanner input;
    
    public CreateChallenge(TeamController teamController, Scanner input){
        this.teamController = teamController;
        this.input = input;
    }

    public void execute(){

        if(!teamController.challengeExists()){
            teamController.createChallenge();
            System.out.println("Challenge created!");
        }
        else{
            System.out.println("Challenge already active.");
        }
        

        ShowRankings showRankings = new ShowRankings(teamController);
        showRankings.execute();
    }
}
