package com.ldts.donkeykong.viewer.game.elements.dynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.dynamic.Donkey;
import com.ldts.donkeykong.model.game.elements.dynamic.DynamicElement;

public class DonkeyViewer extends DynamicElementViewer {
    @Override
    public void draw(DynamicElement element, GUI gui) {
        Donkey donkey= (Donkey) element;
        gui.drawDonkey(donkey.getPosition());
    }
}
