package MainLogic;

import java.util.ArrayList;
import java.util.Locale;

//To add Actions add them as a member here and then add according entry in the executeAction method
public enum Action {
    SHOOT_PHASER("Shoot Phaser"),
    SHOOT_PHOTON_TORPEDO("Shoot Photon Torpedo"),
    LOAD_CARGO("Load Cargo"),
    CLEAN_FREIGHT_INDEX("Clean MainLogic.Freight Index"),
    PRINT_STATUS("Print Status"),
    LOAD_PHOTON_TORPEDO("Load Photon Torpedo"),
    USE_REPAIR_ANDROIDS("Use Repair Androids"),
    BROADCAST_MESSAGE("Broadcast Message"),
    PRINT_LOGBOOK("Print logbook"),
    CANCEL("Cancel");

    private final String label;

    Action(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Action valueOfLabel(String uiLabel) {
        for (Action action : values()) {
            if (action.label.equals(uiLabel)) {
                return action;
            }
        }
        return null;
    }

    /**
     * @description Checks for the type of MainLogic.Action and executes the corresponding action
     * @param spaceship {@link Spaceship} object to execute the action on
     */
    public void executeAction(Spaceship spaceship) {
        if (this == Action.SHOOT_PHASER) {
            shootPhaser(spaceship);
        } else if (this == Action.SHOOT_PHOTON_TORPEDO) {
            shootPhotonTorpedo(spaceship);
        } else if (this == Action.LOAD_CARGO) {
            loadCargo(spaceship);
        } else if (this == Action.CLEAN_FREIGHT_INDEX) {
            cleanFreightIndex(spaceship);
        } else if (this == Action.PRINT_STATUS) {
            printStatus(spaceship);
        } else if (this == Action.LOAD_PHOTON_TORPEDO) {
            loadPhotonTorpedo(spaceship);
        } else if (this == Action.USE_REPAIR_ANDROIDS) {
            useRepairAndroids(spaceship);
        } else if (this == Action.BROADCAST_MESSAGE) {
            broadcastMessage(spaceship);
        } else if (this == Action.PRINT_LOGBOOK) {
            printLogbook();
        } else if (this == Action.CANCEL) {
            cancel();
        } else { //Have to model this in chooseSpaceshipAction in MainLogic.Game class
            System.out.println("Not a valid option! Please choose again.");
        }
    }

    public void shootPhaser(Spaceship spaceship) {
        Spaceship target = Game.instance().chooseSpaceship("Please enter target ship to hit with Phaser Cannons: ");

        spaceship.firePhaserCannon(target);

        Game.instance().cont();
    }

    public void shootPhotonTorpedo(Spaceship spaceship) {
        Spaceship target = Game.instance().chooseSpaceship("Please enter target ship to hit with Photon Torpedo: ");

        spaceship.firePhotonTorpedo(target);

        Game.instance().cont();
    }

    //TODO: Change this to "manage freight" and add more options as a submenu
    public void loadCargo(Spaceship spaceship) {
        System.out.print("Please specify cargo to load (\"cancel\" to cancel): ");
        Game.instance().getMainInput().nextLine();
        String itemName = Game.instance().getMainInput().nextLine();

        if (itemName.toLowerCase(Locale.ROOT).equals("cancel")) {
            System.out.println(Console.ANSI_RESET.ansiColorCode);
            System.out.println("No cargo has been loaded.\n");
            Game.instance().cont();
            return;
        }

        System.out.print("Please specify amount (0 to cancel): ");
        int amount = Game.instance().getMainInput().nextInt();

        if (amount == 0) {
            System.out.println(Console.ANSI_RESET.ansiColorCode);
            System.out.println("No cargo has been loaded.\n");
            Game.instance().cont();
            return;
        }

        spaceship.addFreight(new Freight(itemName, amount));

        System.out.println(Console.ANSI_RESET.ansiColorCode);
        System.out.println(amount+" "+ itemName +" have been loaded successfully.");

        Game.instance().cont();
    }

    public void cleanFreightIndex(Spaceship spaceship) {
        spaceship.cleanFreightIndex();
        System.out.println(Console.ANSI_RESET.ansiColorCode);
        System.out.println("MainLogic.Freight Index has been cleaned.\n");
    }

    public void printStatus(Spaceship spaceship) {
        System.out.println(Game.ANSI_RESET);
        spaceship.printStatus();
    }

    public void loadPhotonTorpedo(Spaceship spaceship) {
        System.out.println("Load how many Photon Torpedos?");
        System.out.print("\n> ");
        int amount = Game.instance().getMainInput().nextInt();
        spaceship.loadPhotonTorpedos(amount);
    }

    public void useRepairAndroids(Spaceship spaceship) {
        ShipStructure[] shipStructures = {ShipStructure.ENERGY, ShipStructure.SHIELDS,
                ShipStructure.HULL, ShipStructure.LIFE_SUPPORT};

        System.out.println("Use how many Repair Androids?");
        System.out.print("\n> ");
        int repairAndroidsToUse = Game.instance().getMainInput().nextInt();

        for (ShipStructure shipStructure : shipStructures) {
            shipStructure.setToBeRepaired(true);
        }

        spaceship.useRepairAndroids(shipStructures, repairAndroidsToUse);

    }

    public void broadcastMessage(Spaceship spaceship) {
        System.out.print("Please enter message to broadcast (\"cancel\" to cancel): ");
        Game.instance().getMainInput().nextLine();
        String message = Game.instance().getMainInput().nextLine();

        if (message.toLowerCase(Locale.ROOT).equals("cancel")) {
            System.out.println("Message broadcast cancelled.\n");
            Game.instance().cont();
            return;
        }

        spaceship.broadcastMessage(message);

        System.out.println("Message has been broadcast: " + message);
    }

    public void printLogbook() {
        int index = 1;
        ArrayList<String> logbook = Spaceship.returnBroadcastLog();

        for (String entry : logbook) {
            System.out.println("Message " + index + ": " + entry);
            index += 1;
        }
    }

    public void cancel() {
        System.out.println("Returning to ship selection.");
        Game.instance().setReturnToShipSelection(true);
    }

    @Override
    public String toString(){
        return this.label;
    }
}
