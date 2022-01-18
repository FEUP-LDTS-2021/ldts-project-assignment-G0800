package com.ldts.donkeykong.controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.GameController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;

import java.io.IOException;

public class BarrelController extends GameController {

    Direction direction;
    long lastMove;

    public BarrelController(Arena arena) {
        super(arena);
        direction = Direction.RIGHT;
        lastMove = 0;
    }

    private void moveBarrels() {
        for(int i = 0; i < getModel().getBarrels().size(); i++) {
            moveBarrel(getModel().getBarrels().get(i));
        }
    }

    private void moveBarrel(Barrel barrel) {
        if(!getModel().isInArena(barrel.getPosition())) getModel().removeBarrel(barrel);

        if(barrel.getPosition().equals(new Position(getModel().getHeight()-1,getModel().getWidth()-1)))
            getModel().removeBarrel(barrel);

        else if(!getModel().isStructure(barrel.getPosition().getDown()) && getModel().isInArena(barrel.getPosition().getDown())) {

            barrel.setPosition(barrel.getPosition().getDown());
            if(!barrelFalling(barrel) && direction.equals(Direction.RIGHT)) direction = Direction.LEFT;
            else if(!barrelFalling(barrel) && direction.equals(Direction.LEFT)) direction = Direction.RIGHT;

        } else if(direction.equals(Direction.RIGHT)) {
            barrel.setPosition(barrel.getPosition().getRight());
        } else if (direction.equals(Direction.LEFT)) {
            barrel.setPosition(barrel.getPosition().getLeft());
        }
    }

    private boolean barrelFalling(Barrel barrel) {
        return !getModel().isStructure(barrel.getPosition().getDown());
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if (time - lastMove > 350) {
            moveBarrels();
            this.lastMove = time;
        }
    }

    enum Direction {LEFT,RIGHT}
}