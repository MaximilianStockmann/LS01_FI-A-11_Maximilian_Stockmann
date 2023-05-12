package MainLogic;

import java.util.ArrayList;
import java.util.Locale;

//TODO: Add functionality for this to save items as objects instead of strings
public class FreightImp implements Freight {
    private String itemName;
    private int amount;

    public FreightImp(String itemName, int amount) {
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

    public static void addNewFreightToList(ArrayList<Freight> list, String itemName, int amount) {
        list.add(new FreightImp(itemName, amount));
    }

    @Override
    public String toString() {
        return getItemName();
    }
}
