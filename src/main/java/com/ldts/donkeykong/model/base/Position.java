package com.ldts.donkeykong.model.base;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {this.y = y;}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getUp(){
        return new Position(x - 1, y);
    }

    public Position getDown(){
        return new Position(x + 1, y);
    }

    public Position getLeft(){
        return new Position(x,y - 1);
    }

    public Position getRight(){
        return new Position(x,y + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return x == p.getX() && y == p.getY();
    }
}