package com.ldts.donkeykong.model.game.nonDynamic;

import com.ldts.donkeykong.model.base.Position;

public class Score extends StaticElement {
    private int score;
    public Score(Position position) {
        super(position);
        this.score = 0;
    }

    public int getScore() {
        return score;
    }


    public void setScore(int score) {
        this.score = score;
    }
}
