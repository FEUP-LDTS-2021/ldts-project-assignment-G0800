package com.ldts.donkeykong.model.game.dynamic;

import com.ldts.donkeykong.model.base.Position;

public class Mario extends DynamicElement {
    private boolean alive;
    private Position position;

    public Mario(Position p) {
        this.position = p;
    }

    public boolean isAlive() {
        return this.alive;
    }

    //TODO
    @Override
    public void move() {

    }

    //TODO
    @Override
    public void draw() {

    }
}