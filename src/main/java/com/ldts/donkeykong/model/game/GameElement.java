package com.ldts.donkeykong.model.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts.donkeykong.model.base.Position;

public abstract class GameElement {
    protected Position position;

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract void draw();
}
