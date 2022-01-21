import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        int replace, i = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a number to replace: ");
        replace = input.nextInt();

        while (i < 100) {
            //Formatting
            if (i % 10 == 0 && i != 0) System.out.println();

            //Print the numbers
            if (( i % replace == 0 && i != 0) || digitSum(i) == replace || contains(i, replace)) {
                System.out.print("*");
                if (i >= 10) System.out.print(" ");
            } else System.out.print(i);

            //Formatting
            if (i < 10) System.out.print(" ");
            System.out.print(" ");

            i++;
        }
    }

    private static int digitSum(int n) {
        int digit, sum = 0;

        while (n != 0) {
            digit = n % 10;
            sum += digit;
            n = n/10;
        }

        return sum;
    }

    private static boolean contains(int n, int c) {
        while(n > 0)
        {
            if(n % 10 == c)
                break;
            n=n/10;
        }
        return (n>0);
    }
}
