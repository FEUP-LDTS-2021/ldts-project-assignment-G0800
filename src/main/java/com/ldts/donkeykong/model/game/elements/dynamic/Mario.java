package com.ldts.donkeykong.model.game.elements.dynamic;

import com.ldts.donkeykong.model.base.Position;

public class Mario extends DynamicElement {
    private boolean alive;
    private int score;

    public Mario(Position position) {
        super(position);
        this.alive = true;
        score=0;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAsDead() {
        this.alive = false;
    }

    public int getScore(){ return score;}

    public void increaseScore(){
        score += 100;
    }
}
