package design.View.User;

import java.util.Scanner;

import design.Controller.User.UserBuilder;
import design.View.Action;

public class AddBirthdate implements Action {
    private UserBuilder userBuilder;
    private Scanner input;

    public AddBirthdate(UserBuilder userBuilder, Scanner scanner) {
        this.userBuilder = userBuilder;
        this.input = scanner;
    }

    @Override
    public void execute() {
        //Asks the user their birthday in mm-dd-yyyy format, parses the string as an int array, and passes the information to the userbuilder
        
        System.out.print("Enter your birthdate (mm-dd-yyyy): ");
        try {
            String birthdate = input.nextLine();
            this.userBuilder.setBirthdate(birthdate);
        }
        catch(Exception e)
        {
            System.out.println("Invaid birthdate");
        }
    }

}
