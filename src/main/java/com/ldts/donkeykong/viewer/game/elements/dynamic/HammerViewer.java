package com.ldts.donkeykong.viewer.game.elements.dynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.dynamic.DynamicElement;
import com.ldts.donkeykong.model.game.elements.dynamic.Hammer;

public class HammerViewer extends DynamicElementViewer{
    @Override
    public void draw(DynamicElement element, GUI gui) {
        Hammer hammer = (Hammer) element;
        gui.drawHammer(hammer.getPosition());
    }
}
