package design.View;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.Controller.Goal.GoalManager;
import design.Controller.History.HistoryController;
import design.Storage;
import design.Controller.StorageController;
import design.Controller.User.UserBuilder;
import design.Controller.Workout.WorkoutController;
import design.Model.History.HistoryManager;
import design.Model.Workout.WorkoutBuilder;
import design.Model.Workout.WorkoutManager;
import design.View.Food.AddIngredient;
import design.View.Food.AddRecipe;
import design.View.Food.CreateMeal;
import design.View.Food.CreateRecipe;
import design.View.Food.CreateShoppingList;
import design.View.Food.PrepareMeal;
import design.View.Food.StockIngredient;
import design.View.Food.ViewShoppingList;
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
    static StorageController storageController = new StorageController();

    FoodManager foodManager;
    GoalManager goalManager;

    public NutriappCLI() throws IOException {
        this.foodManager = new
        FoodManager("src/main/java/design/ingredients.csv");

        userBuilder = new UserBuilder();
    }

    public static void main(String[] args) throws IOException, Exception {
        NutriappCLI nutriapp = new NutriappCLI();
        nutriapp.run(args);
    }

    public void promptUser() {
        System.out.println("Type 'Stock' to add stock to an ingredient");
        System.out.println("Type 'Recipe' to create a recipe");
        System.out.println("Type 'Create Meal' to create a meal");
        System.out.println("Type 'Add Recipe' to add a recipe to a meal");
        System.out.println("Type 'Add Ingredient' to add an ingredient to a recipe");
        System.out.println("Type 'Prepare Meal' to prepare a specific meal");
        System.out.println("Type 'Shopping List' to create a new shopping list");
        System.out.println("Type 'View Shopping List' to get a list of your commonly used ingredients");
        System.out.println("Type 'Workout' to log a completed workout");
        System.out.println("Type 'History' to view your history");
        System.out.println("Type 'Get Target Calories' to see your remaining allotted calories for the day");
        System.out.println("Type 'Set Target Weight' to change your target weight");
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
            CreateMeal createMeal = new CreateMeal(foodManager, "", scanner);
            createMeal.execute();
        }
        if (request.equals("add recipe")){
            AddRecipe addRecipe = new AddRecipe(foodManager, scanner);
            addRecipe.execute();
        }
        if (request.equals("add ingredient")){
            AddIngredient addIngredient = new AddIngredient(foodManager, scanner);
        }
        if (request.equals("prepare meal")) {
            PrepareMeal prepareMeal = new PrepareMeal(foodManager, userBuilder.getUser().getGoal(), scanner, historyController);
            prepareMeal.execute();
        }
        if (request.equals("shopping list")) {
            CreateShoppingList createShoppingList = new CreateShoppingList(foodManager, scanner);
            createShoppingList.execute();
        }
        if(request.equals("view shopping list")){
            ViewShoppingList viewShoppingList = new ViewShoppingList(foodManager, scanner);
            viewShoppingList.execute();
        }
        if (request.equals("set workout name")) {
            SetName setName = new SetName(workoutController, scanner);
            setName.execute();
        }
        if (request.equals("set workout intensity")) {
            SetIntensity setIntensity = new SetIntensity(workoutController, scanner);
            setIntensity.execute();
        }
        if (request.equals("set workout minutes")) {
            SetMinutes setMinutes = new SetMinutes(workoutController, scanner);
            setMinutes.execute();
        }
        if (request.equals("create workout")) {
            CreateWorkout createWorkout = new CreateWorkout(workoutController, historyController);
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
            storageController.store(userBuilder, historyController);
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

    public void checkUser(){
        
    }

    public void run(String[] args) throws IOException, Exception {
        if (!(new File("application.db").isFile())) { // Check if database file exists
            Storage.createNewDatabase("application.db"); // make database file
            Storage.setupTables(); // setup database tables
        }

        // creating things
        AddName name = new AddName(userBuilder, scanner);
        AddHeight height = new AddHeight(userBuilder, scanner);
        AddWeight weight = new AddWeight(userBuilder, scanner, historyController);
        AddBirthdate birthdate = new AddBirthdate(userBuilder, scanner);
        BuildUser buildUser = new BuildUser(userBuilder);

        // startup
        System.out.println("\nWelcome to Nutriapp. Tell us a little more about yourself!");
        name.execute();
        //check to see if the user exists
        Boolean exists = storageController.checkUser(userBuilder.getName());
        if (exists == true){
            userBuilder.setUser(storageController.getUser(userBuilder.getName()));
            //sets user through userbuilder which is the primary way the program accesses user?
            this.goalManager = new GoalManager(userBuilder.getUser());
            //creates the goal manager based of the existing user profile, accesses goal through user
            //goal itself should have target weight and physical fitness boolean
            //which should address the startup concerns and any functionality should be fine going forward if i understand this right

        } else {
            height.execute();
            weight.execute();
            birthdate.execute();
            buildUser.execute();

            // now that user has been created, goal subsystem can be created bc user is a
            // dependency
            this.goalManager = new GoalManager(userBuilder.getUser());
            SetTargetWeight setTargetWeight = new SetTargetWeight(goalManager, scanner);
            SetPhysicalFitness setPhysicalFitness = new SetPhysicalFitness(goalManager, scanner);

            System.out.println("\nHi " + userBuilder.getName() + "!");
            System.out.println("Tell us more about your fitness goals!");
            setTargetWeight.execute();
            setPhysicalFitness.execute();
        }
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