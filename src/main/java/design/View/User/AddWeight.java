package design.View.User;

import java.util.Scanner;

import design.Controller.User.UserBuilder;
import design.View.Action;

public class AddWeight implements Action {
    private UserBuilder userBuilder;
    private Scanner input;

    public AddWeight(UserBuilder userBuilder, Scanner scanner) {
        this.userBuilder = userBuilder;
        this.input = scanner;
    }

    @Override
    public void execute() {
        //Asks the user their weight, parses the string as a float, and passes the information to the userbuilder
        System.out.println("Enter your weight in lbs:");
        try {
            String weight = input.nextLine();
            float weightNum = Float.parseFloat(weight);
            this.userBuilder.setWeight(weightNum);
        } catch (Exception e) {
            System.out.println("Invalid weight");
        }
    }
}
