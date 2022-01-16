package controllerTest.gameTest.elementsTest.dynamicTest;

import com.ldts.donkeykong.controller.game.elements.dynamic.HammerController;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.Hammer;
import com.ldts.donkeykong.model.game.elements.dynamic.Mario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class HammerControllerTest {

    Arena arena;
    Mario mario;
    Hammer hammer;
    HammerController hammerController;

    private ArrayList<Barrel> createBarrels() {
        ArrayList<Barrel> barrels = new ArrayList<>();
        barrels.add(new Barrel(new Position(1,4),false));
        for(int i = 0; i < 5; i++) {
            barrels.add(new Barrel(new Position(i,i+1),false));
        }
        return barrels;
    }

    @BeforeEach
    public void createData() {
        arena = Mockito.mock(Arena.class);
        Mockito.when(arena.getBarrels()).thenReturn(createBarrels());
        mario = new Mario(new Position(0,4));
        hammer = new Hammer(new Position(mario.getPosition().getX()+1,mario.getPosition().getY()));
        Mockito.when(arena.getMario()).thenReturn(mario);
        Mockito.when(arena.getHammer()).thenReturn(hammer);
        hammerController = new HammerController(arena);
    }

    @Test
    public void touchedBarrelTest() {
        Assertions.assertTrue(hammerController.touchedBarrel(arena.getBarrels().get(0)));
        for (int i = 1; i < arena.getBarrels().size(); i++) {
            Assertions.assertFalse(hammerController.touchedBarrel(arena.getBarrels().get(i)));
        }
    }
}
