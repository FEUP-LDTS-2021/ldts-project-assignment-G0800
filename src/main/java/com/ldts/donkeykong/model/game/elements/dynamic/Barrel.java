package com.ldts.donkeykong.model.game.elements.dynamic;

import com.ldts.donkeykong.model.base.Position;

public class Barrel extends DynamicElement {
    private final boolean fiery;
    private DIRECTION direction;

    public Barrel(Position position, boolean fiery) {
        super(position);
        this.fiery = fiery;
        this.direction = DIRECTION.LEFT;
    }

    public boolean isFiery() {
        return this.fiery;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public void changeDirection() {
        if (direction == DIRECTION.RIGHT) {
            direction = DIRECTION.LEFT;
        } else {
            direction = DIRECTION.RIGHT;
        }
    }
}
