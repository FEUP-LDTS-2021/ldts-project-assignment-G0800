package com.ldts.donkeykong.controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.Controller;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.FireEnemy;


public class MarioController extends Controller<Arena> {
    private boolean hammer;

    public MarioController(Arena arena) {
        super(arena);
        this.hammer = false;
    }

    public void moveUp() {
        moveMario(getModel().getMario().getPosition().getUp());
    }

    public void moveDown() {
        moveMario(getModel().getMario().getPosition().getDown());
    }

    public void moveLeft() {
        moveMario(getModel().getMario().getPosition().getLeft());
        if (hasHammer())
            getModel().getHammer().setPosition(getModel().getMario().getPosition().getLeft());
    }

    public void moveRight() {
        moveMario(getModel().getMario().getPosition().getRight());
        if (hasHammer())
            getModel().getHammer().setPosition(getModel().getMario().getPosition().getRight());

    }

    public void jump() {
        if (!getModel().isLadder(getModel().getMario().getPosition())) {

            boolean fireEnemyClose = false;

            for(FireEnemy fireEnemy: getModel().getFireEnemies()) {
                if (fireEnemy.getPosition().getX() + 1 == getModel().getMario().getPosition().getX() && fireEnemy.getPosition().getY() == getModel().getMario().getPosition().getY()) {
                    moveMario(new Position(getModel().getMario().getPosition().getX() - 2, getModel().getMario().getPosition().getY()));
                    fireEnemyClose = true;
                }
                else if (fireEnemy.getPosition().getX() - 1 == getModel().getMario().getPosition().getX() && fireEnemy.getPosition().getY() == getModel().getMario().getPosition().getY()) {
                    moveMario(new Position(getModel().getMario().getPosition().getX() + 2, getModel().getMario().getPosition().getY()));
                    fireEnemyClose = true;
                }
            }

            if(!fireEnemyClose) {
                getModel().getMario().setPosition(getModel().getMario().getPosition().getUp());

                if (getModel().isBarrel(getModel().getMario().getPosition().getDown()) || getModel().isFireEnemy(getModel().getMario().getPosition().getDown()))
                    getModel().getMario().increaseScore();

                if (getModel().isHammer(getModel().getMario().getPosition())){
                    hammer = true;
                    getModel().getHammer().setPosition(getModel().getMario().getPosition().getDown().getLeft());
                }
                moveDown();
            }
        }
    }

    public void moveMario(Position position) {
        if (getModel().isLadder(position) && !hasHammer())
            getModel().getMario().setPosition(position);

        else if (getModel().isStructure(position) && getModel().isLadder(position.getDown()) && !hasHammer())
            getModel().getMario().setPosition(position);

        else if (getModel().isStructure(position.getDown()))
            getModel().getMario().setPosition(position);

        if (touchedBarrel() || touchedFireEnemy())
            getModel().getMario().setAsDead();

    }

    public boolean hasHammer() {
        return hammer = hammer && getModel().getHammer() != null;
    }

    public boolean princessAtLeft(){
        return getModel().getMario().getPosition().getLeft().equals(getModel().getPrincess().getPosition());
    }

    public boolean princessAtRight(){
        return getModel().getMario().getPosition().getRight().equals(getModel().getPrincess().getPosition());
    }

    public boolean reachedPrincess() {
        return  princessAtLeft() || princessAtRight();
    }

    public boolean touchedBarrel() {
        return getModel().isBarrel(getModel().getMario().getPosition());
    }

    public boolean touchedFireEnemy() {
        return getModel().isFireEnemy(getModel().getMario().getPosition());
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveUp();
        if (action == GUI.ACTION.RIGHT) moveRight();
        if (action == GUI.ACTION.DOWN) moveDown();
        if (action == GUI.ACTION.LEFT) moveLeft();
        if (action == GUI.ACTION.TAB) jump();
    }
}