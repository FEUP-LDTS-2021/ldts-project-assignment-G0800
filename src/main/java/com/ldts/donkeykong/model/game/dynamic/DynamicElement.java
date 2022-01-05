package com.ldts.donkeykong.model.dynamic;

import com.ldts.donkeykong.model.GameElement;

public abstract class DynamicElement extends GameElement implements Movement {
    public abstract void move();
}
