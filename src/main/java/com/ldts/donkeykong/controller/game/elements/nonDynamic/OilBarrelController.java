package com.ldts.donkeykong.controller.game.elements.nonDynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.GameController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;

import java.io.IOException;

public class OilBarrelController extends GameController {

    public OilBarrelController(Arena arena) {
        super(arena);
    }

    public boolean hasFieryBarrel(Barrel barrel) {
        return false;
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {

    }
}
