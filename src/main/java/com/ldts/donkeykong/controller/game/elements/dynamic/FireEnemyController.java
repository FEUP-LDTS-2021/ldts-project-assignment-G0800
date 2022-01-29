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

    public void moveFireEnemy(FireEnemy fireEnemy, Position position){
        if (getModel().hasStructureBelow(position)){
            fireEnemy.setPosition(position);
            if (touchedMario(fireEnemy))
                getModel().getMario().setAsDead();
        }
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        if (time - lastMove > 350){
            for (FireEnemy f: getModel().getFireEnemies()){
                Position enemyPosition = f.getPosition();
                Position nextPosition;

                if (marioAtRight(f))
                    nextPosition = getModel().hasStructureBelow(enemyPosition.getRight()) ? enemyPosition.getRight() : enemyPosition.getLeft();
                else if (marioAtLeft(f))
                    nextPosition = getModel().hasStructureBelow(enemyPosition.getLeft()) ? enemyPosition.getLeft() : enemyPosition.getRight();
                else
                    nextPosition = (int) (Math.random() * 2) == 1 ? enemyPosition.getRight() : enemyPosition.getLeft();

                moveFireEnemy(f, nextPosition);
            }
            this.lastMove = time;
        }
    }

    public boolean isNearMario(FireEnemy fireEnemy){
        return fireEnemy.getPosition().getY() == getModel().getMario().getPosition().getY();
    }

    public boolean marioAtLeft(FireEnemy fireEnemy){
        return isNearMario(fireEnemy) && getModel().getMario().getPosition().getX() < fireEnemy.getPosition().getX();
    }

    public boolean marioAtRight(FireEnemy fireEnemy){
        return isNearMario(fireEnemy) && getModel().getMario().getPosition().getX() > fireEnemy.getPosition().getX();
    }
}
