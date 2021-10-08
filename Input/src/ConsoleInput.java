import java.util.Scanner;

public class ConsoleInput {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String name;
        int alter;
        float groesse;
        char geschlecht;

        System.out.print("Geben sie ihren Namen ein: ");
        name = stdIn.next();
        System.out.println(name);

        System.out.print("Geben sie ihr Alter ein: ");
        alter = stdIn.nextInt();
        System.out.println(alter);

        System.out.print("Geben sie ihre Größe ein: ");
        groesse = stdIn.nextFloat();
        System.out.println(groesse);

        System.out.println("Geben sie ihr Geschlecht ein: ");
        geschlecht = stdIn.next().charAt(0);
        System.out.println(geschlecht);

        stdIn.close();
    }
}
