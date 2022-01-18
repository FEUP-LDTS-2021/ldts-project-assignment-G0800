package com.ldts.donkeykong.controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.GameController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;

import java.io.IOException;

public class BarrelController extends GameController {

    Direction direction;

    public BarrelController(Arena arena) {
        super(arena);
    }

    private void moveBarrels() {

    }

    private void moveBarrel(Barrel barrel) {

    }

    private boolean barrelFalling(Barrel barrel) {
        return false;
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {

    }

    enum Direction {LEFT,RIGHT}
}