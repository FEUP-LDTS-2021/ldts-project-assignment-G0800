package com.ldts.donkeykong.viewer.game.elements.nonDynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Ladder;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Stair;
import com.ldts.donkeykong.model.game.elements.nonDynamic.StaticElement;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Structure;

public class StructureViewer extends StaticElementViewer {
    @Override
    public void draw(StaticElement element, GUI gui) {
        Structure structure = (Structure) element;
        for (Stair stair: structure.getStairs()) {
            gui.drawStair(element.getPosition(), '-');
        }
    }
}