package com.ldts.donkeykong.viewer.game.elements.dynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.viewer.game.elements.GameElementViewer;

public class BarrelViewer implements GameElementViewer<Barrel> {
    @Override
    public void draw(Barrel barrel, GUI gui) {
        gui.drawBarrel(barrel.getPosition(), barrel.isFiery());
    }
}
