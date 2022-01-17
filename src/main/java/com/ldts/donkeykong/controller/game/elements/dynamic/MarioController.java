package com.ldts.donkeykong.controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.Controller;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;

public class MarioController extends Controller<Arena> {
    private boolean hammer;
    public MarioController(Arena arena)
    {
        super(arena);
        this.hammer = false;
    }

    public void moveUp(){

    }

    public void moveDown(){

    }

    public void moveLeft(){

    }

    public void moveRight(){

    }

    public void jump(){

    }

    public void moveMario(Position position) {

    }

    public boolean hasHammer(){
        return false;
    }

    public boolean reachedPrincess(){
        return false;
    }

    public boolean touchedBarrel(){
        return false;
    }

    public boolean touchedFireEnemy(){
        return false;
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {

    }

}