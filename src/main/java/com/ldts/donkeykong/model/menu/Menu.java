package com.ldts.donkeykong.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int currentEntry = 0;

    public Menu() {
        this.entries = Arrays.asList("Play","Instructions","Exit");
    }

    public void nextEntry() {
        currentEntry++;
        if(currentEntry > 2) {
            currentEntry = 0;
        }
    }

    public void previousEntry() {
        currentEntry--;
        if(currentEntry < 0) {
            currentEntry = 2;
        }
    }

    public String getEntry(int entry) {
        return entries.get(entry);
    }

    public int getCurrentEntry() {
        return currentEntry;
    }

    public boolean isSelected(int entry) {
        return currentEntry == entry;
    }

    public boolean isSelectedStart() {
        return currentEntry == 0;
    }

    public boolean isSelectedInstructions() {
        return currentEntry == 1;
    }

    public boolean isSelectedExit() {
        return currentEntry == 2;
    }

    public int getNumberOfEntries() {
        return entries.size();
    }
}
