package com.ldts.donkeykong.model.game.nonDynamic;

import com.ldts.donkeykong.model.base.Position;

import java.util.ArrayList;
import java.util.List;

public class Ladder extends StaticElement {
    List<Stair> stairs;
    public Ladder(Position startPosition, int height) {
        super(startPosition);
        stairs = new ArrayList<>();
        createLadder(startPosition,height);
    }

    private void createLadder(Position position, int height) {
        Stair stair = new Stair(position);
        stairs.add(stair);
        for (int index = 0; index < height-1; index++) {
            Position newPosition = new Position(stair.getPosition().getUp());
            stair = new Stair(newPosition);
            stairs.add(stair);
        }
    }

    public List<Stair> getStairs() {
        return stairs;
    }
}
