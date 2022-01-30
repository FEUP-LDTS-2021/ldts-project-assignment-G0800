package com.ldts.donkeykong.controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.Controller;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.FireEnemy;

public class FireEnemyController extends Controller<Arena> {
    private long lastMove;

    public FireEnemyController(Arena arena){
        super(arena);
        lastMove = 0;
    }

    public boolean touchedMario(FireEnemy fireEnemy){
        return fireEnemy.getPosition().equals(getModel().getMario().getPosition());
    }

    private void moveFireEnemy(FireEnemy fireEnemy, Position position){
        if (getModel().hasStructureBelow(position)){
            fireEnemy.setPosition(position);
            if (touchedMario(fireEnemy))
                getModel().getMario().setAsDead();
        }
    }

    private void moveFireEnemies() {
        Position fireEnemyPosition, nextPosition;
        for (FireEnemy fireEnemy : getModel().getFireEnemies()){
            fireEnemyPosition = fireEnemy.getPosition();

            if (marioAtRight(fireEnemy))
                nextPosition = getModel().hasStructureBelow(fireEnemyPosition.getRight()) ? fireEnemyPosition.getRight() : fireEnemyPosition.getLeft();
            else if (marioAtLeft(fireEnemy))
                nextPosition = getModel().hasStructureBelow(fireEnemyPosition.getLeft()) ? fireEnemyPosition.getLeft() : fireEnemyPosition.getRight();
            else
                nextPosition = (int) (Math.random() * 2) == 1 ? fireEnemyPosition.getRight() : fireEnemyPosition.getLeft();

            moveFireEnemy(fireEnemy, nextPosition);
        }
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        if (time - lastMove > 350){
            moveFireEnemies();
            this.lastMove = time;
        }
    }

    private boolean isNearMario(FireEnemy fireEnemy){
        return fireEnemy.getPosition().getY() == getModel().getMario().getPosition().getY();
    }

    private boolean marioAtLeft(FireEnemy fireEnemy){
        return isNearMario(fireEnemy) && getModel().getMario().getPosition().getX() < fireEnemy.getPosition().getX();
    }

    private boolean marioAtRight(FireEnemy fireEnemy){
        return isNearMario(fireEnemy) && getModel().getMario().getPosition().getX() > fireEnemy.getPosition().getX();
    }
}
