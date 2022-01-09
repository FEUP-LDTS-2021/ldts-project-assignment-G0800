package com.ldts.donkeykong.viewer.game.elements.dynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.dynamic.Donkey;
import com.ldts.donkeykong.viewer.game.elements.GameElementViewer;

public class DonkeyViewer implements GameElementViewer<Donkey> {
    @Override
    public void draw(Donkey donkey, GUI gui) {
        gui.drawDonkey(donkey.getPosition());
    }
}
