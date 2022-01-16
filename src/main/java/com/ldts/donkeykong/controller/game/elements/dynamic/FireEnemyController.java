package com.ldts.donkeykong.controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.Controller;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.FireEnemy;

import java.io.IOException;

public class FireEnemyController extends Controller<Arena> {
    private long lastMove;

    public FireEnemyController(Arena arena){
        super(arena);

    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {

    }

    public boolean touchedMario(FireEnemy fireEnemy){
        return false;
    }

    public void moveFireEnemy(FireEnemy fireEnemy, Position position){

    }
}
