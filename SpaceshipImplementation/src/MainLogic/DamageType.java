package MainLogic;

public enum DamageType {
    PHASER("Phaser"),
    PHOTON_TORPEDO("Photon Torpedo");

    private final String label;

    DamageType(String label) {
        this.label = label;
    }

    public static DamageType valueOfLabel(String uiLabel) {
        for (DamageType damageType : values()) {
            if (damageType.label.equals(uiLabel)) {
                return damageType;
            }
        }
        return null;
    }

    public void apply(Spaceship spaceship, int damageValue) {
        if (this == PHASER) {
            calculatePhaserDamage(spaceship, damageValue);
        } else if (this == PHOTON_TORPEDO) {
            calculatePhotonTorpedoDamage(spaceship, damageValue);
        }
    }

    private void calculatePhaserDamage(Spaceship spaceship, int damageValue) {
        String name = spaceship.getName();
        int shields = spaceship.getShieldsInPercent();
        int hull = spaceship.getHullInPercent();

        if (shields > 0 && shields > damageValue) {
            shields -= damageValue;
            System.out.println(name + " took " + damageValue + " damage to shields!");
        } else if (shields > 0 && shields < damageValue && shields + hull > damageValue) {
            damageValue -= shields;
            System.out.println(name + " took " + shields + " damage to shields;");
            shields = 0;
            hull -= damageValue;
            System.out.println(name + " took " + damageValue + " damage to hull!");
        } else if (shields <= 0 && hull > damageValue) {
            System.out.println(name + " took " + damageValue + " damage to hull!");
            hull -= damageValue;
        } else if (shields <= 0 && hull < damageValue) {
            System.out.println(name + " took " + shields + " damage to shields;");
            System.out.println(name + " took " + hull + " damage to hull!");
            System.out.println("Hull got reduced to 0! "+ name + " was destroyed!");
            shields = 0;
            hull = 0;
            spaceship.setDestructionStatus(true);
        }

        spaceship.setShieldsInPercent(shields);
        spaceship.setHullInPercent(hull);

    }

    private void calculatePhotonTorpedoDamage(Spaceship spaceship, int damageValue) {
        String name = spaceship.getName();
        int hull = spaceship.getHullInPercent();

        if (hull > damageValue) {
            System.out.println(name + " took " + damageValue + " damage to hull!");
            hull -= damageValue;
        } else if (hull < damageValue) {
            System.out.println(name + " took " + hull + " damage to hull!");
            System.out.println("Hull got reduced to 0! "+ spaceship.getName() +" was destroyed!");
            hull = 0;
            spaceship.setDestructionStatus(true);
        }

        spaceship.setHullInPercent(hull);
    }
}
