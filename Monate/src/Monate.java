import java.util.Scanner;

public class Monate {
    public static void main(String[] args) {
        while (true) {
            Scanner standardScanner = new Scanner(System.in);

            System.out.println("Bitte geben sie die Ziffer des Monats ein, den sie suchen: ");
            int monthNumber = standardScanner.nextInt();

            if (evalMonth(monthNumber).equals("0")) { System.out.println("Keine zulässige Ziffer");
            } else System.out.println(evalMonth(monthNumber));
        }
    }

    public static String evalMonth(int monthNumber) {
        return switch (monthNumber) {
            case 1 -> "Januar";
            case 2 -> "Februar";
            case 3 -> "März";
            case 4 -> "April";
            case 5 -> "Mai";
            case 6 -> "Juni";
            case 7 -> "Juli";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "Oktober";
            case 11 -> "November";
            case 12 -> "Dezember";
            default -> "0";
        };
    }
}
