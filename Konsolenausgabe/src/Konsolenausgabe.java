public class Konsolenausgabe {
    public static void main(String[] args) {
        //Code für Aufgabe 1
        System.out.printf("%s", "\"Das ist ein Beispielsatz.\"\n");
        System.out.printf("%s" + "%s" + "%s", "Dies ist ein ", "weiterer Beispielsatz.", "\n");

        //Das ist ein Kommentar

        //Code für Aufgabe 2
        String stars = "*************";

        System.out.printf("%7.1s\n", stars);
        System.out.printf("%8.3s\n", stars);
        System.out.printf("%9.5s\n", stars);
        System.out.printf("%10.7s\n", stars);
        System.out.printf("%11.9s\n", stars);
        System.out.printf("%12.11s\n", stars);
        System.out.printf("%13.13s\n", stars);
        System.out.printf("%8.3s\n", stars);
        System.out.printf("%8.3s\n", stars);

        //Code für Aufgabe 3
        double zahl1 = 22.4234234;
        double zahl2 = 111.2222;
        double zahl3 = 4.0;
        double zahl4 = 1000000.551;
        double zahl5 = 97.34;

        System.out.printf("%.2f\n", zahl1);
        System.out.printf("%.2f\n", zahl2);
        System.out.printf("%.2f\n", zahl3);
        System.out.printf("%.2f\n", zahl4);
        System.out.printf("%.2f\n", zahl5);
    }
}
