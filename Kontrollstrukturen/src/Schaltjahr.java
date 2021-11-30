import java.util.Scanner;

public class Schaltjahr {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("Geben sie ein Jahr ein um zu prüfen, ob es ein Schaltjahr ist: ");
        int jahr = stdIn.nextInt();

        if (istSchaltjahr(jahr)) {
            System.out.printf("Das Jahr %d ist ein Schaltjahr!", jahr);
        } else {
            System.out.printf("Das Jahr %d ist kein Schaltjahr!", jahr);
        }
    }

    private static boolean istSchaltjahr(int jahr) {

        if (jahr % 4 == 0) {
            if (jahr % 100 == 0 && jahr >= 1582) {
                if (jahr % 400 == 0 && jahr >= 1582) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

}
