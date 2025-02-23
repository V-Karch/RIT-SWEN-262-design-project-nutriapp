package design.View.User;

import java.util.Scanner;

import design.Controller.User.UserBuilder;
import design.View.Action;

public class AddName implements Action {
    private UserBuilder userBuilder;

    public AddName(UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name:");
        try {
            String name = input.nextLine();
            this.userBuilder.setName(name);
        } catch (Exception e) {
            System.out.println("Invalid name");
        }
        input.close();
    }

}
