import java.util.Scanner;

public class Rome {
    public static void main(String[] args) {
        while (true) {
            Scanner standardScanner = new Scanner(System.in);

            System.out.print("Bitte geben sie eine einzelne römische Ziffer ein: ");

            char numeral = standardScanner.next().charAt(0);
            numeral = Character.toLowerCase(numeral);

            if (evalNumeral(numeral) == 0) {
                System.out.println("Das is keine römische Ziffer.");
            } else System.out.println(evalNumeral(numeral));
        }
    }

    public static int evalNumeral(char numeral) {
        switch (numeral) {
            case 'i' : return 1;
            case 'v' : return 5;
            case 'x' : return 10;
            case 'l' : return 50;
            case 'c' : return 100;
            case 'd' : return 500;
            case 'm' : return 1000;
        }
        return 0;
    }
}
