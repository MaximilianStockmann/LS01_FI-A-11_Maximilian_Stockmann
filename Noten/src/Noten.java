import java.util.Scanner;

public class Noten {
    public static void main(String args[]) {
        while (true) {
            System.out.println("Bitte geben sie eine Note ein die sie umwandeln möchten: ");

            Scanner standardScanner = new Scanner(System.in);
            int inputNumber = standardScanner.nextInt();

            if (evalNumber(inputNumber) == "0") { System.out.println("Keine gültige Schulnote."); }
            else System.out.println(evalNumber(inputNumber));
        }
    }

    public static String evalNumber(int inputNumber) {
        switch(inputNumber) {
            case 1 : return "Sehr gut";
            case 2 : return "Gut";
            case 3 : return "Befriedigend";
            case 4 : return "ausreichend";
            case 5 : return "Mangelhaft";
            case 6 : return "ungenügend";
        }
        return "0";
    }
}
