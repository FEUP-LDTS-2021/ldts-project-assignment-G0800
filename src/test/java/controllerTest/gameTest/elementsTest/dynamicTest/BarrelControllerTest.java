package controllerTest.gameTest.elementsTest.dynamicTest;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.elements.dynamic.BarrelController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.Hammer;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Structure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BarrelControllerTest {

    Arena arena;
    BarrelController barrelController;
    Application app;

    private ArrayList<Barrel> createBarrels() {
        ArrayList<Barrel> barrels = new ArrayList<>();
        barrels.add(new Barrel(new Position(1,2),false));
        return barrels;
    }

    private ArrayList<Structure> createStructures() {
        ArrayList<Structure> structures = new ArrayList<>();
        Structure structureTop = new Structure(new Position(1,3),6);
        Structure structureBottom = new Structure(new Position(5,5),7);
        structures.add(structureTop);
        structures.add(structureBottom);
        return structures;
    }

    @BeforeAll
    public void createData() {
        app = Mockito.mock(Application.class);
        arena = new Arena(10,10);
        arena.setHammer(new Hammer(new Position(1,1)));
        arena.setBarrels(createBarrels());
        arena.setStructures(createStructures());
        barrelController = new BarrelController(arena);
    }

    @Test
    public void moveBarrelsTest() throws IOException {
        for (int i = 1; i <= 7; i++) {
            barrelController.step(app, GUI.ACTION.NONE,0);
        }
        Assertions.assertEquals(7,arena.getBarrels().get(0).getPosition().getX());
        Assertions.assertEquals(3,arena.getBarrels().get(0).getPosition().getY());
        for (int i = 1; i <= 3; i++) {
            barrelController.step(app, GUI.ACTION.NONE,0);
        }
        Assertions.assertEquals(5,arena.getBarrels().get(0).getPosition().getX());
        Assertions.assertEquals(4,arena.getBarrels().get(0).getPosition().getY());
        for (int i = 1; i <= 6 ; i++) {
            barrelController.step(app, GUI.ACTION.NONE,0);
        }
        Assertions.assertEquals(4,arena.getBarrels().get(0).getPosition().getX());
        Assertions.assertEquals(9,arena.getBarrels().get(0).getPosition().getY());
        for (int i = 1; i <= 4; i++) {
            barrelController.step(app, GUI.ACTION.NONE,0);
        }
        Assertions.assertEquals(0,arena.getBarrels().get(0).getPosition().getX());
        Assertions.assertEquals(9,arena.getBarrels().get(0).getPosition().getY());


    }

    @Test
    public void removeBarrelTest() throws IOException {
        Assertions.assertEquals(1,arena.getBarrels().size());
        barrelController.step(app, GUI.ACTION.NONE,0);
        Assertions.assertEquals(1,arena.getBarrels().size());
        barrelController.step(app, GUI.ACTION.NONE,0);
        Assertions.assertEquals(0,arena.getBarrels().size());
    }
}
