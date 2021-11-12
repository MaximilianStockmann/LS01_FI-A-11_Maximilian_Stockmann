import java.util.Scanner;

public class Quadrieren {

    public static void main(String[] args) {

        double inputValue;
        Scanner tastatur = new Scanner(System.in);

        // (E) "Eingabe"
        // Wert für x festlegen:
        // ===========================
        printPrompt();
        inputValue = tastatur.nextDouble();

        // (V) Verarbeitung
        // Mittelwert von x und y berechnen:
        // ================================
        double ergebnis = square(inputValue);

        // (A) Ausgabe
        // Ergebnis auf der Konsole ausgeben:
        // =================================
        printOutput(inputValue, ergebnis);
    }

    private static void printPrompt() {
        System.out.println("Bitte geben sie ein von welcher Zahl sie die Quadratzahl berechnen wollen: ");
    }

    private static double square(double toSquare) {
        return toSquare * toSquare;
    }

    private static void printOutput(double x, double xSquared) {
        System.out.printf("x = %.2f und x²= %.2f\n", x, xSquared);
    }
}