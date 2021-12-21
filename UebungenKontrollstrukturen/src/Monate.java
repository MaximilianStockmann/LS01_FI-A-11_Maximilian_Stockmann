import java.util.Scanner;

public class Monate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        byte month = input.nextByte();
        System.out.println(eval(month));
    }

    private static String eval(byte month) {
        switch (month) {
            case 1: return "Januar";
            case 2: return "Februar";
            case 3: return "März";
            case 4: return "April";
            case 5: return "Mai";
            case 6: return "Juni";
            case 7: return "Juli";
            case 8: return "August";
            case 9: return "September";
            case 10: return "Oktober";
            case 11: return "November";
            case 12: return "Dezember";
        }
        return "Error";
    }
}
