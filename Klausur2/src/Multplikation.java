import java.util.Scanner;

public class Multplikation {

    public static void main(String[] args) {

        double zahl1 = 0.0, zahl2 = 0.0, erg = 0.0;

        Scanner myScanner = new Scanner(System.in);

        //1.Programmhinweis
        printHint();

        //4.Eingabe

        zahl1 = getUserInput(myScanner, 1);
        zahl2 = getUserInput(myScanner, 2);

        //3.Verarbeitung
        erg = calculate(zahl1, zahl2);

        //2.Ausgabe   
        printOutput(zahl1, zahl2, erg);

    }

    private static void printHint() {
        System.out.println("Hinweis: ");
        System.out.println("Das Programm multipliziert 2 eingegebene Zahlen. ");
    }

    private static double getUserInput(Scanner myScanner, int number) {
        System.out.printf("\n %d. Zahl: ", number);
        double input = myScanner.nextDouble();
        return input;
    }

    private static double calculate(double zahl1, double zahl2) {
        double result = zahl1 * zahl2;
        return result;
    }

    private static void printOutput(double zahl1, double zahl2, double erg) {
        System.out.println("\nErgebnis der Multiplikation: ");
        System.out.printf("%.2f * %.2f = %.2f%n", zahl1, zahl2, erg);
    }
}