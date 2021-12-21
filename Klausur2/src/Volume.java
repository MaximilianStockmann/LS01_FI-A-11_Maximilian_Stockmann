import java.util.Scanner;

public class Volume {
    final static double PI = 3.1415;

    public static void main(String[] args) {
        double radius;
        double result;

        Scanner input = new Scanner(System.in);

        radius = getUserInput(input);

        result = calculateVolume(radius);

        printResult(result);
    }

    private static double getUserInput(Scanner input) {
        System.out.println("Bitte geben sie den Radius einer Kugel ein: ");
        double radius = input.nextDouble();
        return radius;
    }

    private static double calculateVolume(double radius) {
        double volume = (4.0 / 3.0) * PI * radius * radius * radius;
        return volume;
    }

    private static void printResult(double result) {
        System.out.printf("Das Volumen der Kugel ist %.2f", result);
    }
}
