package com.ldts.donkeykong.viewer.menu;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.menu.Menu;
import com.ldts.donkeykong.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(6,6),"Donkey Kong","#FFFFFF");
        for(int i = 0; i < getModel().getNumberOfEntries(); i++) {
            gui.drawText(new Position(6, 8+i), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
