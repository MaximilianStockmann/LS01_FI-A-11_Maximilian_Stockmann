import java.util.Scanner;

class Fahrkartenautomat
{
    public static void main(String[] args)
    {
        greet();

        while (true) {
            float zuZahlenderBetrag = 0.0f;
            float rueckgabebetrag = 0.0f;

            while (zuZahlenderBetrag <= 0) {
                if (zuZahlenderBetrag < 0) {
                    return;
                }

                zuZahlenderBetrag = fahrkartenbestellungErfassen();
            }

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
    }

    private static float fahrkartenbestellungErfassen() {
        Scanner tastatur = new Scanner(System.in);
        float zuZahlenderBetrag = 0.0f;

        System.out.println("Sie können folgende Fahrkarten kaufen. Wählen sie mit Eingabe einer Nummer ihren Eintrag aus. " +
                "\nWenn sie das Programm beenden wollen, geben sie bitte \"exit\" ein.\n");

        System.out.println("(1) Einzelfahrschein Regeltarif [2,90 €]");
        System.out.println("(2) Tageskarte Regeltarif [8,60 €]");
        System.out.println("(3) Kleingruppen-Tageskarte Regeltarif AB [23,50 €]\n");

        System.out.println(" >> Eingabe: ");

        String ticketWahl = tastatur.nextLine();

        //TODO: Adjust so that prices are stored in a map
        switch(ticketWahl) {
            case "1" :
                zuZahlenderBetrag = 2.9f;
                break;
            case "2":
                zuZahlenderBetrag = 8.6f;
                break;
            case "3":
                zuZahlenderBetrag = 23.5f;
                break;
            case "exit":
                goodbye();
                return -1.0f;
            default:
                System.out.println(" >> Fehlerhafte Eingabe, bitte versuchen sie es erneut.\n");
                return 0.0f;
        }

        System.out.print(" >> Zu kaufende Tickets: ");
        byte anzahlTickets = tastatur.nextByte();

        if (anzahlTickets > 10) {
            System.out.println(" >> Bitte wählen sie eine Anzahl Tickets zwischen 1 und 10.");
            return 0.0f;
        } else if (anzahlTickets <= 0) {
            System.out.println(" >> Ticketanzahl darf nicht 0 oder negativ sein! Bitte tätigen sie eine neue Eingabe.\n");
            return 0.0f;
        }

        zuZahlenderBetrag *= anzahlTickets;

        return zuZahlenderBetrag;
    }

    private static float fahrkartenBezahlen(float zuZahlen) {
        Scanner tastatur = new Scanner(System.in);
        float eingezahlterGesamtbetrag = 0.0f;
        while(eingezahlterGesamtbetrag < zuZahlen)
        {
            System.out.printf("Noch zu zahlen: %.2f EURO\n", (zuZahlen - eingezahlterGesamtbetrag));
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
                "Wir wünschen Ihnen eine gute Fahrt.\n");
    }

    private static void goodbye() {
        System.out.println("\nAuf Wiedersehen!");
    }

    private static void greet() {
        System.out.println("Herzlich Willkommen am Fahrkartenautomat! Bitte tätigen sie ihre Eingaben.\n");
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