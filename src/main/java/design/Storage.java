package design;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import design.Model.UserSS.User;
import java.sql.PreparedStatement;

public class Storage {
    private static final String DATABASE_URL = "jdbc:sqlite:application.db";

    public static void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:" + fileName;

        try {
            DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void executeSQL(String sql) {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            Statement statement = connection.createStatement();

            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error executing SQL: " + e.getMessage());
        }
    }

    private static void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n" + //
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" + //
                "    name TEXT NOT NULL,\n" + //
                "    height REAL NOT NULL,\n" + //
                "    birth_date TEXT NOT NULL,  -- Stored as TEXT in MM-dd-yyyy format\n" + //
                "    age INTEGER NOT NULL,\n" + //
                "    current_weight REAL NOT NULL,\n" + //
                "    target_weight REAL NOT NULL,\n" + //
                "    current_goal TEXT NOT NULL\n" + //
                ");\n" + //
                "";

        Storage.executeSQL(sql);
    }

    public static void addUser(
            String name,
            double height,
            String birthDate,
            int age,
            double currentWeight,
            double targetWeight,
            String currentGoal) {

        String sql = "INSERT INTO users (name, height, birth_date, age, current_weight, target_weight, current_goal) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, height);
            preparedStatement.setString(3, birthDate); // Must be in MM-dd-yyyy format
            preparedStatement.setInt(4, age);
            preparedStatement.setDouble(5, currentWeight);
            preparedStatement.setDouble(6, targetWeight);
            preparedStatement.setString(7, currentGoal);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting user: " + e.getMessage());
        }
    }

    public static User getUserById(int userId) {
        String sql = "SELECT * FROM users WHERE id = ?;";

        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                User user = new User(
                        rs.getString("name"),
                        (float) rs.getDouble("height"),
                        (float) rs.getDouble("current_weight"),
                        rs.getString("birth_date") // Expected in MM-dd-yyyy format
                );

                // TODO: FIX THIS PART user.updateTargetWeight(rs.getDouble("target_weight"));
                // TODO: attach and store goal
                // TODO: attach and store history

                return user;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving user: " + e.getMessage());
        }

        return null; // Return null if no user was found
    }

    public static void setupTables() {
        Storage.createUsersTable();
    }

    public static void main(String args[]) {
        Storage.createNewDatabase("application.db");
        Storage.setupTables();

        Storage.addUser(
                "Luna",
                167,
                "02-14-2005",
                20,
                200,
                150,
                "Some");

        User luna = Storage.getUserById(1);
        System.out.println(luna.getName());
    }
}
