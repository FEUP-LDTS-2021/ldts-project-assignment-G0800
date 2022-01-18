package com.ldts.donkeykong.controller.game.arena;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.GameController;
import com.ldts.donkeykong.controller.game.elements.dynamic.*;
import com.ldts.donkeykong.controller.game.elements.nonDynamic.OilBarrelController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.menu.Menu;
import com.ldts.donkeykong.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final MarioController marioController;
    private final DonkeyController donkeyController;
    private final BarrelController barrelController;
    private final FireEnemyController fireEnemyController;
    private final HammerController hammerController;
    private final OilBarrelController oilBarrelController;

    public ArenaController(Arena arena) {
        super(arena);

        this.marioController = new MarioController(arena);
        this.donkeyController = new DonkeyController(arena);
        this.barrelController = new BarrelController(arena);
        this.fireEnemyController = new FireEnemyController(arena);
        this.hammerController = new HammerController(arena);
        this.oilBarrelController = new OilBarrelController(arena);
    }

    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || !getModel().getMario().isAlive()) {
            application.setState(new MenuState(new Menu()));
        }
        else {
            marioController.step(application, action, time);
            donkeyController.step(application, action, time);
            barrelController.step(application, action, time);
            fireEnemyController.step(application, action, time);
            hammerController.step(application, action, time);
            oilBarrelController.step(application, action, time);
        }
    }
}
