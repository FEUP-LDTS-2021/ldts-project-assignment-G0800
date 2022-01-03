package com.ldts.donkeykong.model;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class GameObject implements DynamicObject{
    protected Position position;
    protected TextGraphics graphics;

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract void draw(TextGraphics graphics);
}
