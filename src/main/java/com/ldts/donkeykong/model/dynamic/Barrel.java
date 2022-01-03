package com.ldts.donkeykong.model.dynamic;

import com.ldts.donkeykong.model.GameObject;
import com.ldts.donkeykong.model.base.Position;

public class Barrel extends DynamicObject {
    private boolean fiery;

    public Barrel(Position p, boolean f) {
        this.position = p;
        this.fiery = f;
    }

    public boolean isFiery() {
        return this.fiery;
    }

    //TODO
    @Override
    public void draw() {

    }

    //TODO
    public void move() {

    }
}
