package design.View;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import design.Controller.DayScheduler;
import design.Controller.Food.FoodManager;
import design.Controller.Goal.GoalManager;
import design.Controller.History.HistoryController;
import design.Controller.StorageController;
import design.Controller.User.UserBuilder;
import design.Controller.Workout.WorkoutController;
import design.Model.CurrentDay;
import design.Model.History.DailyActivity;
import design.Model.History.HistoryManager;
import design.Model.Workout.WorkoutBuilder;
import design.Model.Workout.WorkoutManager;
import design.Storage;
import design.View.Food.AddIngredient;
import design.View.Food.AddRecipe;
import design.View.Food.CreateMeal;
import design.View.Food.CreateRecipe;
import design.View.Food.CreateShoppingList;
import design.View.Food.PrepareMeal;
import design.View.Food.SearchIngredient;
import design.View.Food.StockIngredient;
import design.View.Food.ViewShoppingList;
import design.View.Goal.GetRemainingCalories;
import design.View.Goal.GetTargetCalories;
import design.View.Goal.SetPhysicalFitness;
import design.View.Goal.SetTargetWeight;
import design.View.Goal.UpdateWeight;
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
    NALogger logger = new NALogger(scanner);
    static CurrentDay currentDay = new CurrentDay();

    // controllers
    static DailyActivity dailyActivity = new DailyActivity();
    static HistoryController historyController = new HistoryController(new HistoryManager(dailyActivity));
    static WorkoutController workoutController = new WorkoutController(new WorkoutBuilder(currentDay, dailyActivity),
            new WorkoutManager(dailyActivity));

    // history commands
    static SearchHistory searchHistory = new SearchHistory(scanner, historyController);
    static LogTodaysActivity logTodaysActivity = new LogTodaysActivity(historyController, currentDay);

    // workout commands
    static SetName setName = new SetName(workoutController, scanner);
    static SetIntensity setIntensity = new SetIntensity(workoutController, scanner);
    static SetMinutes setMinutes = new SetMinutes(workoutController, scanner);
    static CreateWorkout createWorkout = new CreateWorkout(workoutController, historyController);

    static UserBuilder userBuilder = new UserBuilder(dailyActivity);
    static StorageController storageController = new StorageController();
    Boolean existingUser;

    FoodManager foodManager;
    GoalManager goalManager;

    public NutriappCLI() throws IOException {
        this.foodManager = new FoodManager("src/main/java/design/ingredients.csv");
        userBuilder = new UserBuilder(dailyActivity);
    }

    public static void main(String[] args) throws IOException, Exception {
        // runs the application
        NutriappCLI nutriapp = new NutriappCLI();
        nutriapp.run(args);
    }

    public void promptUser() {
        // prints all possible commands to terminal
        logger.message("Type 'Stock' to add stock to an ingredient");
        logger.message("Type 'Search' to search for an ingredient");
        logger.message("Type 'Recipe' to create a recipe");
        logger.message("Type 'Create Meal' to create a meal");
        logger.message("Type 'Add Recipe' to add a recipe to a meal");
        logger.message("Type 'Add Ingredient' to add an ingredient to a recipe");
        logger.message("Type 'Prepare Meal' to prepare a specific meal");
        logger.message("Type 'Shopping List' to create a new shopping list");
        logger.message("Type 'View Shopping List' to get a list of your commonly used ingredients");
        logger.message("Type 'Workout' to log a completed workout");
        logger.message("Type 'History' to view your history");
        logger.message("Type 'Get Target Calories' to see your calorie goal for the day");
        logger.message("Type 'Get Remaining Calories' to see your remaining allotted calories for the day");
        logger.message("Type 'Set Target Weight' to change your target weight");
        logger.message("Type 'Close' to exit the application");
        logger.message("Type 'Help' to view all commands");
        logger.gap();
        logger.query();
    }

    public boolean parseInput(String input, DayScheduler dayScheduler) throws Exception {
        // reads user input and calls the correct concrete command, then calls
        // nextAction() (unless skip or close)
        boolean state = false;
        String request = input.toLowerCase();
        System.out.println("INPUT: " + request);
        logger.gap();
        switch (request) {
            case "search":
                SearchIngredient searchIngredient = new SearchIngredient(this.foodManager, scanner);
                searchIngredient.execute();
                state = nextAction(dayScheduler);
                break;
            case "stock":
                StockIngredient stockIngredient = new StockIngredient(this.foodManager, scanner);
                stockIngredient.execute();
                state = nextAction(dayScheduler);
                break;
            case "recipe":
                CreateRecipe createRecipe = new CreateRecipe(this.foodManager, scanner);
                createRecipe.execute();
                state = nextAction(dayScheduler);
                break;
            case "create meal":
                CreateMeal createMeal = new CreateMeal(foodManager, "", scanner);
                createMeal.execute();
                state = nextAction(dayScheduler);
                break;
            case "add recipe":
                AddRecipe addRecipe = new AddRecipe(foodManager, scanner);
                addRecipe.execute();
                state = nextAction(dayScheduler);
                break;
            case "add ingredient":
                AddIngredient addIngredient = new AddIngredient(foodManager, scanner);
                addIngredient.execute();
                state = nextAction(dayScheduler);
                break;
            case "prepare meal":
                PrepareMeal prepareMeal = new PrepareMeal(foodManager, userBuilder.getUser().getGoal(), scanner,
                        historyController, dailyActivity);
                prepareMeal.execute();
                state = nextAction(dayScheduler);
                break;
            case "shopping list":
                CreateShoppingList createShoppingList = new CreateShoppingList(foodManager, scanner);
                createShoppingList.execute();
                state = nextAction(dayScheduler);
                break;
            case "view shopping list":
                ViewShoppingList viewShoppingList = new ViewShoppingList(foodManager, scanner);
                viewShoppingList.execute();
                state = nextAction(dayScheduler);
                break;
            case "workout":
                setName.execute();// asks for a workout name,
                setIntensity.execute();// asks for a workout intensity,
                setMinutes.execute();// asks for a workout duration in minutes,
                createWorkout.execute();// creates workout
                state = nextAction(dayScheduler);
                break;
            case "history":
                // prompt user for a specific day and display history for that day

                searchHistory.execute();
                state = nextAction(dayScheduler);
                break;
            case "set target weight":
                SetTargetWeight setTargetWeight = new SetTargetWeight(goalManager, scanner);
                setTargetWeight.execute();
                state = nextAction(dayScheduler);
                break;
            case "get target calories":
                GetTargetCalories getTargetCalories = new GetTargetCalories(goalManager);
                getTargetCalories.execute();
                state = nextAction(dayScheduler);
                break;
            case "get remaining calories":
                GetRemainingCalories getRemainingCalories = new GetRemainingCalories(goalManager, logger);
                getRemainingCalories.execute();
                state = nextAction(dayScheduler);
                break;
            case "help":
                logger.gap();
                promptUser();
                input = scanner.nextLine();
                boolean response = parseInput(input, dayScheduler);
                state = response;
                return state;
            case "close":
                if (this.existingUser == false) {
                    storageController.store(userBuilder, historyController, dailyActivity);
                    logger.message("User profile stored!");
                } else {
                    //hypothetically this works
                    storageController.updateUser(userBuilder.getName());
                    logger.message("User profile updated!");
                }
                state = true;
                return state;
            default:
                logger.message("Command not recognized. Try again!");
                logger.query();
                input = scanner.nextLine();
                state = parseInput(input, dayScheduler);
                break;
        }

        return state;
    }

    public Boolean nextAction(DayScheduler dayScheduler) throws Exception {
        // asks the user what they would like to do next, then calls parseInput()
        if (dayScheduler.isPaused() ){
            return false;
        }
        logger.gap();
        logger.message("What would you like to do next?");
        logger.query();
        String input = scanner.nextLine();
        Boolean bool = parseInput(input, dayScheduler);
        return bool;
    }

    public void storeUser() { // stores user profile before closing
        if (this.existingUser == false) {
            storageController.store(userBuilder, historyController, dailyActivity);
            System.out.println("User profile stored!");
        }
    }

    public void run(String[] args) throws IOException, Exception {
        Storage storage = Storage.getInstance();

        if (!(new File("application.db").isFile())) { // Check if database file exists
            storage.createNewDatabase("application.db"); // make database file
            storage.setupTables(); // setup database tables
        }

        // creating concrete commands for user setup
        AddName name = new AddName(userBuilder, logger);
        AddHeight height = new AddHeight(userBuilder, logger);
        AddWeight weight = new AddWeight(userBuilder, logger, historyController);
        AddBirthdate birthdate = new AddBirthdate(userBuilder, logger);
        BuildUser buildUser = new BuildUser(userBuilder);
        DayScheduler dayScheduler = new DayScheduler(currentDay);
        ConfigureTime configureTime = new ConfigureTime(dayScheduler, scanner);
        UpdateWeight updateWeight;

        // startup
        logger.message("\nWelcome to Nutriapp. Tell us a little more about yourself!");
        name.execute();
        // check to see if the user exists
        Boolean exists = storageController.checkUser(userBuilder.getName(), dailyActivity);
        if (exists == true) {
            // sets the existing user to the stored user info epeo
            userBuilder.setUser(storageController.getUser(userBuilder.getName(), dailyActivity));
            // sets user through userbuilder which is the primary way the program accesses
            // user?
            this.goalManager = new GoalManager(userBuilder.getUser(), dailyActivity);
            updateWeight = new UpdateWeight(goalManager, scanner, historyController);
            // creates the goal manager based of the existing user profile, accesses goal
            // through user
            // goal itself should have target weight and physical fitness boolean
            // which should address the startup concerns and any functionality should be
            // fine going forward if i understand this right
            logger.message("\nHi " + userBuilder.getName() + "!");
            this.existingUser = true;
            weight.execute();

        } else {
            // calls the concrete commands for user setup
            height.execute();
            weight.execute();
            birthdate.execute();
            buildUser.execute();
            this.existingUser = false;

            // creates the concrete commands for goal subsystem
            this.goalManager = new GoalManager(userBuilder.getUser(), dailyActivity);
            SetTargetWeight setTargetWeight = new SetTargetWeight(goalManager, scanner);
            SetPhysicalFitness setPhysicalFitness = new SetPhysicalFitness(goalManager, logger);
            updateWeight = new UpdateWeight(goalManager, scanner, historyController);

            // calls goal concrete commands to get user input
            logger.message("\nHi " + userBuilder.getName() + "!");
            logger.message("Tell us more about your fitness goals!");
            setTargetWeight.execute();
            setPhysicalFitness.execute();
        }

        configureTime.execute(); // asks for the period of time for a day to pass

        dayScheduler.startScheduler(); // starts the scheduler

        while (true) {
            // while loop serves as a day of activities -- asks the user what theyd like to
            // do, stores NEW profiles if they choose to close
            // Check if the day is over and take necessary actions
            if (dayScheduler.isDayOver()) {
                System.out.println("\nDay " + currentDay.getDay() + " is over!");

                // Perform end-of-day actions
                goalManager.sendMessage();
                userBuilder.getUser().sendMessage();
                logTodaysActivity.execute();
                //ELEPHANT

                updateWeight.execute();

                // Prompt user to start a new day
                System.out.print(
                        "Type 'next' to start a new day,'time' to change the length of a day or 'close' to exit: ");
                while (true) {
                    String userInput = scanner.nextLine().toLowerCase();
                    if (userInput.equals("next")) {
                        dayScheduler.resumeScheduler();
                        break;
                    } else if (userInput.equals("close")) {
                        storeUser();
                        System.out.println("Bye!");
                        scanner.close();
                        System.exit(0);
                    } else if (userInput.equals("time")) {
                        configureTime.execute();
                        dayScheduler.resumeScheduler();
                        break;
                    }

                    else {
                        System.out.println("Invalid input. Please type 'next' to continue, 'time' or 'close' to exit.");
                    }
                }
            }

            System.out.println("\nToday is Day " + currentDay.getDay());
            logger.message("\nWhat would you like to do today?");
            logger.message("Type 'Help' to view possible commands");
            logger.query();
            String input = scanner.nextLine();
            input = input.toLowerCase();

            
            
            boolean response;
            response = parseInput(input, dayScheduler);

            if (response == true) {
                logger.gap();
                logger.message("Sad to see you go!");
                break;
            }
        }
        dayScheduler.stopScheduler();
        scanner.close();
    }
}