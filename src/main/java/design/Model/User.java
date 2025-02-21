package design.Model;

public class User {
    private String name;
    private float height;
    private float weight;
    private int[] birthdate;
    private int age;

    public User(String name, float height, float weight, int[] birthdate) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthdate = birthdate;

        //[MO,DA,YR]
        int currentYear = Year.now().getValue()
        this.age = currentYear - birthdate[2]
    }