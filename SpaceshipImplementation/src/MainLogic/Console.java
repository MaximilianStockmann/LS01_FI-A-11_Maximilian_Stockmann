package MainLogic;

import java.io.IOException;

public enum Console {
    ANSI_RESET("\u001B[0m"),
    ANSI_BLACK("\u001B[30m"),
    ANSI_RED("\u001B[31m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLUE("\u001B[34m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_CYAN("\u001B[36m"),
    ANSI_WHITE("\u001B[37m"),
    CLEAR("\033[H\033[2J");

    public final String ansiColorCode;

    Console (String ansiColorCode) {
        this.ansiColorCode = ansiColorCode;
    }

    public static Console valueOfColorCode(String ansiColorCode) {
        for (Console console : values()) {
            if (console.ansiColorCode.equals(ansiColorCode)) {
                return console;
            }
        }
        return null;
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {}
    }
}
