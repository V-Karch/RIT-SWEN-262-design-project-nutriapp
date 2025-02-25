package design.View.User;

import java.util.Scanner;

import design.Controller.User.UserBuilder;
import design.View.Action;

public class AddName implements Action {
    private UserBuilder userBuilder;
    private Scanner input;

    public AddName(UserBuilder userBuilder, Scanner scanner) {
        this.userBuilder = userBuilder;
        this.input = scanner;
    }

    @Override
    public void execute() {
        //Asks the user their name and passes the information to the userbuilder
        System.out.print("Enter your name: ");
        try {
            String name = input.nextLine();
            this.userBuilder.setName(name);
        } catch (Exception e) {
            System.out.println("Invalid name");
        }
    }

}
