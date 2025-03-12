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
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void error(String message) {
        System.out.println("ERROR: " + message);
        query();
    }

    public void query(){
        System.out.print("$ ");
    }

    public void gap(){
        System.out.println("");
    }

    public String readString(){
        String message = scanner.nextLine();
        return message;
    }

    public float readFloat(){
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
        String message = scanner.nextLine();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            LocalDate birthDate = LocalDate.parse(message, formatter);
            return message;
        } catch (Exception e) {
            gap();
            throw new IllegalArgumentException("Invalid, incorrect format");
            
        }
    }

}
