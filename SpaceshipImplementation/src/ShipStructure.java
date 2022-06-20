public enum ShipStructure {
    ENERGY("Energy"),
    SHIELDS("Shields"),
    HULL("Hull"),
    LIFE_SUPPORT("Life Support");

    private final String label;
    private boolean toBeRepaired;

    ShipStructure(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean isToBeRepaired() {
        return toBeRepaired;
    }

    public void setToBeRepaired(boolean toBeRepaired) {
        this.toBeRepaired = toBeRepaired;
    }

    public void repair(Spaceship spaceship, int repairedValue) {
        final int MAXIMUM_PERCENT_VALUE = 100;

        if (this == ShipStructure.ENERGY) {

            spaceship.setEnergyInPercent(spaceship.getEnergyInPercent()+repairedValue);
            //Should this logic be here? Have the maximum percent possible as a separate constant probably
            if (spaceship.getEnergyInPercent() > MAXIMUM_PERCENT_VALUE)
                spaceship.setEnergyInPercent(MAXIMUM_PERCENT_VALUE);

        } else if (this == ShipStructure.SHIELDS) {

            spaceship.setShieldsInPercent(spaceship.getShieldsInPercent()+repairedValue);
            //Should this logic be here? Have the maximum percent possible as a separate constant probably
            if (spaceship.getShieldsInPercent() > MAXIMUM_PERCENT_VALUE)
                spaceship.setShieldsInPercent(MAXIMUM_PERCENT_VALUE);

        } else if (this == ShipStructure.HULL) {

            spaceship.setHullInPercent(spaceship.getHullInPercent()+repairedValue);
            //Should this logic be here? Have the maximum percent possible as a separate constant probably
            if (spaceship.getHullInPercent() > MAXIMUM_PERCENT_VALUE)
                spaceship.setHullInPercent(MAXIMUM_PERCENT_VALUE);

        } else if (this == ShipStructure.LIFE_SUPPORT) {

            spaceship.setLifeSupportInPercent(spaceship.getLifeSupportInPercent()+repairedValue);
            //Should this logic be here? Have the maximum percent possible as a separate constant probably
            if (spaceship.getLifeSupportInPercent() > MAXIMUM_PERCENT_VALUE)
                spaceship.setLifeSupportInPercent(MAXIMUM_PERCENT_VALUE);

        }

    }

}
