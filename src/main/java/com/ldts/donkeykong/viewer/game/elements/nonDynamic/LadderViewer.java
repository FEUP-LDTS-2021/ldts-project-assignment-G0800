package com.ldts.donkeykong.viewer.game.elements.nonDynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Ladder;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Stair;
import com.ldts.donkeykong.model.game.elements.nonDynamic.StaticElement;

public class LadderViewer extends StaticElementViewer {
    @Override
    public void draw(StaticElement element, GUI gui) {
        Ladder ladder = (Ladder) element;
        for (Stair stair: ladder.getStairs()) {
            gui.drawStair(element.getPosition(), '|');
        }
    }
}
