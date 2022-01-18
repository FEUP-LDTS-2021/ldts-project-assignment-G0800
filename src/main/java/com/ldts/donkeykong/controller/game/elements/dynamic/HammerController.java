package com.ldts.donkeykong.controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.GameController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.FireEnemy;

import java.io.IOException;

public class HammerController extends GameController {
    private byte quantityOfHits = 5;
    public HammerController(Arena arena) {
        super(arena);
    }

    private boolean touchedBarrel(Barrel barrel) {
        return false;
    }

    private boolean touchedFireEnemy(FireEnemy fireEnemy) {
        return false;
    }

    private void checkAllBarrels() {

    }

    private void checkAllFireEnemies() {

    }

    private void decreaseQuantityOfHits() {

    }

    private void setHammerAsNull() {

    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {

    }
}