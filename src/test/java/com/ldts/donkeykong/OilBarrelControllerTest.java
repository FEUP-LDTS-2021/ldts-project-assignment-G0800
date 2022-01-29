package com.ldts.donkeykong;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.elements.nonDynamic.OilBarrelController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.nonDynamic.OilBarrel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OilBarrelControllerTest {

    @Test
    public void hasFieryBarrelTest() throws IOException {
        Application app = Mockito.mock(Application.class);
        List<Barrel> barrels = new ArrayList<>();
        barrels.add(new Barrel(new Position(0,1),true));
        barrels.add(new Barrel(new Position(2,3),false));
        barrels.add(new Barrel(new Position(0,1),false));

        Arena arena = new Arena(10,10);
        arena.setBarrels(barrels);
        arena.setOilBarrel(new OilBarrel(new Position(0,1)));

        OilBarrelController oilBarrelController = new OilBarrelController(arena);
        oilBarrelController.step(app, GUI.ACTION.NONE,0);
        Assertions.assertEquals(2,arena.getBarrels().size());
    }
}
