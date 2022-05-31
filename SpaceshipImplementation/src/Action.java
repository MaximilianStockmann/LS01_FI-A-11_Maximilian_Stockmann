import java.util.ArrayList;

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
        }
    }
}
