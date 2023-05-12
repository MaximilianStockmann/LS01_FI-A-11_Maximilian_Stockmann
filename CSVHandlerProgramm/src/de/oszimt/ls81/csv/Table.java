package de.oszimt.ls81.csv;

import java.util.ArrayList;

public class Table<T> {
    private int rowCount;
    private int columnCount;
    private int largestColumnSize = 0;
    private ArrayList<ArrayList<TableEntry<T>>> table = new ArrayList<ArrayList<TableEntry<T>>>();

    Table (int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    public void fillTable(ArrayList<T> objectArray) {
        for (T object : objectArray) {
            if (object.getClass().toString().equals((new Schueler()).toString())) {
                table.add()
            }
        }
    }

}
