package com.ldts.donkeykong.viewer.game.elements.dynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.dynamic.Hammer;
import com.ldts.donkeykong.viewer.game.elements.GameElementViewer;

public class HammerViewer implements GameElementViewer<Hammer> {
    @Override
    public void draw(Hammer hammer, GUI gui) {
        gui.drawHammer(hammer.getPosition());
    }
}
