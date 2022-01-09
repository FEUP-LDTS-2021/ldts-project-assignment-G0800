package com.ldts.donkeykong.viewer.game.elements.dynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.DynamicElement;

public class BarrelViewer extends DynamicElementViewer {
    @Override
    public void draw(DynamicElement element, GUI gui) {
        Barrel barrel= (Barrel) element;
        gui.drawBarrel(barrel.getPosition(), barrel.isFiery());
    }
}
