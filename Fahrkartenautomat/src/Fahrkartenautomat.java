import java.util.Scanner;

class Fahrkartenautomat
{
    public static void main(String[] args)
    {
       float zuZahlenderBetrag;
       float rueckgabebetrag;

       zuZahlenderBetrag = fahrkartenbestellungErfassen();

       // Geldeinwurf
       // -----------
       rueckgabebetrag = fahrkartenBezahlen(zuZahlenderBetrag);

       // Fahrscheinausgabe
       // -----------------
        fahrkartenAusgeben();

       // Rückgeldberechnung und -Ausgabe
       // -------------------------------
        rueckgeldAusgeben(rueckgabebetrag);
    }

    private static float fahrkartenbestellungErfassen() {
        Scanner tastatur = new Scanner(System.in);

        System.out.print("Zu zahlender Betrag (EURO): ");
        float zuZahlenderBetrag = tastatur.nextFloat();

        System.out.print("Zu kaufende Tickets: ");
        byte anzahlTickets = tastatur.nextByte();

        zuZahlenderBetrag *= anzahlTickets;

        return zuZahlenderBetrag;
    }

    private static float fahrkartenBezahlen(float zuZahlen) {
        Scanner tastatur = new Scanner(System.in);
        float eingezahlterGesamtbetrag = 0.0f;
        while(eingezahlterGesamtbetrag < zuZahlen)
        {
            System.out.printf("Noch zu zahlen %.2f EURO\n", (zuZahlen - eingezahlterGesamtbetrag));
            System.out.print("Eingabe (mind. 5Ct, höchstens 2 Euro): ");
            float eingeworfeneMuenze = tastatur.nextFloat();
            eingezahlterGesamtbetrag += eingeworfeneMuenze;
        }

        return eingezahlterGesamtbetrag - zuZahlen;
    }

    private static void fahrkartenAusgeben() {
        System.out.println("\nFahrschein wird ausgegeben");
        warte(250);
        System.out.println("\n\n");
    }

    private static void rueckgeldAusgeben(float rueckgabebetrag) {
        if(rueckgabebetrag > 0.0)
        {
            rueckgabebetrag = round(rueckgabebetrag);
            System.out.printf("Der Rückgabebetrag in Höhe von %.2f EURO\n", rueckgabebetrag);
            System.out.println("wird in folgenden Münzen ausgezahlt:");

            while(rueckgabebetrag >= 2.0f) // 2 EURO-Münzen
            {
                muenzeAusgeben(2, "EURO");
                rueckgabebetrag -= 2.0f;
                rueckgabebetrag = round(rueckgabebetrag);
            }
            while(rueckgabebetrag >= 1.0f) // 1 EURO-Münzen
            {
                muenzeAusgeben(1, "EURO");
                rueckgabebetrag -= 1.0f;
                rueckgabebetrag = round(rueckgabebetrag);
            }
            while(rueckgabebetrag >= 0.5f) // 50 CENT-Münzen
            {
                muenzeAusgeben(50, "CENT");
                rueckgabebetrag -= 0.5f;
                rueckgabebetrag = round(rueckgabebetrag);
            }
            while(rueckgabebetrag >= 0.20f) // 20 CENT-Münzen
            {
                muenzeAusgeben(20, "CENT");
                rueckgabebetrag -= 0.2f;
                rueckgabebetrag = round(rueckgabebetrag);
            }
            while(rueckgabebetrag >= 0.1f) // 10 CENT-Münzen
            {
                muenzeAusgeben(10, "CENT");
                rueckgabebetrag -= 0.1f;
                rueckgabebetrag = round(rueckgabebetrag);
            }
            while(rueckgabebetrag >= 0.05f)// 5 CENT-Münzen
            {
                muenzeAusgeben(5, "CENT");
                rueckgabebetrag -= 0.05f;
                rueckgabebetrag = round(rueckgabebetrag);
            }
            while(rueckgabebetrag >= 0.02f)// 5 CENT-Münzen
            {
                muenzeAusgeben(2, "CENT");
                rueckgabebetrag -= 0.02f;
                rueckgabebetrag = round(rueckgabebetrag);
            }
            while(rueckgabebetrag >= 0.01f)// 5 CENT-Münzen
            {
                muenzeAusgeben(1, "CENT");
                rueckgabebetrag -= 0.01f;
                rueckgabebetrag = round(rueckgabebetrag);
            }
        }

        System.out.println("\nVergessen Sie nicht, den Fahrschein\n" +
                "vor Fahrtantritt entwerten zu lassen!\n"+
                "Wir wünschen Ihnen eine gute Fahrt.");
    }

    private static float round(float toRound) {
        return Math.round(toRound*100f)/100f;
    }

    private static void muenzeAusgeben(int wert, String einheit) {
        System.out.printf("%d %s\n", wert, einheit);
    }

    private static void warte(int millisekunden) {
        for (int i = 0; i < 8; i++)
        {
            System.out.print("=");
            try {
                Thread.sleep(millisekunden);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}