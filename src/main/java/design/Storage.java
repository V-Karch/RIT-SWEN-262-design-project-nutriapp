package design;

import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import design.Model.Goal.Goal;
import design.Model.UserSS.User;
import java.sql.PreparedStatement;
import design.Model.Goal.LoseWeight;
import design.Model.Food.Ingredient;
import design.Model.Food.Recipe;
import design.Model.Goal.GainWeight;
import design.Model.Goal.MaintainWeight;
import design.Controller.Food.FoodManager;

// Figure Recipe and Meal the heck out
// Figure out personal history too

/**
 * The Storage class provides methods for interacting with a SQLite database.
 * It handles database creation, table setup, and CRUD operations for users and
 * goals.
 * 
 * @Author: V-Karch
 */
public class Storage {
    private static Storage storageInstance;

    private Storage() {
    };

    public static synchronized Storage getInstance() {
        if (storageInstance == null) {
            storageInstance = new Storage();
        }

        return storageInstance;
    }

    /**
     * Creates a new SQLite database file.
     * 
     * @param fileName The name of the database file to be created.
     */
    public void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:" + fileName;

        try {
            DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Executes a given SQL statement.
     * 
     * @param sql The SQL statement to be executed.
     */
    public void executeSQL(String sql) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:application.db");
                Statement statement = connection.createStatement();) {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error executing SQL: " + e.getMessage());
        }
    }

    /**
     * Creates the 'users' table if it does not already exist.
     */
    private void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    name TEXT NOT NULL,\n" +
                "    height REAL NOT NULL,\n" +
                "    birth_date TEXT NOT NULL,  -- Stored as TEXT in MM-dd-yyyy format\n" +
                "    age INTEGER NOT NULL,\n" +
                "    current_weight REAL NOT NULL,\n" +
                "    target_weight REAL NOT NULL\n" +
                "    password_hash TEXT NOT NULL,\n" +
                ");";

        executeSQL(sql);
    }

    /**
     * Creates the 'goals' table if it does not already exist.
     */
    private void createGoalsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS goals (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    username TEXT NOT NULL,\n" +
                "    physical_fitness BOOLEAN NOT NULL,\n" +
                "    target_calories INTEGER NOT NULL,\n" +
                "    daily_calories INTEGER NOT NULL,\n" +
                "    type TEXT NOT NULL\n" +
                ");";

        executeSQL(sql);
    }

    private void createStockTable() {
        String sql = "CREATE TABLE IF NOT EXISTS stock (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    ingredient TEXT NOT NULL,\n" +
                "    amount INTEGER NOT NULL,\n" +
                "    username TEXT NOT NULL\n" +
                ");";

        executeSQL(sql);
    }

    private void createRecipesTable() {
        String sql = "CREATE TABLE IF NOT EXISTS recipes (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    username TEXT NOT NULL,\n" +
                "    cookIngredients TEXT NOT NULL,\n" +
                "    ingredientData TEXT NOT NULL\n" +
                ");";

        executeSQL(sql);
    }

    /**
     * Inserts a new goal into the database.
     * 
     * @param goal The goal object to be added.
     */
    public void addGoal(Goal goal) {
        String sql = "INSERT INTO goals (username, physical_fitness, target_calories, daily_calories, type) " +
                "VALUES (?, ?, ?, ?, ?);";

        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:application.db");
                PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, goal.getUser().getName());
            preparedStatement.setBoolean(2, goal.getPhysicalFitness());
            preparedStatement.setInt(3, goal.getTargetCalories());
            preparedStatement.setInt(4, goal.getDailyCalories());
            preparedStatement.setString(5, goal.getClass().getSimpleName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting goal: " + e.getMessage());
        }
    }

    /**
     * Inserts a new user into the database and assigns a goal.
     * 
     * @param user The user object to be added.
     */
    public void addUser(User user) {
        String sql = "INSERT INTO users (name, height, birth_date, age, current_weight, target_weight, password_hash) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:application.db");
                PreparedStatement preparedStatement = connection.prepareStatement(sql);) { // Please SonarQube Like This
                                                                                           // :pleading_face:
            preparedStatement.setString(1, user.getName());
            preparedStatement.setDouble(2, user.getHeight());
            preparedStatement.setString(3, user.getBirthdate()); // Must be in MM-dd-yyyy format
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setDouble(5, user.getCurrentWeight());
            preparedStatement.setDouble(6, user.getTargetWeight());
            preparedStatement.setString(7, user.getHash());

            preparedStatement.executeUpdate();

            addGoal(user.getGoal());
        } catch (SQLException e) {
            System.out.println("Error inserting user: " + e.getMessage());
        }
    }

    /**
     * Updates an existing user in the database and assigns a goal.
     * 
     * @param user The user object to be updated.
     */
    public void updateUser(User user) {
        User foundUser = getUserByName(user.getName());

        if (foundUser == null) {
            addUser(user); // User not found, so add them
            return;
        }

        String sql = "UPDATE users SET height = ?, birth_date = ?, age = ?, current_weight = ?, target_weight = ?, password_hash = ? "
                +
                "WHERE name = ?;";

        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:application.db");
                PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setDouble(1, user.getHeight());
            preparedStatement.setString(2, user.getBirthdate());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setDouble(4, user.getCurrentWeight());
            preparedStatement.setDouble(5, user.getTargetWeight());
            preparedStatement.setString(6, user.getName());
            preparedStatement.setString(7, user.getHash());

            preparedStatement.executeUpdate();
            updateGoal(user.getGoal());
        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }

    /**
     * Updates an existing goal in the database.
     * 
     * @param goal The goal object to be updated
     */
    public void updateGoal(Goal goal) {
        String sql = "UPDATE goals SET physical_fitness = ?, target_calories = ?, daily_calories = ?, type = ? "
                + "WHERE username = ?;";

        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:application.db");
                PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setBoolean(1, goal.getPhysicalFitness());
            preparedStatement.setInt(2, goal.getTargetCalories());
            preparedStatement.setInt(3, goal.getDailyCalories());
            preparedStatement.setString(4, goal.getClass().getSimpleName());
            preparedStatement.setString(5, goal.getUser().getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating goal: " + e.getMessage());
        }
    }

    // Recipe -> { name | cookInstructions as String with bars | {
    // ingredientname|amount@ingredientname|amount} | username }
    // Name -> String text not null
    // username -> String text not null
    // cookInstructions String[] concatenated from
    // ingredientname|amount@ingredientname|amount for however many entries, giant
    // string not null concatenated
    public void updateRecipes(FoodManager foodManager, String username) {
        String selectSQL = "SELECT id FROM recipes WHERE cookIngredients = ? AND username = ?";
        String insertSQL = "INSERT INTO recipes (username, cookIngredients, ingredientData) VALUES (?, ?, ?)";
        String updateSQL = "UPDATE recipes SET ingredientData = ?, cookIngredients = ? WHERE username = ? AND cookIngredients = ?";

        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:application.db");
                PreparedStatement selectstatement = connection.prepareStatement(selectSQL);
                PreparedStatement insertstatement = connection.prepareStatement(insertSQL);
                PreparedStatement updatestatement = connection.prepareStatement(updateSQL)) {
            for (Recipe recipe : foodManager.getAllRecipes()) {
                String recipeName = recipe.getName();

                // Join instructions with "|"
                String cookInstructionsStr = String.join("|", recipe.getCookInstructions());

                // Format ingredients as raw concatenation:
                // "ingredient|amount@ingredient|amount@..."
                String ingredientDataStr = "";
                for (Ingredient ingredient : recipe.getIngredients()) {
                    int amount = recipe.getIngredientMap().get(ingredient);
                    ingredientDataStr += ingredient.getName() + "|" + amount + "@";
                }

                if (ingredientDataStr.endsWith("@")) { // This is so jank istg
                    ingredientDataStr = ingredientDataStr.substring(0, ingredientDataStr.length() - 1);
                }

                // Check if recipe already exists
                selectstatement.setString(1, recipeName);
                selectstatement.setString(2, username);
                ResultSet rs = selectstatement.executeQuery();

                if (rs.next()) {
                    // Update existing recipe
                    updatestatement.setString(1, ingredientDataStr);
                    updatestatement.setString(2, cookInstructionsStr);
                    updatestatement.setString(3, username);
                    updatestatement.setString(4, recipeName);
                    updatestatement.executeUpdate();
                } else {
                    // Insert new recipe
                    insertstatement.setString(1, username);
                    insertstatement.setString(2, recipeName);
                    insertstatement.setString(3, ingredientDataStr);
                    insertstatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating recipes: " + e.getMessage());
        }
    }

    public void updateStock(FoodManager foodManager, String username) {
        String selectSQl = "SELECT id FROM stock WHERE ingredient = ? AND username = ?";
        String insertSQl = "INSERT INTO stock (ingredient, amount, username) VALUES (?, ?, ?)";
        String updateSQl = "UPDATE stock SET amount = ? WHERE ingredient = ? AND username = ?";

        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:application.db");
                PreparedStatement selectStatement = connection.prepareStatement(selectSQl);
                PreparedStatement insertStatement = connection.prepareStatement(insertSQl);
                PreparedStatement updateStatement = connection.prepareStatement(updateSQl);) {
            for (Ingredient i : foodManager.getStock()) {
                String ingredient = i.getName();
                int amount = i.getStock();

                // Check if the ingredient already exists
                selectStatement.setString(1, ingredient);
                selectStatement.setString(2, username);
                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    // Update existing entry
                    updateStatement.setInt(1, amount);
                    updateStatement.setString(2, ingredient);
                    updateStatement.setString(3, username);
                    updateStatement.executeUpdate();
                } else {
                    // Insert new entry
                    insertStatement.setString(1, ingredient);
                    insertStatement.setInt(2, amount);
                    insertStatement.setString(3, username);
                    insertStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating stock: " + e.getMessage());
        }
    }

    public User getUserByNameAndPassword(String name, String hash) {
        String userSql = "SELECT name, height, birth_date, age, current_weight, target_weight FROM users WHERE name = ? AND password_hash = ?";
        String goalSql = "SELECT physical_fitness, target_calories, daily_calories, type FROM goals WHERE username = ? ";

        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:application.db");
                PreparedStatement userStatement = connection.prepareStatement(userSql);
                PreparedStatement goalStatement = connection.prepareStatement(goalSql);) {
            userStatement.setString(1, name);
            userStatement.setString(2, hash);
            ResultSet userResult = userStatement.executeQuery();

            if (!userResult.next()) {
                System.out.println("User not found.");
                return null; // Return null if user does not exist
            }

            // Create User object
            String retrievedName = userResult.getString("name");
            float height = userResult.getFloat("height");
            String birthDate = userResult.getString("birth_date");
            double currentWeight = userResult.getDouble("current_weight");
            double targetWeight = userResult.getDouble("target_weight");

            User user = new User(retrievedName, height, (float) currentWeight, birthDate, hash);
            user.updateTargetWeight(targetWeight); // Ensures target weight is set

            // Fetch goal data
            goalStatement.setString(1, name);
            ResultSet goalResult = goalStatement.executeQuery();

            if (goalResult.next()) {
                boolean physicalFitness = goalResult.getBoolean("physical_fitness");
                int targetCalories = goalResult.getInt("target_calories");
                int dailyCalories = goalResult.getInt("daily_calories");
                String type = goalResult.getString("type");

                Goal goal;
                switch (type) {
                    case "GainWeight":
                        goal = new GainWeight(user, physicalFitness, targetCalories);
                        break;
                    case "LoseWeight":
                        goal = new LoseWeight(user, physicalFitness, targetCalories);
                        break;
                    case "MaintainWeight":
                        goal = new MaintainWeight(user, physicalFitness, dailyCalories);
                        break;
                    default:
                        System.out.println("Unknown goal type: " + type);
                        return user; // Return user without a goal if the type is unknown
                }

                user.setGoal(goal); // Attach the goal to the user
            } else {
                System.out.println("No goal found for user: " + name);
            }

            return user;

        } catch (SQLException e) {
            System.out.println("Error retrieving user and goal: " + e.getMessage());
        }

        return null; // Return null if there was an error
    }

    public List<String> getUserNames() {
        String sql = "SELECT name FROM users";
        List<String> userNames = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:application.db");
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                userNames.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving user names: " + e.getMessage());
        }

        return userNames;
    }

    /**
     * Retrieves a user by name from the database, along with their associated goal.
     * 
     * @param name The name of the user to retrieve.
     * @return The User object, or null if not found.
     */
    public User getUserByName(String name) {
        String userSql = "SELECT name, height, birth_date, age, current_weight, target_weight, password_hash FROM users WHERE name = ?";
        String goalSql = "SELECT physical_fitness, target_calories, daily_calories, type FROM goals WHERE username = ?";

        try (
                Connection connection = DriverManager.getConnection("jdbc:sqlite:application.db");
                PreparedStatement userStatement = connection.prepareStatement(userSql);
                PreparedStatement goalStatement = connection.prepareStatement(goalSql);) {
            userStatement.setString(1, name);
            ResultSet userResult = userStatement.executeQuery();

            if (!userResult.next()) {
                System.out.println("User not found.");
                return null; // Return null if user does not exist
            }

            // Create User object
            String retrievedName = userResult.getString("name");
            float height = userResult.getFloat("height");
            String birthDate = userResult.getString("birth_date");
            double currentWeight = userResult.getDouble("current_weight");
            double targetWeight = userResult.getDouble("target_weight");
            String hash = userResult.getString("password_hash");

            User user = new User(retrievedName, height, (float) currentWeight, birthDate, hash);
            user.updateTargetWeight(targetWeight); // Ensures target weight is set

            // Fetch goal data
            goalStatement.setString(1, name);
            ResultSet goalResult = goalStatement.executeQuery();

            if (goalResult.next()) {
                boolean physicalFitness = goalResult.getBoolean("physical_fitness");
                int targetCalories = goalResult.getInt("target_calories");
                int dailyCalories = goalResult.getInt("daily_calories");
                String type = goalResult.getString("type");

                Goal goal;
                switch (type) {
                    case "GainWeight":
                        goal = new GainWeight(user, physicalFitness, targetCalories);
                        break;
                    case "LoseWeight":
                        goal = new LoseWeight(user, physicalFitness, targetCalories);
                        break;
                    case "MaintainWeight":
                        goal = new MaintainWeight(user, physicalFitness, dailyCalories);
                        break;
                    default:
                        System.out.println("Unknown goal type: " + type);
                        return user; // Return user without a goal if the type is unknown
                }

                user.setGoal(goal); // Attach the goal to the user
            } else {
                System.out.println("No goal found for user: " + name);
            }

            return user;

        } catch (SQLException e) {
            System.out.println("Error retrieving user and goal: " + e.getMessage());
        }

        return null; // Return null if there was an error
    }

    public void setupTables() {
        createUsersTable();
        createGoalsTable();
        createStockTable();
        createRecipesTable();
    }
}
