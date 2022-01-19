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

    @Override
    public void step(Application application, GUI.ACTION action, long time){
        if (time - lastMove > 350){

            for (FireEnemy f: getModel().getFireEnemies()){
                Position enemyPosition = f.getPosition();
                Position marioPosition = getModel().getMario().getPosition();
                Position nextPosition;

                if (enemyPosition.getY() == marioPosition.getY()){
                    if (enemyPosition.getX() < marioPosition.getX())
                        nextPosition = getModel().isStructure(enemyPosition.getRight().getDown()) ? enemyPosition.getRight() : enemyPosition.getLeft();
                    else
                        nextPosition = getModel().isStructure(enemyPosition.getLeft().getDown()) ? enemyPosition.getLeft() : enemyPosition.getRight();
                }

                else
                    nextPosition = (int) (Math.random() * 2) == 1 ? enemyPosition.getRight() : enemyPosition.getLeft();

                moveFireEnemy(f, nextPosition);
            }
            this.lastMove = time;
        }
    }

    public boolean touchedMario(FireEnemy fireEnemy){
        return fireEnemy.getPosition().equals(getModel().getMario().getPosition());
    }

    public void moveFireEnemy(FireEnemy fireEnemy, Position position){
        if (getModel().isInArena(position) && this.getModel().isStructure(position.getDown())){
            fireEnemy.setPosition(position);
            if (touchedMario(fireEnemy))
                getModel().getMario().setAsDead();
        }
    }
}
