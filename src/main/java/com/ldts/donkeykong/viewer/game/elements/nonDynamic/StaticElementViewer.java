package com.ldts.donkeykong.viewer.game.elements.nonDynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.nonDynamic.StaticElement;
import com.ldts.donkeykong.viewer.game.elements.GameElementViewer;

public abstract class StaticElementViewer implements GameElementViewer<StaticElement> {
    @Override
    public abstract void draw(StaticElement element, GUI gui);
}
