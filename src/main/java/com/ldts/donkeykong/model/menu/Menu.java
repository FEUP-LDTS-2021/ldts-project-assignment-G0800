package com.ldts.donkeykong.model.menu;

import java.util.List;

public class Menu {
    private final List<String> entries;
    private int currentEntry = 0;

    public Menu() {
        this.entries = null;
    }

    public void nextEntry() {

    }

    public void previousEntry() {

    }

    public String getEntry(int entry) {
        return null;
    }

    public int getCurrentEntry() {
        return -1;
    }

    public boolean isSelected(int entry) {
        return false;
    }

    public boolean isSelectedStart() {
        return false;
    }

    public boolean isSelectedInstructions() {
        return false;
    }

    public boolean isSelectedExit() {
        return false;
    }

    public int getNumberOfEntries() {
        return -1;
    }
}
