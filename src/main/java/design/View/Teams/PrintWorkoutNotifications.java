package design.View.Teams;

import java.util.List;
import java.util.Scanner;

import design.Controller.Teams.TeamController;

public class PrintWorkoutNotifications implements Action{
    private TeamController teamController;
    private Scanner input;
    
    public PrintWorkoutNotifications(TeamController teamController, Scanner input){
        this.teamController = teamController;
        this.input = input;
    }

    public void execute(){
        System.out.println("Here are your Team notifications:");
        List<String> usersWhoWorkedOut = teamController.readNotifications();

        for(String s : usersWhoWorkedOut){
            System.out.println(s + " logged a workout.");
        }
    }
}
