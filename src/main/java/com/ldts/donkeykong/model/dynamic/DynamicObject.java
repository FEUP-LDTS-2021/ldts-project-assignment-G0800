package com.ldts.donkeykong.model.dynamic;

import com.ldts.donkeykong.model.GameObject;

public abstract class DynamicObject extends GameObject implements Movement {
    public abstract void move();
}
