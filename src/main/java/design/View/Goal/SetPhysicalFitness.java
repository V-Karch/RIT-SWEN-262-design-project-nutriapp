package design.View.Goal;

import java.util.Scanner;

import design.Controller.Goal.GoalManager;
import design.View.Action;

public class SetPhysicalFitness implements Action{
    private GoalManager goalManager;
    private Scanner scanner;

    public SetPhysicalFitness(GoalManager goalManager, Scanner scanner) {
        this.goalManager = goalManager;
        this.scanner = scanner;
      }

    @Override
    public void execute() {
        System.out.println("Would you like to improve physical fitness? (Y/N)");
        
        String response_Case = scanner.nextLine();
        String response = response_Case.toLowerCase();
        System.out.println(response);
        if (response.equals("y")){
            this.goalManager.setPhysicalFitness();
            System.out.println("Lets get physical!");
        } else {
            System.out.println("The gym is overrated tbh");
        }
    }
    
}
