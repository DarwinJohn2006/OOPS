import java.util.Scanner;

public class sample1
{
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the characters: ");
        String[] input = sc.nextLine().split(" ");
        char[] chars = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            chars[i] = input[i].charAt(0);
        }
        sc.close();

        int[] freq = new int[256];
        int vowels = 0, consonants = 0;

        for (char c : chars) {
            freq[c]++;
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.print("Duplicate Characters are: ");
        boolean first = true;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 1) {
                if (!first) System.out.print(", ");
                System.out.print((char) i);
                first = false;
            }
        }
        System.out.println();
        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);
    }
}