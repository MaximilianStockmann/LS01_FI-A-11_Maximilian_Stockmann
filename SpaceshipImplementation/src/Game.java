import java.util.*;

//TODO: ADD GAME GRID

public class Game {
    private final int UI_ARRAY_REP_ADJUSTMENT = 1;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static Game game = null;

    private final Scanner mainInput;

    private Spaceship currentSpaceshipSelection;
    private final ArrayList<Spaceship> spaceshipList;

    /**********************************************
     GETTERS
     **********************************************/
    public Spaceship getCurrentSpaceshipSelection() {
        return currentSpaceshipSelection;
    }

    public Scanner getMainInput() {
        return mainInput;
    }

    /**********************************************
     CONSTRUCTOR
     **********************************************/
    private Game() {
        mainInput = new Scanner(System.in);
        spaceshipList = new ArrayList<>();

        //Spaceship enterprise = new Spaceship("Enterprise", 100, 100, 100);
        //Spaceship borg = new Spaceship("Borg", 100, 150, 250);

        Spaceship klingonShip = new Spaceship("ISK Hegh'ta", 100, 100,
                100, 100, 2);

        Spaceship romulanShip = new Spaceship("IRW Khazara", 70, 76,
                80, 100, 7);

        klingonShip.addFreight(new Freight("Ferengi snail juice", 200));
        klingonShip.addFreight(new Freight("Bat'leth klingon sword", 200));

        romulanShip.addFreight(new Freight("Borg scrap", 5));
        romulanShip.addFreight(new Freight("Red matter", 2));
        romulanShip.addFreight(new Freight("Plasma weapon", 50));
        romulanShip.addFreight(new Freight("Photon Torpedos", 2));
        romulanShip.addFreight(new Freight("Photon Torpedos", 3));

        spaceshipList.add(klingonShip);
        spaceshipList.add(romulanShip);
    }

    /*+++++++++++++++++++++++++++++++++++++++++++++
     SINGLETON INSTANCE RETURN
     ++++++++++++++++++++++++++++++++++++++++++++*/

    /**
     * @return Singleton instance of the game Class
     */
    public static synchronized Game instance() {
        if (game == null)
            game = new Game();

        return game;
    }

    /*+++++++++++++++++++++++++++++++++++++++++++++
     MAIN CONTROL METHODS
     ++++++++++++++++++++++++++++++++++++++++++++*/
    public static void main(String[] args) {
        game = Game.instance();

        //main game loop
        while (true) {
            game.menu();
        }
    }

    public static void endGame() {
        System.out.println("All ships have been destroyed! Game over!");
        System.exit(0);
    }

    /*+++++++++++++++++++++++++++++++++++++++++++++
     MENU METHODS
     ++++++++++++++++++++++++++++++++++++++++++++*/
    private void menu(){
        Game.instance().currentSpaceshipSelection = Game.instance().chooseSpaceship("\nPlease select ship from list by choosing it's number:");
        System.out.print(ANSI_RESET);

        Game.instance().chooseSpaceshipAction("What should  the "+ Game.instance().currentSpaceshipSelection.getName() + " do?");
        System.out.print(ANSI_RESET);
    }

    //TODO: Refactor chooseSpaceship() and chooseSpaceshipAction() into generalized choice interface
    public Spaceship chooseSpaceship(String inputPrompt) {
        Spaceship choice;

        boolean gameOverFlag = true;
        for (Spaceship spaceship : spaceshipList) {
            if (!spaceship.getDestructionStatus()) {
                gameOverFlag = false;
                break;
            }
        }

        if (gameOverFlag)
            endGame();

        while (true) {
            System.out.println(ANSI_GREEN + inputPrompt + ANSI_CYAN);

            printSelectionList(Game.instance().spaceshipList);

            System.out.print(ANSI_GREEN);

            System.out.print("\n> ");

            int shipChoice = Game.instance().mainInput.nextInt();
            if (shipChoice >= UI_ARRAY_REP_ADJUSTMENT && shipChoice <= spaceshipList.size()) {
                choice = Game.instance().spaceshipList.get(shipChoice - UI_ARRAY_REP_ADJUSTMENT);

                if (!choice.getDestructionStatus()) {
                    return choice;
                } else {
                    System.out.print(ANSI_RESET);
                    System.out.println(choice.getName()+" has been destroyed! Please choose another ship.");
                }

            } else {
                System.out.print(ANSI_RESET);
                System.out.println("Not a valid option! Please choose again.");
            }
        }
    }

    //This behaviour needs to interface with the actionList of the Spaceship class somehow
    private void chooseSpaceshipAction(String inputPrompt) {
        while(true) {
            System.out.println(ANSI_GREEN + inputPrompt + ANSI_CYAN);

            printSelectionList(new ArrayList<Action>(Arrays.asList(Action.values())));

            System.out.print(ANSI_GREEN);
            System.out.print("\n> ");
            int actionChoice = Game.instance().mainInput.nextInt();

            Action spaceshipActionToTake = Action.values()[actionChoice-UI_ARRAY_REP_ADJUSTMENT];
            spaceshipActionToTake.executeAction(Game.instance().currentSpaceshipSelection);
        }
    }

//    private void printMenuOptions(ArrayList options) {
//        System.out.println(ANSI_GREEN + inputPrompt + ANSI_CYAN);
//        for (String choice : game.currentSpaceshipSelection.actionList) {
//            System.out.print(game.currentSpaceshipSelection.actionList.indexOf(choice) + UI_ARRAY_REP_ADJUSTMENT + " ");
//            System.out.println(choice);
//        }
//    }

    //TODO: There's still weirdness with the buffer here, fix
    public void cont() {
        System.out.println(Console.ANSI_RESET.ansiColorCode);
        System.out.print("Press enter to continue.");

        String readString = Game.instance().mainInput.nextLine();
        while(readString!=null) {
            if (Game.instance().mainInput.hasNextLine()) {
                break;
            } else {
                readString = null;
            }
        }
    }

    /**
     * @description Prints a numbered version of the parameter list into the console
     * @param list List of Arbitrary Objects, handled internally as Strings, make sure {@link String#toString()}
     *             method of list objects is overriden.
     * @param <T> Type of Element in the ArrayList
     */
    private <T> void printSelectionList(ArrayList<T> list) {
        for (T currentElement : list) {
            System.out.print(list.indexOf(currentElement) + UI_ARRAY_REP_ADJUSTMENT + " ");
            System.out.println(currentElement);
        }
    }

    private void putColorInConsole(String color) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";

        //Finish this
        switch (color){
            case "White" :
                System.out.println(ANSI_RESET);break;
            case "Black" :
                System.out.println(ANSI_BLACK);break;
            case "Red" :
                System.out.println(ANSI_RED);break;
        }

    }

}
