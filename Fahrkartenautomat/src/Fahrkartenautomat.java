import java.util.Scanner;

class Fahrkartenautomat
{
    public static void main(String[] args)
    {
       Scanner tastatur = new Scanner(System.in);
      
       double zuZahlenderBetrag; 
       double eingezahlterGesamtbetrag;
       double eingeworfeneMünze;
       double rückgabebetrag;

       System.out.print("Zu zahlender Betrag (EURO): ");
       zuZahlenderBetrag = tastatur.nextDouble();

       // Geldeinwurf
       // -----------
       eingezahlterGesamtbetrag = 0.0;
       while(eingezahlterGesamtbetrag < zuZahlenderBetrag)
       {
    	   System.out.println("Noch zu zahlen: " + (zuZahlenderBetrag - eingezahlterGesamtbetrag));
    	   System.out.print("Eingabe (mind. 5Ct, höchstens 2 Euro): ");
    	   eingeworfeneMünze = tastatur.nextDouble();
           eingezahlterGesamtbetrag += eingeworfeneMünze;
       }

       // Fahrscheinausgabe
       // -----------------
       System.out.println("\nFahrschein wird ausgegeben");
       for (int i = 0; i < 8; i++)
       {
          System.out.print("=");
          try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
       System.out.println("\n\n");

       // Rückgeldberechnung und -Ausgabe
       // -------------------------------
       rückgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
       if(rückgabebetrag > 0.0)
       {
    	   System.out.println("Der Rückgabebetrag in Höhe von " + rückgabebetrag + " EURO");
    	   System.out.println("wird in folgenden Münzen ausgezahlt:");

           while(rückgabebetrag >= 2.0) // 2 EURO-Münzen
           {
        	  System.out.println("2 EURO");
	          rückgabebetrag -= 2.0;
           }
           while(rückgabebetrag >= 1.0) // 1 EURO-Münzen
           {
        	  System.out.println("1 EURO");
	          rückgabebetrag -= 1.0;
           }
           while(rückgabebetrag >= 0.5) // 50 CENT-Münzen
           {
        	  System.out.println("50 CENT");
	          rückgabebetrag -= 0.5;
           }
           while(rückgabebetrag >= 0.2) // 20 CENT-Münzen
           {
        	  System.out.println("20 CENT");
 	          rückgabebetrag -= 0.2;
           }
           while(rückgabebetrag >= 0.1) // 10 CENT-Münzen
           {
        	  System.out.println("10 CENT");
	          rückgabebetrag -= 0.1;
           }
           while(rückgabebetrag >= 0.05)// 5 CENT-Münzen
           {
        	  System.out.println("5 CENT");
 	          rückgabebetrag -= 0.05;
           }
       }

       System.out.println("\nVergessen Sie nicht, den Fahrschein\n"+
                          "vor Fahrtantritt entwerten zu lassen!\n"+
                          "Wir wünschen Ihnen eine gute Fahrt.");
    }
}