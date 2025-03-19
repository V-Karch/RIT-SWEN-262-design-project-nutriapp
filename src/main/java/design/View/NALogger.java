package design.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NALogger {
    public Scanner scanner;
    public NALogger(Scanner scanner){
        this.scanner = scanner;
    }

    public void message(String message) {
        //prints with newLine
        System.out.println(message);
    }

    public void print(String message) {
        //prints without newLine
        System.out.print(message);
    }

    public void error(String message) {
        //formatting for errors
        System.out.println("ERROR: " + message);
        query();
    }

    public void query(){
        //formatting for user responses
        System.out.print("$ ");
    }

    public void gap(){
        //formatting for gaps
        System.out.println("");
    }

    public String readString(){
        //reads a string? input validation can go here
        String message = scanner.nextLine();
        return message;
    }

    public float readFloat(){
        //checks that a line is a float, throws error if not
        String message = scanner.nextLine();
        try {
            Float value = Float.parseFloat(message);
            return value;
        } catch (Exception e) {
            gap();
            throw new IllegalArgumentException("Not a float");
            
        }
    }

    public String readBirthday(){
        //checks that a line is in proper birthday formatting, throws error if not
        String message = scanner.nextLine();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            LocalDate.parse(message, formatter); // Throws exception if not valid
            return message;
        } catch (Exception e) {
            gap();
            throw new IllegalArgumentException("Invalid, incorrect format");
            
        }
    }

}
