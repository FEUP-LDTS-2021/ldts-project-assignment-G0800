package com.ldts.donkeykong.controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.Controller;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;

import java.io.IOException;

public class MarioController extends Controller<Arena> {

    public MarioController(Arena arena) {
        super(arena);
    }

    public void moveUp(){

    }

    public void moveDown(){

    }

    public void moveLeft(){

    }

    public void moveRight(){

    }

    public void moveMario(Position position) {

    }

    public void jump(){

    }

    public boolean hasHammer(){
        return false;
    }

    public boolean reachedPrincess(){
        return false;
    }

    public boolean touchedBarrel(Barrel barrel){
        return false;
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {

    }

}