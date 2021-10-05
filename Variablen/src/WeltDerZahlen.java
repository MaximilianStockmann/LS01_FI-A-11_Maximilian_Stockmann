public class WeltDerZahlen {
    public static void main(String[] args) {
    /*  *********************************************************

             Zuerst werden die Variablen mit den Werten festgelegt!

        *********************************************************** */
        // Im Internet gefunden ?
        // Die Anzahl der Planeten in unserem Sonnesystem
        int anzahlPlaneten = 8;

        // Anzahl der Sterne in unserer Milchstraße
        long anzahlSterne = 100000000000L;

        // Wie viele Einwohner hat Berlin?
        int bewohnerBerlin = 3600000;

        // Wie alt bist du? Wie viele Tage sind das?
        short alterTage = 8595;

        // Wie viel wiegt das schwerste Tier der Welt?
        // Schreiben Sie das Gewicht in Kilogramm auf!
        short gewichtKilogramm = 4000;

        // Schreiben Sie auf, wie viele km² das größte Land er Erde hat?
        int flaecheGroessteLand = 17098242;

        // Wie groß ist das kleinste Land der Erde?
        float flaecheKleinsteLand = 0.44f;

    /*  *********************************************************

         Programmieren Sie jetzt die Ausgaben der Werte in den Variablen

    *********************************************************** */

        System.out.printf("Anzahl der Planeten: %d\n", anzahlPlaneten);
        System.out.printf("Anzahl der Sterne: %d\n", anzahlSterne);
        System.out.printf("Einwohner von Berlin: %d\n", bewohnerBerlin);
        System.out.printf("Ich bin %d Tage alt\n", alterTage);
        System.out.printf("Das schwerste Tier der Welt wiegt %d kg\n", gewichtKilogramm);
        System.out.printf("Das groesste Land der Welt ist %d Quadratkilometer gross\n", flaecheGroessteLand);
        System.out.printf("Das kleinste Land der Welt ist %.2f Quadratkilometer gross\n", flaecheKleinsteLand);
        System.out.println(" *******  Ende des Programms  ******* ");
    }
}
