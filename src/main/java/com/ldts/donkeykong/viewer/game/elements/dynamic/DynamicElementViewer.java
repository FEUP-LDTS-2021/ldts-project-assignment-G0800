package com.ldts.donkeykong.viewer.game.elements.dynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.dynamic.DynamicElement;
import com.ldts.donkeykong.viewer.game.elements.GameElementViewer;

public abstract class DynamicElementViewer implements GameElementViewer<DynamicElement> {
    @Override
    public abstract void draw(DynamicElement element, GUI gui);
}
