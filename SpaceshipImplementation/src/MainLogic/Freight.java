package MainLogic;

import java.util.ArrayList;
import java.util.Locale;

/**
 * @description Handles Freights and Collections of Freights
 */
public interface Freight {
    String getItemName();
    int getAmount();
    void setItemName(String itemName);
    void setAmount(int amount);

    /**
     * @description Auxiliary function to filter List of MainLogic.Freight objects for specific item name
     * @param itemNameOfFreightToFind String containing the item name to filter for
     * @param freightList List of MainLogic.Freight objects to look in
     * @param results Method saves all filtered MainLogic.Freight objects in this list
     */
    static void findFreightInFreightList(String itemNameOfFreightToFind, ArrayList<Freight> freightList,
                                                ArrayList<Freight> results) {
        for (Freight freightListEntry : freightList) {
            if (freightListEntry.getItemName().toLowerCase(Locale.ROOT).equals(itemNameOfFreightToFind.toLowerCase(Locale.ROOT))) {
                results.add(freightListEntry);
            }
        }
    }

    //TODO: Decouple this properly, this method should be in FreightImp. How to solve this?
    static void addNewFreightToList(ArrayList<Freight> list, String itemName, int amount) {
        list.add(new FreightImp(itemName, amount));
    }

    @Override
    String toString();
}
