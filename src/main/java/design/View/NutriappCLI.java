package design.View;

import java.util.Scanner;

import design.Controller.User.UserBuilder;
import design.View.User.AddBirthdate;
import design.View.User.AddHeight;
import design.View.User.AddName;
import design.View.User.AddWeight;

public class NutriappCLI {
    static Scanner input = new Scanner(System.in);
    
    public NutriappCLI(){}
    public static void main(String[] args) {

        //creating things
        UserBuilder userBuilder = new UserBuilder();
        AddName name = new AddName(userBuilder, input);
        AddHeight height = new AddHeight(userBuilder, input);
        AddWeight weight = new AddWeight(userBuilder, input);
        AddBirthdate birthdate = new AddBirthdate(userBuilder, input);
        

        //startup
        System.out.println("Hi, welcome to Nutriapp. Tell us a little more about yourself!");
        name.execute();
        height.execute();
        weight.execute();
        birthdate.execute();

        System.out.println("");


        input.close();
    }
}
