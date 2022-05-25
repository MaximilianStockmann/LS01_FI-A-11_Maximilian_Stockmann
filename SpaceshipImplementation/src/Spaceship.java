import java.util.ArrayList;

/**
 * @author Maximilian Stockmann
 * @description The Spaceship class gives constructors for creating individual objects as well as for
 * adding them to a provided list.
 */
public class Spaceship extends SpaceObject {
    public static ArrayList<String> broadcastCommunicator;

    private String name;
    private int energyInPercent;
    private int shieldsInPercent;
    private int hullInPercent;
    private int lifeSupportInPercent;

    private int photonTorpedos;
    private int photonTorpedosLoaded;
    private int repairAndroids;

    private boolean isDestroyed;
    private ArrayList<Freight> freightIndex;
    public ArrayList<String> actionList;

    //Empty constructor
    public Spaceship() {
        setName("");
        setEnergyInPercent(0);
        setShieldsInPercent(0);
        setHullInPercent(0);
        setLifeSupportInPercent(0);
        setPhotonTorpedos(0);
        setRepairAndroids(0);

        name = "";
        energyInPercent = 0;
        shieldsInPercent = 0;
        hullInPercent = 0;
        lifeSupportInPercent = 0;
        photonTorpedos = 0;
        photonTorpedosLoaded = 0;
        repairAndroids = 0;
        isDestroyed = false;
        freightIndex = new ArrayList<>();
    }

    /**
     * @description Simple constructor for Spaceship class
     * @param name Name of the spaceship
     * @param energyInPercent Current energy level in %
     * @param shieldsInPercent Current shield strength in %
     * @param hullInPercent Current hull strength in %
     */
    public Spaceship(String name, int energyInPercent, int shieldsInPercent, int hullInPercent) {
        this.name = name;
        this.energyInPercent = energyInPercent;
        this.shieldsInPercent = shieldsInPercent;
        this.hullInPercent = hullInPercent;

        photonTorpedos = 0;
        photonTorpedosLoaded = 0;
        repairAndroids = 0;
        isDestroyed = false;

        freightIndex = new ArrayList<>();
        actionList = new ArrayList<>();

        actionList.add("Shoot Phaser");
        actionList.add("Shoot Photon Torpedo");
        actionList.add("Load Cargo");
        actionList.add("Print Status");
        actionList.add("Cancel");
    }

    /**Fully parameterized constructor
     *
     * @param name Name of the spaceship
     * @param energyInPercent Current energy level in %
     * @param shieldsInPercent Current shield strength in %
     * @param hullInPercent Current hull strength in %
     * @param lifeSupportInPercent Functionality of Life Support in %
     * @param photonTorpedos Photon Torpedos currently on board, see also {@link Freight},
     * {@link Spaceship#firePhotonTorpedo}, {@link Spaceship#loadPhotonTorpedos}
     * @param repairAndroids Number of repairAndroids on the ship, see also {@link Freight}
     */
    public Spaceship(String name, int energyInPercent, int shieldsInPercent, int hullInPercent, int lifeSupportInPercent,
                     int photonTorpedos, int repairAndroids) {
        this(name, energyInPercent, shieldsInPercent, hullInPercent);
        this.lifeSupportInPercent = lifeSupportInPercent;
        this.photonTorpedos = photonTorpedos;
        photonTorpedosLoaded = 0;
        this.repairAndroids = repairAndroids;
        isDestroyed = false;
        freightIndex = new ArrayList<>();
    }

    @Override
    public String toString() {
        return getName();
    }

    /**********************************************
     GETTERS
     **********************************************/
    public String getName() {
        return name;
    }
    public int getEnergyInPercent() { return energyInPercent; }
    public int getShieldsInPercent() {
        return shieldsInPercent;
    }
    public int getHullInPercent() { return hullInPercent; }
    public int getLifeSupportInPercent() {
        return lifeSupportInPercent;
    }
    public int getPhotonTorpedos() {
        return photonTorpedos;
    }
    public int getPhotonTorpedosLoaded() {
        return photonTorpedosLoaded;
    }
    public int getRepairAndroids() {
        return repairAndroids;
    }
    public ArrayList<Freight> getFreightIndex() {
        return freightIndex;
    }
    public boolean getDestructionStatus() {
        return isDestroyed;
    }

    /**********************************************
     SETTERS
     **********************************************/
    public void setName(String name) {
        this.name = name;
    }
    public void setEnergyInPercent(int energyInPercent) {
        this.energyInPercent = energyInPercent;
    }
    public void setShieldsInPercent(int shieldsInPercent) {
        this.shieldsInPercent = shieldsInPercent;
    }
    public void setHullInPercent(int hullInPercent) {
        this.hullInPercent = hullInPercent;
    }
    public void setLifeSupportInPercent(int lifeSupportInPercent) {
        this.lifeSupportInPercent = lifeSupportInPercent;
    }
    public void setPhotonTorpedos(int photonTorpedos) {
        this.photonTorpedos = photonTorpedos;
    }
    public void setPhotonTorpedosLoaded(int photonTorpedosLoaded) {
        this.photonTorpedosLoaded = photonTorpedosLoaded;
    }
    public void setRepairAndroids(int repairAndroids) {
        this.repairAndroids = repairAndroids;
    }
    public void setFreightIndex(ArrayList<Freight> freightIndex) {
        this.freightIndex = freightIndex;
    }

    /**********************************************
     METHODS
     **********************************************/
    //TODO: Make sure this can only be called if photon torpedos are loaded
    public void firePhotonTorpedo(Spaceship target) {
        target.hitEvent(this, 80, "Photon");
    }

    public void firePhaserCannon(Spaceship target) {
        target.hitEvent(this, 55, "Phaser");
    }

    /*
    Hit Event for Spaceship class. Phaser Damage will apply to shields first, before damaging hull with surplus damage.
    Photon Torpedos immediately damage hull.
     */
    private void hitEvent(Spaceship hitBy, int damage, String damageType) {
        int damageSurplus = 0;
        if (damageType == "Phaser") {
            if (shieldsInPercent > 0) {
                shieldsInPercent -= damage;
                if (shieldsInPercent < 0) {
                    damageSurplus = shieldsInPercent;
                    System.out.println(name+" took "+(damage - damageSurplus)+ " damage to shields! Shield was destroyed!");
                    shieldsInPercent = 0;
                    hullInPercent += damageSurplus;
                    System.out.println(name+" took "+damageSurplus+ " damage to hull!");
                    System.out.println(hullInPercent +" hull durability remaining!");
                    if (hullInPercent < 0) {
                        hullInPercent = 0;
                        System.out.println("Hull got reduced to 0! "+name+" was destroyed!");
                        System.out.println(shieldsInPercent +" shield remaining!");
                    }
                }
                System.out.println(name+" took "+damage+ " damage to shields!");
                System.out.println(shieldsInPercent +" shield remaining!");
            }
        } else if (damageType == "Photon") {
            hullInPercent -= damage;
            System.out.println(name+" took "+damage+" damage to hull!");
            if (hullInPercent < 0) {
                hullInPercent = 0;
                System.out.println("Hull got reduced to 0! "+name+" was destroyed!");
                isDestroyed = true;
            }
        }
    }

    public void broadcastMessage(String message) {
        broadcastCommunicator.add(message);
    }

    /**
     *
     * @return broadcastCommunicator, static attribute shared over all Spaceship instances
     */
    public static ArrayList<String> returnBroadcastLog() {
        return broadcastCommunicator;
    }

    public void loadPhotonTorpedos(int amount) {
        //stub
    }

    public void addFreight (Freight newFreight) {
        freightIndex.add(newFreight);
    }

    public void printStatus() {
        System.out.println("Status of the " + name + ":");
        System.out.println("Current energy: " + energyInPercent);
        System.out.println("Current shields: " + shieldsInPercent);
        System.out.println("Current hull: " + hullInPercent);
        System.out.println("Current life support: " + lifeSupportInPercent);
        System.out.println("Current number of photon torpedos: " + photonTorpedos);
        System.out.println("Current repair androids on board: " + repairAndroids);

        System.out.println("\nCurrent Freight:");
        for (Freight freight : freightIndex) {
            System.out.println(freight.getItemName() + ": " + freight.getAmount());
        }

        //TODO: ADD FREIGHT DISPLAY
    }
}
