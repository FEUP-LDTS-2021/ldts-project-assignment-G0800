package com.ldts.donkeykong.viewer.game.elements.dynamic;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.dynamic.FireEnemy;
import com.ldts.donkeykong.viewer.game.elements.GameElementViewer;

public class FireEnemyViewer implements GameElementViewer<FireEnemy> {
    @Override
    public void draw(FireEnemy fireEnemy, GUI gui) {
        gui.drawFireEnemy(fireEnemy.getPosition());
    }
}
