package controllerTest.gameTest.elementsTest.dynamicTest;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.elements.dynamic.FireEnemyController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.FireEnemy;
import com.ldts.donkeykong.model.game.elements.dynamic.Mario;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Stair;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Structure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;

public class FireEnemyControllerTest {
    private Application app;
    private Mario mario;
    private Arena arena;
    private FireEnemyController enemyController;
    private ArrayList<Stair> stairs1, stairs2;
    private final Structure structure1 = mock (Structure.class);
    private final Structure structure2 = mock (Structure.class);

    @BeforeEach
    public void setUp(){
        app = mock(Application.class);
        mario = new Mario (new Position(7,7));
        arena = new Arena (10,10);
        arena.setMario(mario);
        enemyController = new FireEnemyController(arena);
        stairs1 = new ArrayList<>();
        stairs2 = new ArrayList<>();
    }

    @Test
    void touchedMarioAtLeft(){
        FireEnemy fireEnemy = new FireEnemy(new Position(8,7));
        arena.setFireEnemies(Arrays.asList(fireEnemy));

        Assertions.assertFalse(enemyController.touchedMario(fireEnemy));
    }

    @Test
    void touchedMarioAtRight(){
        FireEnemy fireEnemy = new FireEnemy(new Position(6,7));
        arena.setFireEnemies(Arrays.asList(fireEnemy));

        Assertions.assertFalse(enemyController.touchedMario(fireEnemy));
    }

    @Test
    void touchedMarioIsAbove(){
        FireEnemy fireEnemy = new FireEnemy(new Position(7,8));
        arena.setFireEnemies(Arrays.asList(fireEnemy));

        Assertions.assertFalse(enemyController.touchedMario(fireEnemy));
    }

    @Test
    void touchedMarioTest(){
        FireEnemy fireEnemy = new FireEnemy(new Position(7,7));
        arena.setFireEnemies(Arrays.asList(fireEnemy));

        Assertions.assertTrue(enemyController.touchedMario(fireEnemy));
    }


    @Test
    void moveFireEnemy() {
        for (int i=0; i<=8; i++) {
            stairs1.add(new Stair(new Position(i, 4)));
        }

        Mockito.when(structure1.getStairs()).thenReturn(stairs1);
        FireEnemy fireEnemy = new FireEnemy(new Position(4,3));

        arena.setStructures(Arrays.asList(structure1));
        arena.setFireEnemies(Arrays.asList(fireEnemy));

        enemyController.step(app, GUI.ACTION.NONE, 350);
        Assertions.assertEquals(new Position(4,3), fireEnemy.getPosition());

        enemyController.step(app, GUI.ACTION.NONE, 700);
        Assertions.assertNotEquals(new Position(4,3), fireEnemy.getPosition());
        Position lastPosition = fireEnemy.getPosition();

        enemyController.step(app, GUI.ACTION.NONE, 1051);
        Assertions.assertNotEquals(lastPosition, fireEnemy.getPosition());
        lastPosition = fireEnemy.getPosition();

        enemyController.step(app, GUI.ACTION.NONE, 2100);
        Assertions.assertNotEquals(lastPosition, fireEnemy.getPosition());
    }

    @Test
    public void moveFireEnemyStuck(){
        stairs2.add(new Stair (new Position (8,2)));
        Structure structure2 = mock (Structure.class);
        Mockito.when(structure2.getStairs()).thenReturn(stairs2);

        arena.setStructures(Arrays.asList(structure2));

        FireEnemy fireEnemyStuck = new FireEnemy(new Position(8,1));

        arena.setFireEnemies(Arrays.asList(fireEnemyStuck));

        for (int i=0; i<10; i++)
            enemyController.step(app, GUI.ACTION.NONE, 1000);

        Assertions.assertEquals(new Position(8,1), fireEnemyStuck.getPosition());
    }

    @Test
    public void moveFireEnemyLeftSideOfMario(){
        for (int i=4; i<=9; i++){
            stairs1.add (new Stair (new Position(i,8)));
        }
        Mockito.when(structure1.getStairs()).thenReturn(stairs1);

        for (int i=0; i<=2; i++){
            stairs2.add (new Stair (new Position(i,8)));
        }
        Mockito.when(structure2.getStairs()).thenReturn(stairs2);

        FireEnemy fireEnemy2 = new FireEnemy (new Position(6,7));
        FireEnemy fireEnemy3 = new FireEnemy (new Position(2,7));
        FireEnemy fireEnemy4 = new FireEnemy (new Position(4,7));

        arena.setStructures(Arrays.asList(structure1, structure2));
        arena.setFireEnemies(Arrays.asList(fireEnemy2, fireEnemy3, fireEnemy4));

        enemyController.step(app, GUI.ACTION.NONE, 349);
        Assertions.assertTrue(mario.isAlive());
        Assertions.assertEquals(new Position(6,7), fireEnemy2.getPosition());
        Assertions.assertEquals(new Position(2,7), fireEnemy3.getPosition());
        Assertions.assertEquals(new Position(4,7), fireEnemy4.getPosition());

        enemyController.step(app, GUI.ACTION.NONE, 1000);
        Assertions.assertFalse(mario.isAlive());
        Assertions.assertEquals(new Position(7,7), fireEnemy2.getPosition());
        Assertions.assertEquals(new Position(1,7), fireEnemy3.getPosition());
        Assertions.assertEquals(new Position(5,7), fireEnemy4.getPosition());
    }

    @Test
    public void moveFireEnemyRightSideOfMario(){
        mario.setPosition(new Position(2, 5));

        for (int i=0; i<=5; i++){
            stairs1.add (new Stair (new Position(i,6)));
        }
        Mockito.when(structure1.getStairs()).thenReturn(stairs1);

        for (int i=7; i<=9; i++){
            stairs2.add (new Stair (new Position(i,6)));
        }
        Mockito.when(structure2.getStairs()).thenReturn(stairs2);

        FireEnemy fireEnemy5 = new FireEnemy (new Position(3,5));
        FireEnemy fireEnemy6 = new FireEnemy (new Position(5,5));
        FireEnemy fireEnemy7 = new FireEnemy (new Position(7,5));

        arena.setStructures(Arrays.asList(structure1, structure2));
        arena.setFireEnemies(Arrays.asList(fireEnemy5, fireEnemy6, fireEnemy7));

        enemyController.step(app, GUI.ACTION.NONE, 349);
        Assertions.assertTrue(mario.isAlive());
        Assertions.assertEquals(new Position(3,5), fireEnemy5.getPosition());
        Assertions.assertEquals(new Position(5,5), fireEnemy6.getPosition());
        Assertions.assertEquals(new Position(7,5), fireEnemy7.getPosition());

        enemyController.step(app, GUI.ACTION.NONE, 1000);
        Assertions.assertFalse(mario.isAlive());
        Assertions.assertEquals(new Position(2,5), fireEnemy5.getPosition());
        Assertions.assertEquals(new Position(4,5), fireEnemy6.getPosition());
        Assertions.assertEquals(new Position(8,5), fireEnemy7.getPosition());
    }
}

