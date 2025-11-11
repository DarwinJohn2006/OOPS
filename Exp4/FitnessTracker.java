import java.util.Scanner;

// Base class
class UserProfile {
    protected String name;
    protected int age;
    protected double weight;
    protected double height;

    public UserProfile(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Weight (kg): " + weight);
        System.out.println("Height (cm): " + height);
    }
}

// Subclass with fitness tracking features
class FitnessTracking extends UserProfile {
    private int steps;
    private double calories;

    public FitnessTracking(String name, int age, double weight, double height, int steps, double calories) {
        super(name, age, weight, height);
        this.steps = steps;
        this.calories = calories;
    }

    public void updateSteps(int additionalSteps) {
        steps += additionalSteps;
    }

    public void updateCalories(double additionalCalories) {
        calories += additionalCalories;
    }

    public double calculateBMI() {
        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Total Steps: " + steps);
        System.out.println("Total Calories Burned: " + calories);
        System.out.printf("BMI: %.2f\n", calculateBMI());
    }
}

// Main class
public class FitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Weight (kg): ");
        double weight = sc.nextDouble();

        System.out.print("Enter Height (cm): ");
        double height = sc.nextDouble();

        System.out.print("Enter Initial Steps: ");
        int steps = sc.nextInt();

        System.out.print("Enter Initial Calories Burned: ");
        double calories = sc.nextDouble();

        // Runtime polymorphism
        UserProfile profile = new FitnessTracking(name, age, weight, height, steps, calories);

        System.out.print("Enter Additional Steps: ");
        int extraSteps = sc.nextInt();
        ((FitnessTracking) profile).updateSteps(extraSteps);

        System.out.print("Enter Additional Calories Burned: ");
        double extraCalories = sc.nextDouble();
        ((FitnessTracking) profile).updateCalories(extraCalories);

        System.out.println("\n--- Fitness Tracker ---");
        profile.displayInfo();

        sc.close();
    }
}