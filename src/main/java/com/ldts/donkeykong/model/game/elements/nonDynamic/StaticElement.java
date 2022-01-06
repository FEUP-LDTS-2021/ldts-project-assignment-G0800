package com.ldts.donkeykong.model.game.elements.nonDynamic;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.GameElement;

public abstract class StaticElement extends GameElement {
    public StaticElement(Position position) {
        super(position);
    }
}
