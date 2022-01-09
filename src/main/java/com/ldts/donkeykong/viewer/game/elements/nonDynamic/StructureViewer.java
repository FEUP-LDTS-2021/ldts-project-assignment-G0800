package com.ldts.donkeykong.viewer.game.elements.nonDynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Ladder;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Stair;
import com.ldts.donkeykong.model.game.elements.nonDynamic.StaticElement;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Structure;
import com.ldts.donkeykong.viewer.game.elements.GameElementViewer;

public class StructureViewer implements GameElementViewer<Structure> {
    @Override
    public void draw(Structure structure, GUI gui) {
        for (Stair stair: structure.getStairs()) {
            gui.drawStair(stair.getPosition(), '-');
        }
    }
}