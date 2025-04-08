package design.View.Teams;

import java.util.Scanner;

import design.Controller.Teams.TeamController;
import design.View.Action;

public class PrintInvites implements Action{

    private TeamController teamController;
    private Scanner input;
    
    public PrintInvites(TeamController teamController, Scanner input){
        this.teamController = teamController;
        this.input = input;
    }

    public void execute(){


        
        String choice = "";
        while(choice != "y" && choice != "n" && teamController.invitationsExist()){
            boolean teamExists = teamController.teamExists();
            String inviter = teamController.getInviter();
            System.out.print(inviter + " wants to invite you to their team. Accept invite?");
        
            //Warns user that they must leave current team to join new one.
            if(teamExists){
                System.out.print(" You will have to leave your current team.");
            }   
            System.out.println(" y/n");

            choice = input.nextLine();
            if(choice.equals("y")){
                teamController.acceptInvite();
                System.out.println("You have joined a new team!");
                break;
            }
            else if(choice.equals("n")){
                teamController.declineInvite();
                System.out.println("You have declined the invite.");
                break;
            }
            else{
                System.out.println("Invalid input.");
            }
        }
    }
}
