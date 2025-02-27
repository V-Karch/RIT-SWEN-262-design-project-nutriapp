package design.View.User;

import java.util.Scanner;

import design.Controller.History.HistoryController;
import design.Controller.User.UserBuilder;
import design.View.Action;

public class AddWeight implements Action {
    private UserBuilder userBuilder;
    private Scanner input;
    private HistoryController historyController;

    public AddWeight(UserBuilder userBuilder, Scanner scanner, HistoryController historyController) {
        this.userBuilder = userBuilder;
        this.input = scanner;
        this.historyController = historyController;
    }

    @Override
    public void execute() {
        //Asks the user their weight, parses the string as a float, and passes the information to the userbuilder
        System.out.print("Enter your weight in lbs: ");
        try {
            String weight = input.nextLine();
            float weightNum = Float.parseFloat(weight);
            this.userBuilder.setWeight(weightNum);
            //log weight in history
            this.historyController.logWeight(((int)(weightNum))); // cast float to int

        } catch (Exception e) {
            System.out.println("Invalid weight");
        }
    }
}
