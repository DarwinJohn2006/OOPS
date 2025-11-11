import java.util.Scanner;

public class Sample3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the sentence: ");
        String input = sc.nextLine();
        sc.close();

        int letters = 0, digits = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isLetter(ch)) {
                letters++;
            } else if (Character.isDigit(ch)) {
                digits++;
            }
        }

        System.out.println("Letters: " + letters);
        System.out.println("Digits: " + digits);
    }
}