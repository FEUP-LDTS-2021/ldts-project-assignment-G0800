package com.ldts.donkeykong.model.game.elements.nonDynamic;

import com.ldts.donkeykong.model.base.Position;

import java.util.ArrayList;
import java.util.List;

public class Structure extends StaticElement {
    List<Stair> stairs;
    public Structure(Position startPosition, int width) {
        super(startPosition);
        stairs = new ArrayList<>();
        createStructure(startPosition,width);
    }

    private void createStructure(Position position, int width) {
        Stair stair = new Stair(position);
        stairs.add(stair);
        for (int index = 0; index < width-1; index++) {
            Position newPosition = new Position(stair.getPosition().getUp());
            stair = new Stair(newPosition);
            stairs.add(stair);
        }
    }

    public List<Stair> getStairs() {
        return stairs;
    }

}
