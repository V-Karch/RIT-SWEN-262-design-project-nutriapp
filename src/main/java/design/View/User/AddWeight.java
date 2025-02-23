package design.View.User;

import java.util.Scanner;

import design.Controller.User.UserBuilder;
import design.View.Action;

public class AddWeight implements Action {
    private UserBuilder userBuilder;

    public AddWeight(UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your weight in lbs:");
        try {
            String weight = input.nextLine();
            float weightNum = Float.parseFloat(weight);
            this.userBuilder.setWeight(weightNum);
        } catch (Exception e) {
            System.out.println("Invalid weight");
        }
        input.close();


    }

}
