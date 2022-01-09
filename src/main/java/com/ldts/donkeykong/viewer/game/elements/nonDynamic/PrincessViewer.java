package com.ldts.donkeykong.viewer.game.elements.nonDynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Princess;
import com.ldts.donkeykong.model.game.elements.nonDynamic.StaticElement;

public class PrincessViewer extends StaticElementViewer {
    public void draw(StaticElement element, GUI gui) {
        Princess princess = (Princess) element;
        gui.drawPrincess(princess.getPosition());
    }
}