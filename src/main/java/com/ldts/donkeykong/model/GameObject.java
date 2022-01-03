package com.ldts.donkeykong.model;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts.donkeykong.model.dynamic.Position;

public abstract class GameObject  {
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
