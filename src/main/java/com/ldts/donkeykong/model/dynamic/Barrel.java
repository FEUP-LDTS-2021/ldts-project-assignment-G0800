package com.ldts.donkeykong.model.dynamic;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts.donkeykong.model.GameObject;

public class Barrel extends GameObject {
    private boolean fiery;

    public Barrel(Position p, boolean f) {
        this.position = p;
        this.fiery = f;
    }

    public boolean isFiery() {
        return this.fiery;
    }

    @Override
    public void draw(TextGraphics graphics) {

    }

    public void move() {

    }
}
