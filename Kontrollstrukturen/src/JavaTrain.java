public class JavaTrain {
    public static void main(String[] args) {
        int fahrzeit = 0;
        char haltinSpandau = 'n';
        char richtungHamburg = 'n';
        char haltInStendal = 'j';
        char endetIn = 'h';

        fahrzeit += 8;

        if (haltinSpandau == 'j') {
            fahrzeit += 2;
        }

        if (richtungHamburg == 'j') {
            fahrzeit += 96;
            System.out.println("Sie erreichen Hamburg nach " + fahrzeit + " Minuten.");
        }

        if (haltInStendal == 'j') {
            fahrzeit += 16;
        } else {
            fahrzeit += 6;
        }

        if (endetIn == 'w') {
            fahrzeit += 29;
            System.out.println("Sie erreichen Wolfsburg nach " + fahrzeit + " Minuten.");
        } else if (endetIn == 'b') {
            fahrzeit += 50;
            System.out.println("Sie erreichen Braunschweig nach " + fahrzeit + " Minuten.");
        } else if (endetIn == 'h') {
            fahrzeit += 50;
            System.out.println("Sie erreichen Hannover nach " + fahrzeit + " Minuten.");
        }
    }
}
