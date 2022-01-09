package com.ldts.donkeykong.viewer.game.elements.dynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.dynamic.DynamicElement;
import com.ldts.donkeykong.model.game.elements.dynamic.FireEnemy;

public class FireEnemyViewer extends DynamicElementViewer {
    @Override
    public void draw(DynamicElement element, GUI gui) {
        FireEnemy fireEnemy = (FireEnemy) element;
        gui.drawFireEnemy(fireEnemy.getPosition());
    }
}
