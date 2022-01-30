package com.ldts.donkeykong.controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.Controller;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DonkeyController extends Controller<Arena> {
    private long lastMovement;

    public DonkeyController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    private void throwBarrel() {
        Position position = getModel().getDonkey().getPosition().getRight();
        Barrel barrel = getModel().getBarrels().isEmpty() ? new Barrel(position, true) : new Barrel(position, false);
        getModel().getBarrels().add(barrel);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if(time - lastMovement > 3500) {
            throwBarrel();
            this.lastMovement = time;
        }
    }
}