package com.ldts.donkeykong.viewer.game.elements.dynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.dynamic.DynamicElement;
import com.ldts.donkeykong.model.game.elements.dynamic.Mario;

public class MarioViewer extends DynamicElementViewer {
    @Override
    public void draw(DynamicElement element, GUI gui) {
        Mario mario= (Mario) element;
        gui.drawMario(mario.getPosition());
    }
}