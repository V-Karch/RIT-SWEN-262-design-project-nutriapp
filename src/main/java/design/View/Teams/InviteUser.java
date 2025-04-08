package design.View.Teams;

import java.util.Scanner;

import design.Controller.Teams.TeamController;
import design.View.Action;

public class InviteUser implements Action {
    private TeamController teamController;
    private Scanner input;
    
    public InviteUser(TeamController teamController, Scanner input){
        this.teamController = teamController;
        this.input = input;
    }

    public void execute(){
        System.out.println(teamController.getAllUsernames());
        System.out.println("Which user would you like to invite?");
        String choice = input.nextLine();


        if(!teamController.teamExists()){
            System.out.println("Your new team was created!");
        }

        if(teamController.inviteUser(choice)){
            System.out.println(choice + " was invited to your team!");
        }
        else{
            System.out.println(choice + " was not found.");
        }

    }
}
