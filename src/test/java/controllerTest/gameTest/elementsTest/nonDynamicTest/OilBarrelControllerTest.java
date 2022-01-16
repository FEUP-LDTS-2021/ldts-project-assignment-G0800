package controllerTest.gameTest.elementsTest.nonDynamicTest;

import com.ldts.donkeykong.controller.game.elements.nonDynamic.OilBarrelController;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.nonDynamic.OilBarrel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class OilBarrelControllerTest {

    @Test
    public void hasFieryBarrelTest() {
        List<Barrel> barrels = new ArrayList<>();
        barrels.add(new Barrel(new Position(0,1),true));
        barrels.add(new Barrel(new Position(2,3),false));
        barrels.add(new Barrel(new Position(0,1),false));

        Arena arena = Mockito.mock(Arena.class);

        Mockito.when(arena.getOilBarrel()).thenReturn(new OilBarrel(new Position(0,1)));
        Mockito.when(arena.getBarrels()).thenReturn(barrels);

        OilBarrelController oilBarrelController = new OilBarrelController(arena);
        Assertions.assertTrue(oilBarrelController.hasFieryBarrel(barrels.get(0)));
        Assertions.assertFalse(oilBarrelController.hasFieryBarrel(barrels.get(1)));
        Assertions.assertFalse(oilBarrelController.hasFieryBarrel(barrels.get(2)));
    }
}
