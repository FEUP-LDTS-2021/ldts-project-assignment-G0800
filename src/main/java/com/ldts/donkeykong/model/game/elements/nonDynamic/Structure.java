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

    }

    public List<Stair> getStairs() {
        return stairs;
    }

}
