import java.util.Scanner;

public class Klausur {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean correctInput = false;
        int start, end = 0;

        do {
            System.out.println("Geben sie bitte die erste Zahl ein: ");
            start = input.nextInt();

            System.out.println("Geben sie bitte die zweite Zahl ein: ");
            end = input.nextInt();

            if (start == end) {
                System.out.println("Beide Zahlen sind gleich groß.");
            } else {
                if (end < start) {
                    int temp = start;
                    start = end;
                    end = temp;
                    correctInput = true;
                } else {
                    correctInput = true;
                }
            }
        } while (correctInput == false);

        for (int i = start; i <= end; i++) {
            if (i % 2 !=0) {
                System.out.println(i);
            }
        }

    }
}
