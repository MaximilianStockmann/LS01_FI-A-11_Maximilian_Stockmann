import java.lang.reflect.Array;
import java.util.*;

public class Twist {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            String inputString = input.next();
            String twistedSentence = "";

            ArrayList<String> elements = splitInput(inputString);

            for (String e : elements) {
                ArrayList word = convertToArrayList(e);

                word = twist(word);

                String output = String.join("", word);
                twistedSentence += output;
            }
            System.out.println(twistedSentence);
        }
    }

    public static ArrayList twist(ArrayList<String> word) {
        return fisherYates(word);
    }

    public static ArrayList<String> convertToArrayList(String word) {
        List str = Arrays.asList(word.split(""));

        ArrayList<String> result = new ArrayList<String>(str);

        return result;
    }

    private static ArrayList<String> splitInput(String input) {

        List str = Arrays.asList(input.split(" "));
        ArrayList<String> result = new ArrayList<String>(str);

        return result;
    }

    private static ArrayList<String> fisherYates(ArrayList<String> input) {
        Random r = new Random();

        for (int i = input.size()-2; i > 0; i--) {
            int z = r.nextInt(i) + 1;
            Collections.swap(input, i, z);
        }
        return input;
    }
}
