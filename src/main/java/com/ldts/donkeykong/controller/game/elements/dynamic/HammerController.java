package com.ldts.donkeykong.controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.GameController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;

import java.io.IOException;

public class HammerController extends GameController {
    public HammerController(Arena arena) {
        super(arena);
    }

    public boolean touchedBarrel(Barrel barrel) {
        return false;
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {

    }
}
