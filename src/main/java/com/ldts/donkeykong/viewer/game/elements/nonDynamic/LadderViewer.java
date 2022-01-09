package com.ldts.donkeykong.viewer.game.elements.nonDynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Ladder;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Stair;
import com.ldts.donkeykong.model.game.elements.nonDynamic.StaticElement;
import com.ldts.donkeykong.viewer.game.elements.GameElementViewer;

public class LadderViewer implements GameElementViewer<Ladder> {
    @Override
    public void draw(Ladder ladder, GUI gui) {
        for (Stair stair: ladder.getStairs()) {
            gui.drawStair(stair.getPosition(), '|');
        }
    }
}
