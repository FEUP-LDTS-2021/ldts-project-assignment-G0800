package com.ldts.donkeykong.model.game.dynamic;

import com.ldts.donkeykong.model.base.Position;

public class Barrel extends DynamicElement {
    private final boolean fiery;

    public Barrel(Position position, boolean fiery) {
        super(position);
        this.fiery = fiery;
    }

    public boolean isFiery() {
        return this.fiery;
    }
}
