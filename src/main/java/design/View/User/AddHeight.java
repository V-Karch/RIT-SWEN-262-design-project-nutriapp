package design.View.User;

import java.util.Scanner;

import design.Controller.User.UserBuilder;
import design.View.Action;

public class AddHeight implements Action {
    private UserBuilder userBuilder;
    private Scanner input;

    public AddHeight(UserBuilder userBuilder, Scanner scanner) {
        this.userBuilder = userBuilder;
        this.input = scanner;
    }

    @Override
    public void execute() {
        //Asks the user their height, parses the string as a float, and passes the information to the userbuilder
        System.out.print("Enter your height in inches: ");
        try {
            String height = input.nextLine();
            float heightNum = Float.parseFloat(height);
            this.userBuilder.setHeight(heightNum);
        } catch (Exception e) {
            System.out.println("Invalid height");
        }
    }

}
