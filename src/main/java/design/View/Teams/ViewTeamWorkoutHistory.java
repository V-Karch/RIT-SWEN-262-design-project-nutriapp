package design.View.Teams;

import java.util.Scanner;

import design.Controller.Teams.TeamController;

public class ViewTeamWorkoutHistory implements Action{
    private TeamController teamController;
    private Scanner input;
    
    public ViewTeamWorkoutHistory(TeamController teamController, Scanner input){
        this.teamController = teamController;
        this.input = input;
    }

    public void execute(){
        System.out.println("Here is the team's workout history.");
    }
}
