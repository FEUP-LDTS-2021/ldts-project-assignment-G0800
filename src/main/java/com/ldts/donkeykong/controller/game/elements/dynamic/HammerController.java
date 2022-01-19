package com.ldts.donkeykong.controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.GameController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.FireEnemy;

import java.io.IOException;

public class HammerController extends GameController {
    private byte quantityOfHits = 5;
    public HammerController(Arena arena) {
        super(arena);
    }

    private boolean touchedBarrel(Barrel barrel) {
        return getModel().getHammer().getPosition().equals(barrel.getPosition());
    }

    private boolean touchedFireEnemy(FireEnemy fireEnemy) {
        return getModel().getHammer().getPosition().equals(fireEnemy.getPosition());
    }

    private void checkAllBarrels() {
        for(int i = 0; i < getModel().getBarrels().size(); i++) {
            if(touchedBarrel(getModel().getBarrels().get(i))) {
                getModel().removeBarrel(getModel().getBarrels().get(i));
                decreaseQuantityOfHits();
                break;
            }
        }
    }

    private void checkAllFireEnemies() {
        for (int i = 0; i < getModel().getFireEnemies().size(); i++) {
            if(touchedFireEnemy(getModel().getFireEnemies().get(i))) {
                getModel().removeFireEnemy(getModel().getFireEnemies().get(i));
                decreaseQuantityOfHits();
                break;
            }
        }
    }

    private void decreaseQuantityOfHits() {
        quantityOfHits--;
    }

    private void setHammerAsNull() {
        getModel().setHammer(null);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        if(getModel().getHammer() != null) {
            checkAllBarrels();
            checkAllFireEnemies();
            if(quantityOfHits <= 0) setHammerAsNull();
        }
    }
}