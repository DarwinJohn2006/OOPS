import java.util.Scanner;

 abstract class Device {
    protected int deviceId;
    protected String brand;
    protected double price;

    public Device(int deviceId, String brand, double price) {
        this.deviceId = deviceId;
        this.brand = brand;
        this.price = price;
    }

    public abstract void displayDetails();
}

// Interface Discountable
interface Discountable {
    void applyDiscount(double percentage);
    double finalPrice();
}

// Smartphone class
class Smartphone extends Device implements Discountable {
    private double discountPercentage;

    public Smartphone(int deviceId, String brand, double price) {
        super(deviceId, brand, price);
        this.discountPercentage = 0.0;
    }

    @Override
    public void displayDetails() {
        System.out.println("Smartphone Details:");
        System.out.println("ID: " + deviceId);
        System.out.println("Brand: " + brand);
        System.out.println("Original Price: " + price);
        System.out.println("Discount Applied: " + discountPercentage + "%");
        System.out.println("Final Price: " + finalPrice());
    }

    @Override
    public void applyDiscount(double percentage) {
        if (percentage >= 0 && percentage <= 100) {
            this.discountPercentage = percentage;
            System.out.println("Discount of " + percentage + "% applied successfully.");
        } else {
            System.out.println("Invalid discount percentage.");
        }
    }

    @Override
    public double finalPrice() {
        return price - (price * discountPercentage / 100);
    }
}

// Main class with DigitalStore
public class DigitalStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Smartphone smartphone = null;
        int choice;

        do {
            System.out.println("\n--- Smart Device Store Menu ---");
            System.out.println("1. Add Smartphone");
            System.out.println("2. Apply Discount");
            System.out.println("3. View Device Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Device ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Brand: ");
                    String brand = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    smartphone = new Smartphone(id, brand, price);
                    System.out.println("Smartphone added successfully!");
                    break;

                case 2:
                    if (smartphone != null) {
                        System.out.print("Enter discount percentage: ");
                        double discount = sc.nextDouble();
                        smartphone.applyDiscount(discount);
                    } else {
                        System.out.println("No smartphone available. Please add one first.");
                    }
                    break;

                case 3:
                    if (smartphone != null) {
                        smartphone.displayDetails();
                    } else {
                        System.out.println("No smartphone available. Please add one first.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
} 
