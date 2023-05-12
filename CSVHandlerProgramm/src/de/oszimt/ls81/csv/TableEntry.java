package de.oszimt.ls81.csv;

public class TableEntry<T> {
    private T content;
    private int stringSize;

    public T getContent() {
        return content;
    }

    public int getStringSize() {
        return stringSize;
    }
}
