package com.ldts.donkeykong.model.game.dynamic;

import com.ldts.donkeykong.model.base.Position;

public class Mario extends DynamicElement {
    private boolean alive;

    public Mario(Position position) {
        super(position);
        this.alive = true;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAsDead() {
        this.alive = false;
    }
}
