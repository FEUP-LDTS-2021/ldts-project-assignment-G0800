package com.ldts.donkeykong.controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.GameController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.DIRECTION;

import java.io.IOException;

public class BarrelController extends GameController {

    long lastTime;

    public BarrelController(Arena arena) {
        super(arena);
        this.lastTime = 0;
    }

    private void moveBarrels() {
        for(int i = 0; i < getModel().getBarrels().size(); i++) {
            moveBarrel(getModel().getBarrels().get(i));
        }
    }

    private void moveBarrel(Barrel barrel) {
        if(!getModel().isInArena(barrel.getPosition())) getModel().removeBarrel(barrel);

        if(getModel().getMario().getPosition().equals(barrel.getPosition())) getModel().getMario().setAsDead();

        if(barrel.getPosition().equals(new Position(getModel().getHeight()-1,getModel().getWidth()-1)))
            getModel().removeBarrel(barrel);

        else if(!getModel().isStructure(barrel.getPosition().getDown()) && getModel().isInArena(barrel.getPosition().getDown())) {

            barrel.setPosition(barrel.getPosition().getDown());
            if(!barrel.isFirstDrop()) {
                if(!barrelFalling(barrel) && barrel.getDirection().equals(DIRECTION.RIGHT)) barrel.changeDirection();
                else if(!barrelFalling(barrel) && barrel.getDirection().equals(DIRECTION.LEFT)) barrel.changeDirection();
            }

        } else if(barrel.getDirection().equals(DIRECTION.RIGHT)) {
            barrel.setPosition(barrel.getPosition().getRight());
            if(barrel.isFirstDrop()) barrel.deactivateFirstDrop();
        } else if (barrel.getDirection().equals(DIRECTION.LEFT)) {
            barrel.setPosition(barrel.getPosition().getLeft());
            if(barrel.isFirstDrop()) barrel.deactivateFirstDrop();
        }
    }

    private boolean barrelFalling(Barrel barrel) {
        return !getModel().isStructure(barrel.getPosition().getDown());
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if(time - lastTime > 350) {
            moveBarrels();
            this.lastTime = time;
        }
    }
}