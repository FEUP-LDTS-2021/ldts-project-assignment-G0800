package com.ldts.donkeykong.viewer.game.elements.dynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.dynamic.Mario;
import com.ldts.donkeykong.viewer.game.elements.GameElementViewer;

public class MarioViewer implements GameElementViewer<Mario> {
    @Override
    public void draw(Mario mario, GUI gui) {
        gui.drawMario(mario.getPosition());
    }
}