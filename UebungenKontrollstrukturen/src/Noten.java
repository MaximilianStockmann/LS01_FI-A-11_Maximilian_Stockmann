import java.util.Scanner;

public class Noten {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Bitte geben sie eine Note als Zahl ein: ");

        byte grade = input.nextByte();
        System.out.println(eval(grade));
    }

    private static String eval(byte grade) {
        switch (grade) {
            case 1: return "Sehr gut";
            case 2: return "Gut";
            case 3: return "Befriedigend";
            case 4: return "Ausreichend";
            case 5: return "Mangelhaft";
            case 6: return "Ungenügend";
        }
        return "Error";
    }
}
