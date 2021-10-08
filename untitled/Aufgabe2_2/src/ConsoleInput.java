import java.util.Scanner;

public class ConsoleInput {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String residence;
        boolean birthPlaceIsResidence;
        byte pupilsInClass;

        System.out.println("Willkommen! Sagen sie, wo wohnen sie denn? ");
        residence = stdIn.next();
        System.out.printf("Oh, wow! Es muss schön sein in %s zu wohnen! ", residence);

        System.out.println("Aber noch mal eine andere Frage: Sind sie denn auch dort geboren? (true/false)");
        birthPlaceIsResidence = stdIn.nextBoolean();
        System.out.printf("%b", birthPlaceIsResidence);

        System.out.println("\nUnd wie viele Schüler sind in ihrer Klasse?");
        pupilsInClass = stdIn.nextByte();
        System.out.printf("Ah, es sind also %d Schüler in ihrer Klasse!", pupilsInClass);
    }
}
