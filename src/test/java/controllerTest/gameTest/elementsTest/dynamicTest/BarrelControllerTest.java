package controllerTest.gameTest.elementsTest.dynamicTest;

import com.ldts.donkeykong.controller.game.elements.dynamic.BarrelController;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.Hammer;
import com.ldts.donkeykong.model.game.elements.dynamic.Mario;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Structure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BarrelControllerTest {

    Arena arena;
    Hammer hammer;
    Mario mario;
    BarrelController barrelController;

    private ArrayList<Barrel> createBarrels() {
        ArrayList<Barrel> barrels = new ArrayList<>();
        barrels.add(new Barrel(new Position(2,1),false));
        return barrels;
    }

    private ArrayList<Structure> createStructures() {
        ArrayList<Structure> structures = new ArrayList<>();
        Structure structureTop = new Structure(new Position(3,1),6);
        Structure structureBottom = new Structure(new Position(5,5),6);
        structures.add(structureTop);
        structures.add(structureBottom);
        return structures;
    }

    @BeforeAll
    public void createData() {
        arena = Mockito.mock(Arena.class);
        Mockito.when(arena.getBarrels()).thenReturn(createBarrels());
        Mockito.when(arena.getWidth()).thenReturn(10);
        Mockito.when(arena.getHeight()).thenReturn(10);
        Mockito.when(arena.getStructures()).thenReturn(createStructures());
        mario = new Mario(new Position(0,4));
        hammer = new Hammer(new Position(mario.getPosition().getX()+1,mario.getPosition().getY()));
        Mockito.when(arena.getMario()).thenReturn(mario);
        Mockito.when(arena.getHammer()).thenReturn(hammer);
        barrelController = new BarrelController(arena);
    }

    @Test
    public void moveBarrelsTest() {
        for (int i = 1; i <= 7; i++) { //Move barrel 7 times
            barrelController.moveBarrels();
        }
        Assertions.assertEquals(3,arena.getBarrels().get(0).getPosition().getX());
        Assertions.assertEquals(7,arena.getBarrels().get(0).getPosition().getY());
        for (int i = 1; i <= 3; i++) { //Move barrel 3 times
            barrelController.moveBarrels();
        }
        Assertions.assertEquals(5,arena.getBarrels().get(0).getPosition().getX());
        Assertions.assertEquals(4,arena.getBarrels().get(0).getPosition().getY());
        barrelController.moveBarrels();
        Assertions.assertEquals(9,arena.getBarrels().get(0).getPosition().getX());
        Assertions.assertEquals(4,arena.getBarrels().get(0).getPosition().getY());
        for (int i = 1; i <= 5; i++) {
            barrelController.moveBarrels();
        }
        Assertions.assertEquals(9,arena.getBarrels().get(0).getPosition().getX());
        Assertions.assertEquals(8,arena.getBarrels().get(0).getPosition().getY());
    }

    @Test
    public void removeBarrelTest() {
        Assertions.assertEquals(1,arena.getBarrels().size());
        barrelController.moveBarrels();
        Assertions.assertEquals(0,arena.getBarrels().size());
    }
}
