package design.View;

import java.io.IOException;
import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.Controller.Goal.GoalManager;
import design.Controller.History.HistoryController;
import design.Controller.StorageController;
import design.Controller.User.UserBuilder;
import design.Controller.Workout.WorkoutController;
import design.Model.History.HistoryManager;
import design.Model.Workout.WorkoutBuilder;
import design.Model.Workout.WorkoutManager;
import design.View.Food.CreateRecipe;
import design.View.Food.StockIngredient;
import design.View.Goal.SetPhysicalFitness;
import design.View.Goal.SetTargetWeight;
import design.View.History.LogTodaysActivity;
import design.View.History.SearchHistory;
import design.View.User.AddBirthdate;
import design.View.User.AddHeight;
import design.View.User.AddName;
import design.View.User.AddWeight;
import design.View.User.BuildUser;
import design.View.Workout.CreateWorkout;
import design.View.Workout.SetIntensity;
import design.View.Workout.SetMinutes;
import design.View.Workout.SetName;

public class NutriappCLI {
    static Scanner scanner = new Scanner(System.in);
    static HistoryController historyController = new HistoryController(new HistoryManager());
    static WorkoutController workoutController = new WorkoutController(new WorkoutBuilder(), new WorkoutManager());
    static SearchHistory searchHistory = new SearchHistory(scanner, historyController);
    static LogTodaysActivity logTodaysActivity = new LogTodaysActivity(historyController);
    static SetName setName = new SetName(workoutController, scanner);
    static SetIntensity setIntensity = new SetIntensity(workoutController, scanner);
    static SetMinutes setMinutes = new SetMinutes(workoutController, scanner);
    static CreateWorkout createWorkout = new CreateWorkout(workoutController, historyController);
    static UserBuilder userBuilder = new UserBuilder();

    FoodManager foodManager;

    public NutriappCLI() throws IOException {
        // this.foodManager = new
        // FoodManager("src\\main\\java\\design\\ingredients.csv");
        // this thing is breaking everything so I'm commenting it out for now -CJ
    }

    public static void main(String[] args) throws IOException, Exception {
        NutriappCLI nutriapp = new NutriappCLI();
        nutriapp.run(args);
    }

    public void promptUser() {
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

    public boolean parseInput(String input) throws Exception {
        boolean state = true;
        String request = input.toLowerCase();
        System.out.println();
        if (request.equals("stock")) {
            StockIngredient stockIngredient = new StockIngredient(this.foodManager, scanner);
            stockIngredient.execute();
        }
        if (request.equals("recipe")) {
            CreateRecipe createRecipe = new CreateRecipe(this.foodManager, scanner);
            createRecipe.execute();

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
            setName.execute();
            setIntensity.execute();
            setMinutes.execute();
            createWorkout.execute();

        }
        if (request.equals("history")) {
            // prompt user for a specific date and display history for that date-time
            // (yyyy-mm-dd HH:mm)
            searchHistory.execute();
        }
        // Goal requests
        if (request.equals("set target weight")) {
            // call set target weight
        }

        if (request.equals("get target calories")) {
            // call get target calories
        }

        if (request.equals("help")) {
            System.out.println("");
            promptUser();
            input = scanner.nextLine();
            boolean response =parseInput(input);
            state = response;
            return state;
        }
        if (request.equals("close")) {
            StorageController storageController = new StorageController(userBuilder, historyController);
            storageController.store();
            System.out.println("User profile stored!");
            state = true;
        }
        if (request.equals("skip")) {
            // skip to next day
            state = false;
        }
        return state;
    }

    public void nextAction() throws Exception {
        System.out.println("What would you like to do next?");
        String input = scanner.nextLine();
        parseInput(input);
    }

    public void run(String[] args) throws IOException, Exception {

        // creating things
        AddName name = new AddName(userBuilder, scanner);
        AddHeight height = new AddHeight(userBuilder, scanner);
        AddWeight weight = new AddWeight(userBuilder, scanner, historyController);
        AddBirthdate birthdate = new AddBirthdate(userBuilder, scanner);
        BuildUser buildUser = new BuildUser(userBuilder);

        // startup
        System.out.println("\nWelcome to Nutriapp. Tell us a little more about yourself!");
        name.execute();
        height.execute();
        weight.execute();
        birthdate.execute();
        buildUser.execute();

        // now that user has been created, goal subsystem can be created bc user is a
        // dependency
        GoalManager goalManager = new GoalManager(userBuilder.getUser());
        SetTargetWeight setTargetWeight = new SetTargetWeight(goalManager, scanner);
        SetPhysicalFitness setPhysicalFitness = new SetPhysicalFitness(goalManager, scanner);

        System.out.println("\nHi " + userBuilder.getName() + "!");
        System.out.println("Tell us more about your fitness goals!");
        setTargetWeight.execute();
        setPhysicalFitness.execute();

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
                boolean response;
                response = parseInput(input);
                if (response == true) {
                    System.out.println("");
                    System.out.println("Sad to see you go!");
                    break;
                }
                System.out.println("");

                logTodaysActivity.execute();

                System.out.println("***A day has passed***");
                System.out.println("Good Morning!");
                weight.execute();
                System.out.println("");
                
            }
        }
        scanner.close();
    }
}