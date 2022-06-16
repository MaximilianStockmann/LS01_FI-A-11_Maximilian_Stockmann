import java.util.ArrayList;
import java.util.Locale;

//To add Actions add them as a member here and then add according entry in the executeAction method
public enum Action {
    SHOOT_PHASER("Shoot Phaser"),
    SHOOT_PHOTON_TORPEDO("Shoot Photon Torpedo"),
    LOAD_CARGO("Load Cargo"),
    CLEAN_FREIGHT_INDEX("Clean Freight Index"),
    PRINT_STATUS("Print Status"),
    LOAD_PHOTON_TORPEDO("Load Photon Torpedo"),
    USE_REPAIR_ANDROIDS("Use Repair Androids"),
    BROADCAST_MESSAGE("Broadcast Message"),
    PRINT_LOGBOOK("Print logbook"),
    CANCEL("Cancel");

    public final String label;

    Action(String label) {
        this.label = label;
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
     * @description
     * @param spaceship
     */
    public void executeAction(Spaceship spaceship) {
        if (this == Action.SHOOT_PHASER) {
            Spaceship target = Game.instance().chooseSpaceship("Please enter target ship to hit with Phaser Cannons: ");

            spaceship.firePhaserCannon(target);

            Game.instance().cont();
        } else if (this == Action.SHOOT_PHOTON_TORPEDO) {
            Spaceship target = Game.instance().chooseSpaceship("Please enter target ship to hit with Photon Torpedo: ");

            spaceship.firePhotonTorpedo(target);

            Game.instance().cont();
        } else if (this == Action.LOAD_CARGO) {
            System.out.print("Please specify cargo to load (\"cancel\" to cancel): ");
            Game.instance().getMainInput().nextLine();
            String itemName = Game.instance().getMainInput().nextLine();

            if (itemName.toLowerCase(Locale.ROOT).equals("cancel")) {
                System.out.println(Console.ANSI_RESET.ansiColorCode);
                System.out.println("No cargo has been loaded.\n");
                Game.instance().cont();
                return;
            }

            System.out.print("Please specify amount: ");
            int amount = Game.instance().getMainInput().nextInt();

            //TODO: Add option to cancel out of amount selection

            spaceship.addFreight(new Freight(itemName, amount));

            System.out.println(Console.ANSI_RESET.ansiColorCode);
            System.out.println(amount+" "+ itemName +" have been loaded successfully.");

            Game.instance().cont();
        } else if (this == Action.CLEAN_FREIGHT_INDEX) {

            spaceship.cleanFreightIndex();
            System.out.println(Console.ANSI_RESET.ansiColorCode);
            System.out.println("Freight Index has been cleaned.\n");

        } else if (this == Action.PRINT_STATUS) {

            System.out.println(Game.ANSI_RESET);
            spaceship.printStatus();

        } else if (this == Action.LOAD_PHOTON_TORPEDO) {

            System.out.println("Load how many Photon Torpedos?");
            System.out.print("\n> ");
            int amount = Game.instance().getMainInput().nextInt();
            spaceship.loadPhotonTorpedos(amount);

        } else if (this == Action.USE_REPAIR_ANDROIDS) {

            ShipStructure[] shipStructures = {ShipStructure.ENERGY, ShipStructure.SHIELDS,
                    ShipStructure.HULL, ShipStructure.LIFE_SUPPORT};

            System.out.println("Use how many Repair Androids?");
            System.out.print("\n> ");
            int repairAndroidsToUse = Game.instance().getMainInput().nextInt();

            for (ShipStructure shipStructure : shipStructures) {
                shipStructure.toRepair = true;
            }

            spaceship.useRepairAndroids(shipStructures, repairAndroidsToUse);

        } else if (this == Action.BROADCAST_MESSAGE) {

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

        } else if (this == Action.PRINT_LOGBOOK) {

            int index = 1;
            ArrayList<String> logbook = Spaceship.returnBroadcastLog();

            for (String entry : logbook) {
                System.out.println("Message " + index + ": " + entry);
                index += 1;
            }

        } else if (this == Action.CANCEL) {
            System.out.println("Returning to ship selection.");
        } else { //Have to model this in chooseSpaceshipAction in Game class
            System.out.println("Not a valid option! Please choose again.");
        }
    }

    @Override
    public String toString(){
        return this.label;
    }
}
