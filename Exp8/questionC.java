import java.util.Scanner;

class TableAndDivisorThread extends Thread {
    int num;

    TableAndDivisorThread(int num) {
        this.num = num;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            // Print divisor
            System.out.println("Divisor: " + i);

            // Print multiplication table
            System.out.println(num + " x " + i + " = " + (num * i));

            try {
                Thread.sleep(2000); // 2 seconds delay
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class questionC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        TableAndDivisorThread t1 = new TableAndDivisorThread(num);
        t1.start(); // Start the single combined thread

        sc.close();
    }
}
