package eingabeAusgabe;

/** Variablen.java
 Ergaenzen Sie nach jedem Kommentar jeweils den Quellcode.
 @author Maximlian Stockmann
 @version
 */
public class Variablen {
    public static void main(String [] args){
    /* 1. Ein Zaehler soll die Programmdurchlaeufe zaehlen.
          Vereinbaren Sie eine geeignete Variable */
        int numberOfRuns;

    /* 2. Weisen Sie dem Zaehler den Wert 25 zu
          und geben Sie ihn auf dem Bildschirm aus.*/
        numberOfRuns = 25;
        System.out.printf("%d\n", numberOfRuns);

    /* 3. Durch die Eingabe eines Buchstabens soll der Menuepunkt
          eines Programms ausgewaehlt werden.
          Vereinbaren Sie eine geeignete Variable */
        char menuSelection;

    /* 4. Weisen Sie dem Buchstaben den Wert 'C' zu
          und geben Sie ihn auf dem Bildschirm aus.*/
        menuSelection = 'C';

    /* 5. Fuer eine genaue astronomische Berechnung sind grosse Zahlenwerte
          notwendig.
          Vereinbaren Sie eine geeignete Variable */
        long astronomicValue;

    /* 6. Weisen Sie der Zahl den Wert der Lichtgeschwindigkeit zu
          und geben Sie sie auf dem Bildschirm aus.*/
        astronomicValue = 300000;
        System.out.printf("Das Licht bewegt sich mit %d km/s\n", astronomicValue);

    /* 7. Sieben Personen gruenden einen Verein. Fuer eine Vereinsverwaltung
          soll die Anzahl der Mitglieder erfasst werden.
          Vereinbaren Sie eine geeignete Variable und initialisieren sie
          diese sinnvoll.*/
        byte mitgliederanzahl = 7;

        /* 8. Geben Sie die Anzahl der Mitglieder auf dem Bildschirm aus.*/
        System.out.printf("Der Verein hat %d Mitglieder\n", mitgliederanzahl);

    /* 9. Fuer eine Berechnung wird die elektrische Elementarladung benoetigt.
          Vereinbaren Sie eine geeignete Variable und geben Sie sie auf
          dem Bildschirm aus.*/
        double elementarladung = 1.602 * 10e-19;
        System.out.printf("Die Elementarladung hat den folgenden Wert: %g Ampersekunden\n", elementarladung);

    /*10. Ein Buchhaltungsprogramm soll festhalten, ob eine Zahlung erfolgt ist.
          Vereinbaren Sie eine geeignete Variable. */
        boolean paymentReceived;

    /*11. Die Zahlung ist erfolgt.
          Weisen Sie der Variable den entsprechenden Wert zu
          und geben Sie die Variable auf dem Bildschirm aus.*/
        paymentReceived = true;
        System.out.printf("%b\n", paymentReceived);

    }//main
}// Variablen