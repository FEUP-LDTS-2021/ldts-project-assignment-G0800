package com.ldts.donkeykong.model.game.nonDynamic;

import com.ldts.donkeykong.model.base.Position;

public class Score extends StaticElement {
    private int score;
    public Score(Position position, int score) {
        super(position);
        this.score = score;
    }

    public int getScore() {
        return 0;
    }

    public void setScore(int score) {

    }
}
