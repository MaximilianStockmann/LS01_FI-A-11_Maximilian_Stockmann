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

        Spaceship romulanShip = new Spaceship("IRW Khazara", 100, 100,
                100, 100, 2);

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

    /**********************************************
     SINGLETON INSTANCE RETURN
     **********************************************/
    public static synchronized Game instance() {
        if (game == null)
            game = new Game();

        return game;
    }

    /**********************************************
     MAIN METHOD
     **********************************************/
    public static void main(String[] args) {
        game = Game.instance();
        Grid gameGrid = Grid.instance();

        /*
        SpaceObject test = gameGrid.test(game.SpaceshipList.get(0));

        if (test.getClass() == Spaceship.class)
            test.printStatus();
        */

        //main game loop
        while (true) {
            game.menu();

            //game.currentSelection.firePhaserCannon(game.SpaceshipList.get(0));
        }
    }

    /**********************************************
     MENU METHODS
     *********************************************/
    private void menu(){
        game.currentSpaceshipSelection = game.chooseSpaceship("\nPlease select ship from list by choosing it's number:");
        System.out.print(ANSI_RESET);

        game.currentSpaceshipSelection.printStatus();

        game.chooseSpaceshipAction("What should  the "+ game.currentSpaceshipSelection.getName() + " do?");
        System.out.print(ANSI_RESET);
    }

    //TODO: Refactor chooseSpaceship() and chooseSpaceshipAction() into generalized choice interface
    public Spaceship chooseSpaceship(String inputPrompt) {
        Spaceship choice;

        //TODO: If all ships are destroyed you can't get out of this menu, add another return
        while (true) {
            System.out.println(ANSI_GREEN + inputPrompt + ANSI_CYAN);

            printSelectionList(game.spaceshipList);

            System.out.print(ANSI_GREEN);

            System.out.print("\n> ");

            int shipChoice = game.mainInput.nextInt();
            if (shipChoice >= UI_ARRAY_REP_ADJUSTMENT && shipChoice <= spaceshipList.size()) {
                choice = game.spaceshipList.get(shipChoice - UI_ARRAY_REP_ADJUSTMENT);

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

            //printSelectionList(game.currentSpaceshipSelection.actionList);
            printActionList();

            System.out.print(ANSI_GREEN);

            System.out.print("\n> ");

            int actionChoice = game.mainInput.nextInt();

            String spaceshipActionToTake = game.currentSpaceshipSelection.actionList.get(actionChoice-UI_ARRAY_REP_ADJUSTMENT);

            Action.valueOfLabel(spaceshipActionToTake).executeAction(game.currentSpaceshipSelection);

            if (spaceshipActionToTake.equals(Action.SHOOT_PHASER.uiLabel)) {
                Spaceship target = game.chooseSpaceship("Please enter target ship to hit with Phaser Cannons: ");

                game.currentSpaceshipSelection.firePhaserCannon(target);

                game.cont();
            } else if (spaceshipActionToTake.equals(Action.SHOOT_PHOTON_TORPEDO.uiLabel)) {
                Spaceship target = game.chooseSpaceship("Please enter target ship to hit with Photon Torpedo: ");

                game.currentSpaceshipSelection.firePhotonTorpedo(target);

                game.cont();
            } else if (spaceshipActionToTake.equals(Action.LOAD_CARGO.uiLabel)) {
                System.out.print("Please specify cargo to load (\"cancel\" to cancel): ");
                mainInput.nextLine();
                String itemName = game.mainInput.nextLine();

                if (itemName.toLowerCase(Locale.ROOT).equals("cancel")) {
                    System.out.println("No cargo has been loaded.\n");
                    game.cont();
                    return;
                }

                System.out.print("Please specify amount: ");
                int amount = game.mainInput.nextInt();

                //TODO: Add option to cancel out of amount selection

                game.currentSpaceshipSelection.addFreight(new Freight(itemName, amount));

                System.out.println("\n"+ amount+" "+ itemName +" have been loaded successfully.");

                game.cont();
            } else if (spaceshipActionToTake.equals(Action.PRINT_STATUS.uiLabel)) {
                System.out.println(ANSI_RESET);
                game.currentSpaceshipSelection.printStatus();
            } else if (spaceshipActionToTake.equals(Action.LOAD_PHOTON_TORPEDO.uiLabel)) {
                System.out.println("Load how many Photon Torpedos?");
                int amount = mainInput.nextInt();
                game.currentSpaceshipSelection.loadPhotonTorpedos(amount);
            } else if (spaceshipActionToTake.equals(Action.CANCEL.uiLabel)) {
                System.out.println("Returning to ship selection.");
                return;
            } else {
                System.out.println("Not a valid option! Please choose again.");
            }
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
        System.out.print("Press enter to continue.");

        String readString = game.mainInput.nextLine();
        while(readString!=null) {
            if (game.mainInput.hasNextLine()) {
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
     * @param <T>
     */
    private <T> void printSelectionList(ArrayList<T> list) {
        for (T currentElement : list) {
            System.out.print(list.indexOf(currentElement) + UI_ARRAY_REP_ADJUSTMENT + " ");
            System.out.println(currentElement);
        }
    }

    private void printActionList() {
        for (Action action : Action.values()){
            System.out.print(action.ordinal()+UI_ARRAY_REP_ADJUSTMENT + " ");
            System.out.println(action.uiLabel);
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

//How to do this?
/*    private <T> T choose(ArrayList<T> choices, T result) {
        if (choices.get(0) == Spaceship.class)
            chooseShip("\nPlease select ship from list by choosing it's number:");
        else if (choices.get(0) == String.class) {

        }

        return result;
    }*/

}
