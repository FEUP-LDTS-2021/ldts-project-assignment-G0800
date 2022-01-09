package com.ldts.donkeykong.viewer.game.elements.nonDynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.nonDynamic.OilBarrel;
import com.ldts.donkeykong.model.game.elements.nonDynamic.StaticElement;
import com.ldts.donkeykong.viewer.game.elements.GameElementViewer;

public class OilBarrelViewer implements GameElementViewer<OilBarrel> {
    @Override
    public void draw(OilBarrel oilBarrel, GUI gui) {
        gui.drawOilBarrel(oilBarrel.getPosition());
    }
}
