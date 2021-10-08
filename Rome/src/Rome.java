import java.util.ArrayList;
import java.util.Scanner;

//TODO: Add support for lowercase letters
public class Rome {
    public static void main(String[] args){
        int outputNumeral;

        while (true) {
            Scanner standardScanner = new Scanner(System.in);
            System.out.println("Please enter a roman numeral(uppercase only): ");

            String romanNumeral = standardScanner.nextLine();

            System.out.println(eval(romanNumeral));
        }
    }

    //Evaluates a roman numeral and returns its decimal value. In case of invalid input returns 0.
    private static int eval(String romanNumeral) {

        ArrayList<Integer> convertedNumeral = convertCharacters(romanNumeral);

        int finalSum = 0;
        int loopIndex = 0;
        int nextDigit;
        int arrayListSize = convertedNumeral.size();

        for (int digit : convertedNumeral) {

            //Checks whether ArrayList has ended
            if (loopIndex+1 >= arrayListSize) {
                finalSum += digit;
                return finalSum;
            }

            nextDigit = convertedNumeral.get(loopIndex+1);

            if (!(loopIndex+3 >= arrayListSize)) {
                int nextNextDigit = convertedNumeral.get(loopIndex+2);
                int thirdNextDigit = convertedNumeral.get(loopIndex+3);

                if (digit == nextDigit && nextDigit == nextNextDigit && nextNextDigit == thirdNextDigit) {
                    System.out.println("Invalid numeral");
                    return 0;
                }
            }

            //Checks for subtraction
            if (digit <= nextDigit) {

                //TODO: Currently XXX doesn't work, find way to make XXL invalid, but XXX valid
                //Checks subtraction rules for I, X and C numerals.
                if ((digit == 1 || digit == 10 || digit == 100) &&
                        (((nextDigit != digit*5) && (nextDigit != digit*10)) || (digit == nextDigit)) ){
                    System.out.println("Invalid numeral");
                    return 0;
                }

                digit = nextDigit - digit;
                finalSum -= nextDigit;

            //Checks whether V, L and D numerals occur next to each other.
            } else if ((digit == 5 || digit == 50 || digit == 500) && (nextDigit == digit)) {
                System.out.println("Invalid numeral");
                return 0;
            }


            finalSum += digit;

            loopIndex++;
        }
        return finalSum;
    }

    //Evaluates a character of a roman numeral to its corresponding integer value
    private static int evaluateCharacter(char singleNumeral) {
        return switch (singleNumeral) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    /*Converts each individual character of the numeral to its corresponding integer value and returns
      these in an ArrayList*/
    private static ArrayList<Integer> convertCharacters(String romanNumeral) {
        ArrayList<Integer> convertedNumeral = new ArrayList<>();

        for (char character: romanNumeral.toCharArray()) {
            convertedNumeral.add(evaluateCharacter(character));
        }
        return convertedNumeral;
    }
}
