import java.util.Scanner;

public class Ticket_booking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter day of booking (1-7): ");
        int day = sc.nextInt();

        if (age < 5) {
            System.out.println("The Ticket is free");
        } 
        else if (age >= 5 && age <= 18 && day >= 1 && day <= 5) {
            double price = 200 - (0.5 * 200);
            System.out.println("The Ticket costs: " + price);
        } 
        else if (age >= 5 && age <= 18 && day >= 6 && day <= 7) {
            double price = 200 - (0.4 * 200);
            System.out.println("The Ticket costs: " + price);
        } 
        else if (age >= 19 && age <= 60 && day >= 1 && day <= 5) {
            double price = 200 - (0.1 * 200);
            System.out.println("The Ticket costs: " + price);
        } 
        else if (age > 60 && day >= 1 && day <= 5) {
            double price = 200 - (0.4 * 200);
            System.out.println("The Ticket costs: " + price);
        } 
        else if (age > 60 && day >= 6 && day <= 7) {
            double price = 200 - (0.3 * 200);
            System.out.println("The Ticket costs: " + price);
        } 
        else {
            System.out.println("The Ticket costs 200");
        }

        sc.close();
    }
}




