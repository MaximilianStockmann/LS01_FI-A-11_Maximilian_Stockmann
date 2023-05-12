import java.io.*;

public class CSVDateiLesenBeispiel {

    public static void main(String[] args) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("artikelliste.csv"));
            String zeile = "";

            while ( (zeile = reader.readLine()) != null ) {
                System.out.println(zeile);
            } // end of while

            reader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something went wrong with reading the file!");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}