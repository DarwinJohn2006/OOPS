import java.util.Scanner;

class WordThread implements Runnable {
    private String text;

    WordThread(String text) {
        this.text = text;
    }

    public void run() {
        String[] words = text.split("\\s+");
        for (String word : words) {
            System.out.println(word);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class VowelThread implements Runnable {
    private String text;

    VowelThread(String text) {
        this.text = text;
    }

    public void run() {
        for (char c : text.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1) {
                System.out.println(c);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

public class questionA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph of text:");
        String paragraph = sc.nextLine();

        Thread t1 = new Thread(new WordThread(paragraph));
        Thread t2 = new Thread(new VowelThread(paragraph));

        t1.start();
        t2.start();
        sc.close();
    }
}
