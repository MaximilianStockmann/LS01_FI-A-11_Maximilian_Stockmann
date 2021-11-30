import java.util.Scanner;

public class PCHaendler {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Benutzereingaben lesen
        String artikel = liesString(myScanner, "was möchten Sie bestellen?");

        int anzahl = liesInt(myScanner, "Geben Sie die Anzahl ein:");
        double preis = liesDouble(myScanner, "Geben Sie den Nettopreis ein:");
        double mwst = liesDouble(myScanner, "Geben Sie den Mehrwertsteuersatz in Prozent ein:");

        // Verarbeiten
        double nettogesamtpreis = berechneGesamtnettopreis(anzahl, preis);
        double bruttogesamtpreis = berechneGesamtbruttopreis(nettogesamtpreis, mwst);

        // Ausgeben
        rechnungausgeben(artikel, anzahl, nettogesamtpreis, bruttogesamtpreis, mwst);

    }

    private static String liesString(Scanner myScanner, String text) {
        System.out.println(text);
        return myScanner.next();
    }

    private static int liesInt(Scanner myScanner, String text) {
        System.out.println(text);
        return myScanner.nextInt();
    }

    private static double liesDouble(Scanner myScanner, String text) {
        System.out.println(text);
        return myScanner.nextDouble();
    }

    private static double berechneGesamtnettopreis(int anzahl, double nettopreis) {
        return anzahl * nettopreis;
    }

    private static double berechneGesamtbruttopreis(double nettogesamtpreis, double mwst) {
        return nettogesamtpreis * (1 + mwst / 100);
    }

    private static void rechnungausgeben(String artikel, int anzahl, double nettogesamtpreis,
                                         double bruttogesamtpreis, double mwst) {
        System.out.println("\tRechnung");
        System.out.printf("\t\t Netto:  %-20s %6d %10.2f %n", artikel, anzahl, nettogesamtpreis);
        System.out.printf("\t\t Brutto: %-20s %6d %10.2f (%.1f%s)%n", artikel, anzahl, bruttogesamtpreis, mwst, "%");
    }
}