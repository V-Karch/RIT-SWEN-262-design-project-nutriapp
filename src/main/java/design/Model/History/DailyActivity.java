package design.Model.History;

import java.util.List;

import design.Model.Workout.Workout;

import java.util.ArrayList;

public class DailyActivity {
    private int weight;
    private int calories_consumed;
    private int target_calories;
    private List<String> meals;  // meals are stored as strings for now until we have a meal class
    private List<Workout> workouts; 

    
    public DailyActivity() {
        this.weight = 0;
        this.calories_consumed = 0;
        this.target_calories = 0;
        this.meals = new ArrayList<String>(); //replace with Meal here
        this.workouts = new ArrayList<Workout>(); 

        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getCaloriesConsumed() {
            return calories_consumed;
        }

        public void setCaloriesConsumed(int calories_consumed) {
            this.calories_consumed = calories_consumed;
        }

        public int getTargetCalories() {
            return target_calories;
        }

        public void setTargetCalories(int target_calories) {
            this.target_calories = target_calories;
        }

        public List<String> getMeals() { //replace with Meal here
            return meals;
        }

        public void addMeal(String new_meal) { //replace with Meal here
            this.meals.add(new_meal);
        }

        public List<Workout> getWorkouts() { 
            return workouts;
        }

        public void addWorkout(Workout new_workout) { 
            this.workouts.add(new_workout);
        }
    }

