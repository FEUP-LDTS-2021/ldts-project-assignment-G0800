package com.ldts.donkeykong.model.game.dynamic;

import com.ldts.donkeykong.model.base.Position;

public class Barrel extends DynamicElement {
    private boolean fiery;

    public Barrel(Position p, boolean f) {
        this.position = p;
        this.fiery = f;
    }

    public boolean isFiery() {
        return this.fiery;
    }
}
