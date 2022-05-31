import java.util.ArrayList;
import java.util.Locale;

public enum Action {
    SHOOT_PHASER("Shoot Phaser"),
    SHOOT_PHOTON_TORPEDO("Shoot Photon Torpedo"),
    LOAD_CARGO("Load Cargo"),
    PRINT_STATUS("Print Status"),
    LOAD_PHOTON_TORPEDO("Load Photon Torpedo"),
    CANCEL("Cancel");

    public final String uiLabel;

    private Action(String uiLabel) {
        this.uiLabel = uiLabel;
    }

    public static Action valueOfLabel(String uiLabel) {
        for (Action action : values()) {
            if (action.uiLabel.equals(uiLabel)) {
                return action;
            }
        }
        return null;
    }

    public void executeAction(Spaceship spaceship) {
        if (this == Action.SHOOT_PHASER) {
            Spaceship target = Game.instance().chooseSpaceship("Please enter target ship to hit with Phaser Cannons: ");

            Game.instance().getCurrentSpaceshipSelection().firePhaserCannon(target);

            Game.instance().cont();
        } else if (this == Action.SHOOT_PHOTON_TORPEDO) {
            Spaceship target = Game.instance().chooseSpaceship("Please enter target ship to hit with Photon Torpedo: ");

            Game.instance().getCurrentSpaceshipSelection().firePhotonTorpedo(target);

            Game.instance().cont();
        } else if (this == Action.LOAD_CARGO) {
            System.out.print("Please specify cargo to load (\"cancel\" to cancel): ");
            Game.instance().getMainInput().nextLine();
            String itemName = Game.instance().getMainInput().nextLine();

            if (itemName.toLowerCase(Locale.ROOT).equals("cancel")) {
                System.out.println("No cargo has been loaded.\n");
                Game.instance().cont();
                return;
            }

            System.out.print("Please specify amount: ");
            int amount = Game.instance().getMainInput().nextInt();

            //TODO: Add option to cancel out of amount selection

            Game.instance().getCurrentSpaceshipSelection().addFreight(new Freight(itemName, amount));

            System.out.println("\n"+ amount+" "+ itemName +" have been loaded successfully.");

            Game.instance().cont();
        } else if (this == Action.PRINT_STATUS) {
            System.out.println(Game.ANSI_RESET);
            Game.instance().getCurrentSpaceshipSelection().printStatus();
        } else if (this == Action.LOAD_PHOTON_TORPEDO) {
            System.out.println("Load how many Photon Torpedos?");
            System.out.print("\n> ");
            int amount = Game.instance().getMainInput().nextInt();
            Game.instance().getCurrentSpaceshipSelection().loadPhotonTorpedos(amount);
        } else if (this == Action.CANCEL) {
            System.out.println("Returning to ship selection.");
            return;
        } else { //Have to model this in chooseSpaceshipAction in Game class
            System.out.println("Not a valid option! Please choose again.");
        }
    }
}
