package com.ldts.donkeykong.controller.game.elements.nonDynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.GameController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;

import java.io.IOException;

public class OilBarrelController extends GameController {

    public OilBarrelController(Arena arena) {
        super(arena);
    }

    private boolean hasFieryBarrel(Barrel barrel) {
        if(barrel.isFiery())
            return getModel().getOilBarrel().getPosition().equals(barrel.getPosition());
        else return false;
    }

    private void checkAllBarrels() {
        for(int i = 0; i < getModel().getBarrels().size(); i++) {
            if(hasFieryBarrel(getModel().getBarrels().get(i)))
                getModel().removeBarrel(getModel().getBarrels().get(i));
        }
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        checkAllBarrels();
    }
}
