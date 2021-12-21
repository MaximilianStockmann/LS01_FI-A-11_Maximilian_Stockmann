import java.util.Scanner;

public class Sortiere_abc {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Geben sie Zeichen 1 ein: ");
        char char1 = stdIn.next().charAt(0);
        System.out.println("Geben sie ein Zeichen 2 ein: ");
        char char2 = stdIn.next().charAt(0);
        System.out.println("Geben sie ein Zeichen 3 ein: ");
        char char3 = stdIn.next().charAt(0);

        sort(char1, char2, char3);
    }


    private static void sort(char a, char b, char c) {
        char smallest, middle, biggest;

        if (a < b) {
            if ()
        }

        if ((a < b) && (b < c)) {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        } else if ((a < b) && (c < b)) {
            System.out.println(a);
            System.out.println(c);
            System.out.println(b);
        }
    }
}
