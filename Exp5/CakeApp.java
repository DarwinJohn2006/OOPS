import java.util.Scanner;

// Superclass
class Cake {
    protected String name;
    protected String flavor;
    protected double price;

    public Cake(String name, String flavor, double price) {
        this.name = name;
        this.flavor = flavor;
        this.price = price;
    }

    public double CalculatePrice() {
        return price; // Base price
    }

    public void displayDetails(double finalPrice) {
        System.out.println("\n--- Cake Details ---");
        System.out.println("Name: " + name);
        System.out.println("Flavor: " + flavor);
        System.out.println("Base Price: " + price);
        System.out.println("Final Price: " + finalPrice);
    }
}

// Subclass for OrderCake
class OrderCake extends Cake {
    private double weight;

    public OrderCake(String name, String flavor, double price, double weight) {
        super(name, flavor, price);
        this.weight = weight;
    }

    @Override
    public double CalculatePrice() {
        return price * weight;
    }
}

// Subclass for ReadyMadeCake
class ReadyMadeCake extends Cake {
    private int quantity;

    public ReadyMadeCake(String name, String flavor, double price, int quantity) {
        super(name, flavor, price);
        this.quantity = quantity;
    }

    @Override
    public double CalculatePrice() {
        return price * quantity;
    }
}

// Main class
public class CakeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Cake Menu ---");
            System.out.println("1. Order Cake");
            System.out.println("2. Ready-Made Cake");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            sc.nextLine(); // Clear buffer
            System.out.print("Enter Cake Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Cake Flavor: ");
            String flavor = sc.nextLine();

            System.out.print("Enter Base Price: ");
            double price = sc.nextDouble();

            Cake cake = null;

            switch (choice) {
                case 1:
                    System.out.print("Enter Weight (kg): ");
                    double weight = sc.nextDouble();
                    cake = new OrderCake(name, flavor, price, weight);
                    break;

                case 2:
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    cake = new ReadyMadeCake(name, flavor, price, quantity);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            double finalPrice = cake.CalculatePrice();
            cake.displayDetails(finalPrice);
        }

        sc.close();
    }
}