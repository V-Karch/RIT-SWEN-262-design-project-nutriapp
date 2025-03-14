package design.View;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import design.Controller.Food.FoodManager;
import design.Controller.Goal.GoalManager;
import design.Controller.History.HistoryController;
import design.Controller.DayScheduler;
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
import design.View.Food.StockIngredient;
import design.View.Food.ViewShoppingList;
import design.View.Goal.GetTargetCalories;
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
        boolean state = false;
        String request = input.toLowerCase();
        System.out.println();
        if (request.equals("stock")) {
            StockIngredient stockIngredient = new StockIngredient(this.foodManager, scanner);

            stockIngredient.execute();
            state = nextAction();
        }
        if (request.equals("recipe")) {
            CreateRecipe createRecipe = new CreateRecipe(this.foodManager, scanner);
            createRecipe.execute();
            state = nextAction();
        }
        if (request.equals("create meal")) {
            CreateMeal createMeal = new CreateMeal(foodManager, "", scanner);
            createMeal.execute();
            state = nextAction();
        }
        if (request.equals("add recipe")){
            AddRecipe addRecipe = new AddRecipe(foodManager, scanner);
            addRecipe.execute();
            state = nextAction();
        }
        if (request.equals("add ingredient")){
            AddIngredient addIngredient = new AddIngredient(foodManager, scanner);
            addIngredient.execute();
            state = nextAction();
        }
        if (request.equals("prepare meal")) {
            PrepareMeal prepareMeal = new PrepareMeal(foodManager, userBuilder.getUser().getGoal(), scanner, historyController);
            prepareMeal.execute();
            state = nextAction();
        }
        if (request.equals("shopping list")) {
            CreateShoppingList createShoppingList = new CreateShoppingList(foodManager, scanner);
            createShoppingList.execute();
            state = nextAction();
        }
        if(request.equals("view shopping list")){
            ViewShoppingList viewShoppingList = new ViewShoppingList(foodManager, scanner);
            viewShoppingList.execute();
            state = nextAction();
        }
        if (request.equals("workout")) { 
            setName.execute();//asks for a workout name,
            setIntensity.execute();//asks for a workout intensity,
            setMinutes.execute();//asks for a workout duration in minutes,
            createWorkout.execute();// creates workout
            state = nextAction();
        }
        
        if (request.equals("history")) {
            // prompt user for a specific day and display history for that day
         
            searchHistory.execute();
            state = nextAction();
        }
        // Goal requests
        if (request.equals("set target weight")) {
            SetTargetWeight setTargetWeight = new SetTargetWeight(goalManager, scanner);
            setTargetWeight.execute();
        }

        if (request.equals("get target calories")) {
            GetTargetCalories getTargetCalories = new GetTargetCalories(goalManager);
            getTargetCalories.execute();
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
            if (this.existingUser == false){
                storageController.store(userBuilder, historyController);
                System.out.println("User profile stored!");
            }
            state = true;
        }
       
        return state;
    }

    public Boolean nextAction() throws Exception {
        System.out.println("");
        System.out.println("What would you like to do next?");
        String input = scanner.nextLine();
        Boolean bool = parseInput(input);
        return bool;
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
        DayScheduler dayScheduler = new DayScheduler(currentDay, historyController, weight);
        ConfigureTime configureTime = new ConfigureTime(dayScheduler);

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
            System.out.println("\nHi " + userBuilder.getName() + "!");
            this.existingUser = true;

        } else {
            height.execute();
            weight.execute();
            birthdate.execute();
            buildUser.execute();
            this.existingUser = false;

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

        configureTime.execute(); // asks for the period of time for a day to pass

        dayScheduler.startScheduler(); // starts the scheduler

        while (true) {
            // Check if the day is over and take necessary actions
            if (dayScheduler.isDayOver()) {
                System.out.println("\nDay " + currentDay.getDay() + " is over!");
                logTodaysActivity.execute();

                // Perform end-of-day actions
                weight.execute();
                
                // Prompt user to start a new day
                System.out.print("Type 'next' to start a new day: ");
                while (true) {
                    String userInput = scanner.nextLine().toLowerCase();
                    if (userInput.equals("next")) {
                        dayScheduler.resumeScheduler();
                        break;
                    } else {
                        System.out.println("Invalid input. Please type 'next' to continue.");
                    }
                }
            }

            
            System.out.println("\nToday is Day " + currentDay.getDay());
            System.out.println("What would you like to do today?");
            System.out.println("Type 'Help' to view possible commands");
            System.out.print("$ ");
            String input = scanner.nextLine();
            input = input.toLowerCase();

            if (input.equals("close")) {
                if (this.existingUser == false){
                    storageController.store(userBuilder, historyController);
                    System.out.println("User profile stored!");
                }
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
            }

            

        }
        dayScheduler.stopScheduler();
        scanner.close();
    }
}