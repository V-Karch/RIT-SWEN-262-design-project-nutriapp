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
    
    //controllers
    static HistoryController historyController = new HistoryController(new HistoryManager());
    static WorkoutController workoutController = new WorkoutController(new WorkoutBuilder(currentDay), new WorkoutManager());
    
    //history commands
    static SearchHistory searchHistory = new SearchHistory(scanner, historyController);
    static LogTodaysActivity logTodaysActivity = new LogTodaysActivity(historyController, currentDay);
    
    //workout commands
    static SetName setName = new SetName(workoutController, scanner);
    static SetIntensity setIntensity = new SetIntensity(workoutController, scanner);
    static SetMinutes setMinutes = new SetMinutes(workoutController, scanner);
    static CreateWorkout createWorkout = new CreateWorkout(workoutController, historyController);

    static UserBuilder userBuilder = new UserBuilder();
    static StorageController storageController = new StorageController();
    Boolean existingUser;

    FoodManager foodManager;
    GoalManager goalManager;
   
    public NutriappCLI() throws IOException {
        this.foodManager = new FoodManager("src/main/java/design/ingredients.csv");
        userBuilder = new UserBuilder();
    }

    public static void main(String[] args) throws IOException, Exception {
        //runs the application
        NutriappCLI nutriapp = new NutriappCLI();
        nutriapp.run(args);
    }

    public void promptUser() {
        //prints all possible commands to terminal
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
        logger.message("Type 'Get Target Calories' to see your remaining allotted calories for the day");
        logger.message("Type 'Set Target Weight' to change your target weight");
        logger.message("Type 'Close' to exit the application");
        logger.message("Type 'Help' to view all commands");
        logger.gap();
        logger.query();
    }

    public boolean parseInput(String input) throws Exception {
        //reads user input and calls the correct concrete command, then calls nextAction() (unless skip or close)
        boolean state = false;
        String request = input.toLowerCase();
        System.out.println("INPUT: " + request);
        logger.gap();
        switch (request) {
            case "search":
                SearchIngredient searchIngredient = new SearchIngredient(this.foodManager, scanner);
                searchIngredient.execute();
                state = nextAction();
                break;
            case "stock":
                StockIngredient stockIngredient = new StockIngredient(this.foodManager, scanner);
                stockIngredient.execute();
                state = nextAction();
                break;
            case "recipe":
                CreateRecipe createRecipe = new CreateRecipe(this.foodManager, scanner);
                createRecipe.execute();
                state = nextAction();
                break;
            case "create meal":
                CreateMeal createMeal = new CreateMeal(foodManager, "", scanner);
                createMeal.execute();
                state = nextAction();
                break;
            case "add recipe":
                AddRecipe addRecipe = new AddRecipe(foodManager, scanner);
                addRecipe.execute();
                state = nextAction();
                break;
            case "add ingredient":
                AddIngredient addIngredient = new AddIngredient(foodManager, scanner);
                addIngredient.execute();
                state = nextAction();
                break;
            case "prepare meal":
                PrepareMeal prepareMeal = new PrepareMeal(foodManager, userBuilder.getUser().getGoal(), scanner, historyController);
                prepareMeal.execute();
                state = nextAction();
                break;
            case "shopping list":
                CreateShoppingList createShoppingList = new CreateShoppingList(foodManager, scanner);
                createShoppingList.execute();
                state = nextAction();
                break;
            case "view shopping list":
                ViewShoppingList viewShoppingList = new ViewShoppingList(foodManager, scanner);
                viewShoppingList.execute();
                state = nextAction();
                break;
            case "workout":
                setName.execute();//asks for a workout name,
                setIntensity.execute();//asks for a workout intensity,
                setMinutes.execute();//asks for a workout duration in minutes,
                createWorkout.execute();// creates workout
                state = nextAction();
                break;
            case "history":
                // prompt user for a specific day and display history for that day
                
                searchHistory.execute();
                state = nextAction();
                break;
            case "set target weight":
                SetTargetWeight setTargetWeight = new SetTargetWeight(goalManager, scanner);
                setTargetWeight.execute();
                state = nextAction();
                break;
            case "get target calories":
                GetTargetCalories getTargetCalories = new GetTargetCalories(goalManager);
                getTargetCalories.execute();
                state = nextAction();
                break;
            case "help":
                logger.gap();
                promptUser();
                input = scanner.nextLine();
                boolean response =parseInput(input);
                state = response;
                return state;
            case "close":
                if (this.existingUser == false){
                    storageController.store(userBuilder, historyController);
                    logger.message("User profile stored!");
                }
                state = true;
                return state;
            default:
                logger.message("Command not recognized. Try again!");
                logger.query();
                input = scanner.nextLine();
                state = parseInput(input);
                break;
        }
       
        return state;
    }

    public Boolean nextAction() throws Exception {
        //asks the user what they would like to do next, then calls parseInput() 
        logger.gap();
        logger.message("What would you like to do next?");
        logger.query();
        String input = scanner.nextLine();
        Boolean bool = parseInput(input);
        return bool;
    }

    public void storeUser() { // stores user profile before closing
        if (this.existingUser == false){
            storageController.store(userBuilder, historyController);
            System.out.println("User profile stored!");
        }
    }

    public void run(String[] args) throws IOException, Exception {
        if (!(new File("application.db").isFile())) { // Check if database file exists
            Storage.createNewDatabase("application.db"); // make database file
            Storage.setupTables(); // setup database tables
        }

        // creating concrete commands for user setup
        AddName name = new AddName(userBuilder, logger);
        AddHeight height = new AddHeight(userBuilder, logger);
        AddWeight weight = new AddWeight(userBuilder, logger, historyController);
        AddBirthdate birthdate = new AddBirthdate(userBuilder, logger);
        BuildUser buildUser = new BuildUser(userBuilder);
        DayScheduler dayScheduler = new DayScheduler(currentDay);
        ConfigureTime configureTime = new ConfigureTime(dayScheduler, scanner);

        // startup
        logger.message("\nWelcome to Nutriapp. Tell us a little more about yourself!");
        name.execute();
        //check to see if the user exists
        Boolean exists = storageController.checkUser(userBuilder.getName());
        if (exists == true){
            //sets the existing user to the stored user info epeo
            userBuilder.setUser(storageController.getUser(userBuilder.getName()));
            //sets user through userbuilder which is the primary way the program accesses user?
            this.goalManager = new GoalManager(userBuilder.getUser());
            //creates the goal manager based of the existing user profile, accesses goal through user
            //goal itself should have target weight and physical fitness boolean
            //which should address the startup concerns and any functionality should be fine going forward if i understand this right
            logger.message("\nHi " + userBuilder.getName() + "!");
            this.existingUser = true;
            weight.execute();

        } else {
            //calls the concrete commands for user setup
            height.execute();
            weight.execute();
            birthdate.execute();
            buildUser.execute();
            this.existingUser = false;

            // creates the concrete commands for goal subsystem
            this.goalManager = new GoalManager(userBuilder.getUser());
            SetTargetWeight setTargetWeight = new SetTargetWeight(goalManager, scanner);
            SetPhysicalFitness setPhysicalFitness = new SetPhysicalFitness(goalManager, scanner);

            //calls goal concrete commands to get user input
            logger.message("\nHi " + userBuilder.getName() + "!");
            logger.message("Tell us more about your fitness goals!");
            setTargetWeight.execute();
            setPhysicalFitness.execute();
        }

        configureTime.execute(); // asks for the period of time for a day to pass
        

        dayScheduler.startScheduler(); // starts the scheduler

        while (true) {
            //while loop serves as a day of activities -- asks the user what theyd like to do, stores NEW profiles if they choose to close
            // Check if the day is over and take necessary actions
            if (dayScheduler.isDayOver()) {
                System.out.println("\nDay " + currentDay.getDay() + " is over!");
                
                // Perform end-of-day actions
                logTodaysActivity.execute();
                weight.execute();
                
                // Prompt user to start a new day
                System.out.print("Type 'next' to start a new day,'time' to change the length of a day or 'close' to exit: ");
                while (true) {
                    String userInput = scanner.nextLine().toLowerCase();
                    if (userInput.equals("next")) {
                        dayScheduler.resumeScheduler();
                        break;
                    } else if(userInput.equals("close")) {
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

            if (input.equals("close")) {
                if (this.existingUser == false){
                    storageController.store(userBuilder, historyController);
                    logger.message("User profile stored!");
                }
                storeUser();
                logger.message("Bye!");
                System.exit(0);

            } else {
                // enables the user to do multiple things within a 24 hr period
                boolean response;
                response = parseInput(input);
                if (response == true) {
                    logger.gap();
                    logger.message("Sad to see you go!");
                    break;
                }
            }

                // Potentially problematic
                logger.gap();
                logTodaysActivity.execute();
                logger.message("***A day has passed***");
                logger.message("Good Morning!");
                UpdateWeight updateWeight = new UpdateWeight(goalManager, scanner, historyController);
                updateWeight.execute();
                GetTargetCalories getTargetCalories = new GetTargetCalories(goalManager);
                getTargetCalories.execute();
                logger.gap();
            
        }
        dayScheduler.stopScheduler();
        scanner.close();
    }
}