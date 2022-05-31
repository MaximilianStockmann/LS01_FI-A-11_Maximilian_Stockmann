import java.util.ArrayList;
import java.util.Locale;

/**
 * @author Maximilian Stockmann
 * @description The Spaceship class gives constructors for creating individual objects as well as for
 * adding them to a provided list.
 */
public class Spaceship extends SpaceObject {
    /**********************************************
     MEMBER VARIABLES
     **********************************************/
    public static ArrayList<String> broadcastCommunicator;

    private String name;
    private int energyInPercent;
    private int shieldsInPercent;
    private int hullInPercent;
    private int lifeSupportInPercent;

    private int photonTorpedosLoaded;
    private int repairAndroids;

    private boolean isDestroyed;
    private ArrayList<Freight> freightIndex;
    private ArrayList<Freight> photonTorpedoFreightsOnBoard;
    public ArrayList<String> actionList;

    /**********************************************
     CONSTRUCTORS
     **********************************************/
    /**
     * @description Empty Spaceship constructor
     */
    public Spaceship() {
        setName("");
        setEnergyInPercent(0);
        setShieldsInPercent(0);
        setHullInPercent(0);
        setLifeSupportInPercent(0);
        setRepairAndroids(0);

        name = "";
        energyInPercent = 0;
        shieldsInPercent = 0;
        hullInPercent = 0;
        lifeSupportInPercent = 0;
        photonTorpedosLoaded = 0;
        repairAndroids = 0;
        isDestroyed = false;
        freightIndex = new ArrayList<>();
        photonTorpedoFreightsOnBoard = new ArrayList<>();
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

        photonTorpedosLoaded = 0;
        repairAndroids = 0;
        isDestroyed = false;

        freightIndex = new ArrayList<>();
        actionList = new ArrayList<>();
        photonTorpedoFreightsOnBoard = new ArrayList<>();

        actionList.add("Shoot Phaser");
        actionList.add("Shoot Photon Torpedo");
        actionList.add("Load Cargo");
        actionList.add("Print Status");
        actionList.add("Load Photon Torpedo");
        actionList.add("Cancel");
    }

    /**
     * @description Fully parameterized constructor
     * @param name Name of the spaceship
     * @param energyInPercent Current energy level in %
     * @param shieldsInPercent Current shield strength in %
     * @param hullInPercent Current hull strength in %
     * @param lifeSupportInPercent Functionality of Life Support in %
     * @param repairAndroids Number of repairAndroids on the ship, see also {@link Freight}
     */
    public Spaceship(String name, int energyInPercent, int shieldsInPercent, int hullInPercent, int lifeSupportInPercent,
                     int repairAndroids) {
        this(name, energyInPercent, shieldsInPercent, hullInPercent);
        this.lifeSupportInPercent = lifeSupportInPercent;
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

    public int getPhotonTorpedosOnBoard() {
        photonTorpedoFreightsOnBoard = new ArrayList<>();
        int photonTorpedosOnBoard = 0;
        Freight.findFreightInFreightList("photon torpedos", getFreightIndex(), photonTorpedoFreightsOnBoard);
        for (Freight freight : photonTorpedoFreightsOnBoard) {
            photonTorpedosOnBoard += freight.getAmount();
        }

        return photonTorpedosOnBoard;
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
    public void setPhotonTorpedosLoaded(int photonTorpedosLoaded) {
        this.photonTorpedosLoaded = photonTorpedosLoaded;
    }
    public void setRepairAndroids(int repairAndroids) {
        this.repairAndroids = repairAndroids;
    }
    public void setFreightIndex(ArrayList<Freight> freightIndex) {
        this.freightIndex = freightIndex;
    }
    public void setDestructionStatus(boolean isDestroyed) {
        this.isDestroyed = isDestroyed;
    }

    /**********************************************
     METHODS
     **********************************************/
    /************************
     FIGHTING
     ************************/
    //TODO: Make sure this can only be called if photon torpedos are loaded
    public void firePhotonTorpedo(Spaceship target) {
        if (photonTorpedosLoaded < 0) {
            System.out.println("No photon torpedos loaded!");
        } else {
            target.hitEvent(this, 80, "Photon");
        }
    }

    public void firePhaserCannon(Spaceship target) {
        target.hitEvent(this, 55, "Phaser");
    }

    //This still shows bugged behaviour when calling the function multiple times in a row
    public void loadPhotonTorpedos(int photonTorpedosToLoad) {
        int currentPhotonTorpedosOnBoard = getPhotonTorpedosOnBoard();

        if (currentPhotonTorpedosOnBoard > 0 && currentPhotonTorpedosOnBoard >= photonTorpedosToLoad) {
            int originalAmountToLoad = photonTorpedosToLoad;
            do {
                int largestSingleAmount = 0;
                Freight largestAmountFreight = null;
                Freight currentFreight;

                for (Freight freight : photonTorpedoFreightsOnBoard) {
                    int amount = freight.getAmount();
                    if (amount > largestSingleAmount) {
                        largestSingleAmount = amount;
                        largestAmountFreight = freight;
                    }
                }
                //Check if one Freight element has enough photon torpedos to satisfy amount,
                //if not take from last list element
                if (largestSingleAmount >= photonTorpedosToLoad) {
                    setPhotonTorpedosLoaded(getPhotonTorpedosLoaded()+photonTorpedosToLoad);
                    largestAmountFreight.setAmount(largestAmountFreight.getAmount()-photonTorpedosToLoad);
                    photonTorpedosToLoad = 0;
                    if (largestAmountFreight.getAmount() <= 0) {
                        photonTorpedoFreightsOnBoard.remove(largestAmountFreight);
                        freightIndex.remove(largestAmountFreight);
                    }
                } else {
                    int temp;
                    currentFreight = largestAmountFreight;
                    //currentFreight = photonTorpedoFreightsOnBoard.get(photonTorpedoFreightsOnBoard.size()-1);
                    temp = currentFreight.getAmount();
                    setPhotonTorpedosLoaded(getPhotonTorpedosLoaded()+temp);
                    currentFreight.setAmount(currentFreight.getAmount()-photonTorpedosToLoad);

                    photonTorpedosToLoad = photonTorpedosToLoad - temp;

                    if (currentFreight.getAmount() <= 0) {
                        photonTorpedoFreightsOnBoard.remove(currentFreight);
                        freightIndex.remove(currentFreight);
                    }
                }
            } while (photonTorpedosToLoad > 0);

            System.out.println(Game.ANSI_RESET);
            System.out.println(originalAmountToLoad + " photon torpedos have been loaded.");
            System.out.println(Game.ANSI_GREEN);
            Game.instance().cont();

        } else if (currentPhotonTorpedosOnBoard < photonTorpedosToLoad) {
            System.out.println("Can't load that many photon Torpedos! Only "+ currentPhotonTorpedosOnBoard + " on board.");
        }
    }

    /*
    Hit Event for Spaceship class. Phaser Damage will apply to shields first, before damaging hull with surplus damage.
    Photon Torpedos immediately damage hull.
     */
    private void hitEvent(Spaceship hitBy, int damage, String damageType) {
        int damageSurplus;
        if (damageType.equals("Phaser")) {
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
        } else if (damageType.equals("Photon")) {
            hullInPercent -= damage;
            System.out.println(name+" took "+damage+" damage to hull!");
            if (hullInPercent < 0) {
                hullInPercent = 0;
                System.out.println("Hull got reduced to 0! "+name+" was destroyed!");
                isDestroyed = true;
            }
        }
    }

    /************************
     MESSAGING
     ************************/

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

    /************************
     UTILITY
     ************************/

    public void addFreight (Freight newFreight) {
        freightIndex.add(newFreight);
    }

    /**
     *
     * @param itemToFind String containing the name of the item to be found
     * @param results List that resulting {@link Freight} objects get saved in
     */
    //What if you gave a Freight Object instead of a String?
    //This should probably be in Freight class, refactor
    public void findInFreight(String itemToFind, ArrayList<Freight> results) {
        for (Freight freightIndexEntry : this.freightIndex) {
            if (freightIndexEntry.getItemName().toLowerCase(Locale.ROOT).equals(itemToFind.toLowerCase(Locale.ROOT))) {
                System.out.println("Item found");
                results.add(freightIndexEntry);
            }
        }
    }

    @Override
    public void printStatus() {
        System.out.println("Status of the " + name + ":");
        System.out.println("Current energy: " + energyInPercent);
        System.out.println("Current shields: " + shieldsInPercent);
        System.out.println("Current hull: " + hullInPercent);
        System.out.println("Current life support: " + lifeSupportInPercent);
        System.out.println("Current number of photon torpedos in Freight: " + getPhotonTorpedosOnBoard());
        if (getPhotonTorpedosLoaded() > 0) {
            System.out.println("There are currently " + getPhotonTorpedosLoaded() + " Photon Torpedos loaded!");
        } else {
            System.out.println("There are currently no Photon Torpedos loaded!");
        }
        System.out.println("Current repair androids on board: " + repairAndroids);

        System.out.println("\nCurrent Freight:");
        for (Freight freight : freightIndex) {
            System.out.println(freight.getItemName() + ": " + freight.getAmount());
        }
    }
}
