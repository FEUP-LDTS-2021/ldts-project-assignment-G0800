package com.ldts.donkeykong.model.dynamic;

import com.ldts.donkeykong.model.GameObject;
import com.ldts.donkeykong.model.base.Position;

public class Mario extends DynamicObject {
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
