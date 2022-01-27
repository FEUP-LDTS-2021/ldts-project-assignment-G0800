package controller.game.elements.dynamic;

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

    @BeforeEach
    public void setUp(){
        app = mock(Application.class);

        mario = new Mario (new Position(7,7));

        arena = new Arena (10,10);
        arena.setMario(mario);

        enemyController = new FireEnemyController(arena);
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
        ArrayList<Stair> stairs1 = new ArrayList<>();
        stairs1.add (new Stair (new Position(0,4)));
        stairs1.add (new Stair (new Position(1,4)));
        stairs1.add (new Stair (new Position(2,4)));
        stairs1.add (new Stair (new Position(3,4)));
        stairs1.add (new Stair(new Position (4,4)));
        stairs1.add (new Stair(new Position (5,4)));
        stairs1.add (new Stair(new Position (6,4)));
        stairs1.add (new Stair(new Position (7,4)));
        stairs1.add (new Stair(new Position (8,4)));
        Structure structure1 = mock (Structure.class);
        Mockito.when(structure1.getStairs()).thenReturn(stairs1);

        arena.setStructures(Arrays.asList(structure1));

        FireEnemy fireEnemy = new FireEnemy(new Position(4,3));

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
        ArrayList<Stair> stairs2 = new ArrayList <>();
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
        ArrayList<Stair> stairs3 = new ArrayList<>();
        stairs3.add (new Stair (new Position(4,8)));
        stairs3.add (new Stair (new Position(5,8)));
        stairs3.add (new Stair (new Position(6,8)));
        stairs3.add (new Stair (new Position(7,8)));
        stairs3.add (new Stair (new Position(8,8)));
        stairs3.add (new Stair (new Position(9,8)));
        Structure structure3 = mock (Structure.class);
        Mockito.when(structure3.getStairs()).thenReturn(stairs3);

        ArrayList<Stair> stairs4 = new ArrayList<>();
        stairs4.add (new Stair (new Position(0,8)));
        stairs4.add (new Stair (new Position(1,8)));
        stairs4.add (new Stair (new Position(2,8)));
        Structure structure4 = mock (Structure.class);
        Mockito.when(structure4.getStairs()).thenReturn(stairs4);

        FireEnemy fireEnemy2 = new FireEnemy (new Position(6,7));
        FireEnemy fireEnemy3 = new FireEnemy (new Position(2,7));
        FireEnemy fireEnemy4 = new FireEnemy (new Position(4,7));

        arena.setStructures(Arrays.asList(structure3, structure4));
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

        ArrayList<Stair> stairs5 = new ArrayList<>();
        stairs5.add (new Stair (new Position(0,6)));
        stairs5.add (new Stair (new Position(1,6)));
        stairs5.add (new Stair (new Position(2,6)));
        stairs5.add (new Stair (new Position(3,6)));
        stairs5.add (new Stair (new Position(4,6)));
        stairs5.add (new Stair (new Position(5,6)));
        Structure structure5 = mock(Structure.class);
        Mockito.when(structure5.getStairs()).thenReturn(stairs5);

        ArrayList<Stair> stairs6 = new ArrayList<>();
        stairs6.add (new Stair (new Position(7,6)));
        stairs6.add (new Stair (new Position(8,6)));
        stairs6.add (new Stair (new Position(9,6)));
        Structure structure6 = mock(Structure.class);
        Mockito.when(structure6.getStairs()).thenReturn(stairs6);

        FireEnemy fireEnemy5 = new FireEnemy (new Position(3,5));
        FireEnemy fireEnemy6 = new FireEnemy (new Position(5,5));
        FireEnemy fireEnemy7 = new FireEnemy (new Position(7,5));

        arena.setStructures(Arrays.asList(structure5, structure6));
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

