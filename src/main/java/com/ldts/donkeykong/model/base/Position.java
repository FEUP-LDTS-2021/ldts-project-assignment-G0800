package com.ldts.donkeykong.model.base;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getUp(){
        return new Position(0,0);
    }

    public Position getDown(){
        return new Position(0,0);
    }

    public Position getLeft(){
        return new Position(0,0);
    }

    public Position getRight(){
        return new Position(0,0);
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}