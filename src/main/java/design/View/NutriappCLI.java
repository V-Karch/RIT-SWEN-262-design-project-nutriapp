package design.View;

import java.util.Scanner;

import design.Controller.User.UserBuilder;
import design.View.User.AddBirthdate;
import design.View.User.AddHeight;
import design.View.User.AddName;
import design.View.User.AddWeight;
import design.View.User.BuildUser;

public class NutriappCLI {
    static Scanner scanner = new Scanner(System.in);

    public NutriappCLI() {

    }

    public static void promptUser() {
        System.out.println("Type 'Stock' to add stock to an ingredient");
        System.out.println("Type 'Recipe' to create a recipe");
        System.out.println("Type 'Create Meal' to create a meal");
        System.out.println("Type 'Prepare Meal' to prepare a specific meal");
        System.out.println("Type 'Shopping List' to get a list of your commonly used ingredients");
        System.out.println("Type 'Workout' to log a completed workout");
        System.out.println("Type 'History' to view your history");
        System.out.println("Type 'Skip' to skip to the next day");
        System.out.println("Type 'Close' to exit the application");
        System.out.println("Type 'Help' to view all commands");
        System.out.print("$ ");

    }

    public static boolean parseInput(String input) {
        String request = input.toLowerCase();
        if (request.equals("stock")) {
            // call stock ingredient concrete command
        }
        if (request.equals("recipe")) {
            // call create recipe concrete command
        }
        if (request.equals("create meal")) {
            // call create meal concrete command

        }
        if (request.equals("prepare meal")) {
            // call prepare meal concrete command
            // offer user a list of meals to prepare
        }
        if (request.equals("shopping list")) {
            // call recommended shopping list concrete command
        }
        if (request.equals("workout")) {
            // call log workout concrete command
        }
        if (request.equals("history")) {
            // offer different types of history that the user can peruse
            // call the concrete command for the specific type
        }
        if (request.equals("help")) {
            System.out.println("");
            promptUser();
            input = scanner.nextLine();
            parseInput(input);
        }
        if (input.equals("close")) {
            return true;
        }
        if (input.equals("skip")) {
            // skip to next day
            return false;
        }
        // nextAction();
        // ideally this shouldn't be reached
        return true;
    }

    public static void nextAction() {
        System.out.println("What would you like to do next?");
        String input = scanner.nextLine();
        parseInput(input);
    }

    public static void main(String[] args) {

        // creating things
        UserBuilder userBuilder = new UserBuilder();
        AddName name = new AddName(userBuilder, scanner);
        AddHeight height = new AddHeight(userBuilder, scanner);
        AddWeight weight = new AddWeight(userBuilder, scanner);
        AddBirthdate birthdate = new AddBirthdate(userBuilder, scanner);
        BuildUser buildUser = new BuildUser(userBuilder);

        // startup
        System.out.println("\nWelcome to Nutriapp. Tell us a little more about yourself!");
        name.execute();
        height.execute();
        weight.execute();
        birthdate.execute();
        try {
            buildUser.execute();
        } catch (Error e) {
            System.out.println("goal hasn't been implemented yet");
        }

        System.out.println("\nHi " + userBuilder.getName() + "!");
        System.out.println("Tell us more about your fitness goals!");
        // set goal
        // determine physical fitness
        while (true) {
            System.out.println("\nWhat would you like to do today?");
            System.out.println("Type 'Help' to view possible commands");
            System.out.print("$ ");

            String input = scanner.nextLine();
            input = input.toLowerCase();
            if (input.equals("close")) {
                System.out.println("Bye!");
                break;
            } else {
                // enables the user to do multiple things within a 24 hr period
                boolean response = parseInput(input);

                if (response == true) {
                    System.out.println("");
                    System.out.println("Sad to see you go!");
                    break;
                }

                System.out.println("");
                System.out.println("***A day has passed***");
                System.out.println("Good Morning!");
                weight.execute();
                System.out.println("");
            }
        }
        scanner.close();
    }
}