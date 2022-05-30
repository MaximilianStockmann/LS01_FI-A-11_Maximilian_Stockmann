import java.util.ArrayList;
import java.util.Locale;

public class Freight {
    private String itemName;
    private int amount;

    Freight(String itemName, int amount) {
        this.itemName = itemName;
        this.amount = amount;
    }

    public String getItemName() {
        return itemName;
    }

    public int getAmount() {
        return amount;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @description Auxiliary function to filter List of Freight objects for specific item name
     * @param itemNameOfFreightToFind String containing the item name to filter for
     * @param freightList List of Freight objects to look in
     * @param results Method saves all filtered Freight objects in this list
     */
    public static void findFreightInFreightList(String itemNameOfFreightToFind, ArrayList<Freight> freightList,
                                                ArrayList<Freight> results) {
        for (Freight freightListEntry : freightList) {
            if (freightListEntry.getItemName().toLowerCase(Locale.ROOT).equals(itemNameOfFreightToFind.toLowerCase(Locale.ROOT))) {
                results.add(freightListEntry);
            }
        }
    }
}
