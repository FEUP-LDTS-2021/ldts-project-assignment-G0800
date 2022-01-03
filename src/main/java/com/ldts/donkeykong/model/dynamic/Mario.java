package com.ldts.donkeykong.model.dynamic;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts.donkeykong.model.GameObject;

public class Mario extends GameObject {
    private int x;
    private int y;
    boolean alive;

    public Mario(Position p) {
        this.position = p;
    }

    public Mario(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void move() {

    }

    @Override
    public void draw(TextGraphics graphics) {

    }
}
