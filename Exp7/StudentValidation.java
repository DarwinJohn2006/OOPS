//Write a java program to create a user defined exception for the following
//a) Create a student class and get the name of the student and 3 subject marks
//b) Find the length of the name. If the length > 7 throw LengthException
//c) Find the average of marks, if avg < 50 throw FailedException
//d) If avg < 75 && avg > 50 throw NotFirstClassException

import java.util.Scanner;

// Exception for name length
class LengthException extends Exception {
    public LengthException(String message) {
        super(message);
    }
}

// Exception for failed average
class FailedException extends Exception {
    public FailedException(String message) {
        super(message);
    }
}

// Exception for not first class
class NotFirstClassException extends Exception {
    public NotFirstClassException(String message) {
        super(message);
    }
}

// Student class
class Student {
    String name;
    int[] marks = new int[3];

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        return (marks[0] + marks[1] + marks[2]) / 3.0;
    }

    public void display() {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks[0] + ", " + marks[1] + ", " + marks[2]);
        System.out.printf("Average: %.2f\n", calculateAverage());
    }
}

// Main class
public class StudentValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            if (name.length() > 7) {
                throw new LengthException("Name length exceeds 7 characters.");
            }

            int[] marks = new int[3];
            System.out.print("Enter marks for 3 subjects: ");
            for (int i = 0; i < 3; i++) {
                marks[i] = sc.nextInt();
            }

            Student student = new Student(name, marks);
            double avg = student.calculateAverage();

            if (avg < 50) {
                throw new FailedException("Student has failed. Average below 50.");
            } else if (avg < 75) {
                throw new NotFirstClassException("Student passed but not in First Class.");
            }

            student.display();

        } catch (LengthException | FailedException | NotFirstClassException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input! Please try again.");
        }

        sc.close();
    }
}