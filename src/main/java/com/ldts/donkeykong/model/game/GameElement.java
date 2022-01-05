package com.ldts.donkeykong.model.game;

import com.ldts.donkeykong.model.base.Position;

public abstract class GameElement {
    protected Position position;

    public GameElement(Position position) {
        this.position = position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
