package controllerTest.gameTest.elementsTest.dynamicTest;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.elements.dynamic.BarrelController;
import com.ldts.donkeykong.controller.game.elements.dynamic.DonkeyController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.Mario;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Structure;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BarrelControllerTest {

    Arena arena;
    BarrelController barrelController;
    Application app;

    private ArrayList<Barrel> createBarrels() {
        ArrayList<Barrel> barrels = new ArrayList<>();
        barrels.add(new Barrel(new Position(0,0),false));
        return barrels;
    }

    private ArrayList<Structure> createStructures() {
        ArrayList<Structure> structures = new ArrayList<>();
        Structure structureTop = new Structure(new Position(0,3),7);
        Structure structureMiddle = new Structure(new Position(5,5),5);
        Structure structureBottom = new Structure(new Position(0,9),10);
        structures.add(structureTop);
        structures.add(structureMiddle);
        structures.add(structureBottom);
        return structures;
    }

    @BeforeEach
    public void createData() {
        app = Mockito.mock(Application.class);
        arena = new Arena(10,10);
        arena.setBarrels(createBarrels());
        arena.setStructures(createStructures());
        barrelController = new BarrelController(arena);
    }

    @Test
    public void moveAndRemoveBarrelsTest() throws IOException {
        long time = 351;
        //Move Barrels Test
        for (int i = 1; i <= 10; i++) {
            time+=time;
            barrelController.step(app, GUI.ACTION.NONE,time);
        }
        Assertions.assertEquals(7,arena.getBarrels().get(0).getPosition().getX());
        Assertions.assertEquals(3,arena.getBarrels().get(0).getPosition().getY());
        for (int i = 1; i <= 3; i++) {
            time+=time;
            barrelController.step(app, GUI.ACTION.NONE,time);
        }
        Assertions.assertEquals(5,arena.getBarrels().get(0).getPosition().getX());
        Assertions.assertEquals(4,arena.getBarrels().get(0).getPosition().getY());
        for (int i = 1; i <= 5 ; i++) {
            time+=time;
            barrelController.step(app, GUI.ACTION.NONE,time);
        }
        Assertions.assertEquals(4,arena.getBarrels().get(0).getPosition().getX());
        Assertions.assertEquals(8,arena.getBarrels().get(0).getPosition().getY());
        for (int i = 1; i <= 5; i++) {
            time+=time;
            barrelController.step(app, GUI.ACTION.NONE,time);
        }
        Assertions.assertEquals(9,arena.getBarrels().get(0).getPosition().getX());
        Assertions.assertEquals(8,arena.getBarrels().get(0).getPosition().getY());

        //Remove Barrel Test
        Assertions.assertEquals(1,arena.getBarrels().size());
        time+=time;
        barrelController.step(app, GUI.ACTION.NONE,time);
        Assertions.assertEquals(1,arena.getBarrels().size());
        time+=time;
        barrelController.step(app, GUI.ACTION.NONE,time);
        Assertions.assertEquals(0,arena.getBarrels().size());
    }

    @Test
    public void timedBarrelsTest() throws IOException {
         List<Barrel> barrels = new ArrayList<>();
         Barrel barrel1 = new Barrel(new Position(7,3),false);
         Barrel barrel2 = new Barrel(new Position(4,8),false);
         Barrel barrel3 = new Barrel(new Position(0,2),false);
         barrels.add(barrel1); barrels.add(barrel2); barrels.add(barrel3);
         arena.setBarrels(barrels);
         barrelController.step(app, GUI.ACTION.NONE, 351);
         Position p1 = new Position(7,4);
         Position p2 = new Position(5,8);
         Position p3 = new Position(1,2);
         Position p4 = new Position(8,4);
         Position p5 = new Position(6,8);
         Position p6 = new Position(2,2);
         Assertions.assertEquals(p1, barrel1.getPosition());
         Assertions.assertEquals(p2, barrel2.getPosition());
         Assertions.assertEquals(p3, barrel3.getPosition());
         barrelController.step(app, GUI.ACTION.NONE,702);
         Assertions.assertEquals(p4, barrel1.getPosition());
         Assertions.assertEquals(p5, barrel2.getPosition());
         Assertions.assertEquals(p6, barrel3.getPosition());
    }

    @Test
    public void setMarioAsDeadTest() throws IOException {
        long time = 351;
        Mario mario = new Mario(new Position(4,2));
        Barrel barrel = new Barrel(new Position(0,2),false);
        List<Barrel> barrels = new ArrayList<>();
        barrels.add(barrel);
        arena.setBarrels(barrels);
        arena.setMario(mario);
        Assertions.assertTrue(arena.getMario().isAlive());
        for (int i = 1; i <= 5; i++) {
            barrelController.step(app, GUI.ACTION.NONE, time);
            time+=time;
        }
        Assertions.assertFalse(arena.getMario().isAlive());
    }
}