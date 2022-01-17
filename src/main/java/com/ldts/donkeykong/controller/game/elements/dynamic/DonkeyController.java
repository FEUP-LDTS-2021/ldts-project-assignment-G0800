package com.ldts.donkeykong.controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.Controller;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.Donkey;

import java.io.IOException;

public class DonkeyController extends Controller<Arena> {
    private long lastMovement;

    public DonkeyController(Arena arena) {
        super(arena);
    }

    public void throwBarrel() {

    }

    public void move(Position position) {
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {

    }
}