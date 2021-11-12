import java.util.Scanner;

public class Fahrsimulator {
    public static void main(String[] args) {
        double v = 0.0;
        double dv;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Um wie viel soll beschleunigt werden?");
            dv = input.nextDouble();

            v = beschleunige(v, dv);
            System.out.println("Die neue Geschwindigkeit beträgt: " + v + " km/h\n");
        }
    }

    private static double beschleunige(double v, double dv) {
        double newV = v + dv;

        if (newV > 130.0) {
            System.out.println("Es kann nur bis zur Maximalgeschwindigkeit von 130 Km/h beschleunigt werden!");
            newV = 130.0;
        }
        if (newV < 0.0) {
            System.out.println("Es kann nur bis zur Minimalgeschwindigkeit von 0 Km/h gebremst werden!");
            newV = 0.0;
        }

        return newV;
    }
}
