import java.util.Scanner;

public class Treppe {
    public static void main(String[] args) {
        int b, h, base;
        Scanner input = new Scanner(System.in);

        System.out.println("Bitte geben sie die Höhe der Treppe ein: ");
        h = input.nextInt();
        System.out.println("Bitte geben sie die Breite der Treppe ein: ");
        b = input.nextInt();

        base = h * b;

        for (int i = h; i >= 0; i--) {
            System.out.printf("%" + base + "s", "*".repeat( base - (b * i) ) );
            System.out.println();
        }
    }
}
