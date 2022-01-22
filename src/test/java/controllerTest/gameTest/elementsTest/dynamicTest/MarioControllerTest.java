package controllerTest.gameTest.elementsTest.dynamicTest;

import com.ldts.donkeykong.controller.game.elements.dynamic.MarioController;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.FireEnemy;
import com.ldts.donkeykong.model.game.elements.dynamic.Hammer;
import com.ldts.donkeykong.model.game.elements.dynamic.Mario;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Ladder;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Princess;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Stair;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Structure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

public class MarioControllerTest {
    private Mario mario;
    private Arena arena;
    private MarioController marioController;


    @BeforeEach
    public void setUp(){
        arena = new Arena (20,20);

        marioController = new MarioController(arena);

        ArrayList<Stair> stairs1 = new ArrayList<>();
        stairs1.add (new Stair (new Position(0,14)));
        stairs1.add (new Stair (new Position(1,14)));
        stairs1.add (new Stair (new Position(2,14)));
        stairs1.add (new Stair (new Position(3,14)));
        stairs1.add (new Stair(new Position (4,14)));
        stairs1.add (new Stair(new Position (5,14)));
        stairs1.add (new Stair(new Position (6,14)));
        stairs1.add (new Stair(new Position (7,14)));
        Structure structure1 = mock (Structure.class);
        Mockito.when(structure1.getStairs()).thenReturn(stairs1);

        ArrayList<Stair> stairs2 = new ArrayList<>();
        stairs2.add (new Stair (new Position(1,8)));
        stairs2.add (new Stair (new Position(2,8)));
        stairs2.add (new Stair (new Position(3,8)));
        stairs2.add (new Stair(new Position (4,8)));
        stairs2.add (new Stair(new Position (5,8)));
        stairs2.add (new Stair(new Position (6,8)));
        stairs2.add (new Stair(new Position (7,8)));
        Structure structure2 = mock (Structure.class);
        Mockito.when(structure2.getStairs()).thenReturn(stairs2);

        ArrayList<Stair> stairs3 = new ArrayList<>();
        stairs3.add (new Stair (new Position(8,2)));
        stairs2.add (new Stair (new Position(9,2)));
        stairs2.add (new Stair (new Position(10,2)));
        stairs2.add (new Stair(new Position (11,2)));
        stairs2.add (new Stair(new Position (12,2)));
        stairs2.add (new Stair(new Position (13,2)));
        Structure structure3 = mock (Structure.class);
        Mockito.when(structure3.getStairs()).thenReturn(stairs3);

        ArrayList<Stair> stairs4 = new ArrayList<>();
        stairs4.add (new Stair (new Position(3,13)));
        stairs4.add (new Stair (new Position(3,12)));
        stairs4.add (new Stair (new Position(3,11)));
        stairs4.add (new Stair(new Position (3,10)));
        stairs4.add (new Stair(new Position (3,9)));
        Ladder ladder1 = mock(Ladder.class);
        Mockito.when(ladder1.getStairs()).thenReturn(stairs4);


        FireEnemy fireEnemy = mock(FireEnemy.class);
        Mockito.when(fireEnemy.getPosition()).thenReturn(new Position(5, 7));

        Princess princess = mock(Princess.class);
        Mockito.when((princess.getPosition())).thenReturn(new Position(11,1));

        arena.setStructures(Arrays.asList(structure1, structure2, structure3));
        arena.setLadders(Arrays.asList(ladder1));
        arena.setFireEnemies(Arrays.asList(fireEnemy));
        arena.setPrincess(princess);
    }

    @Test
    public void movementAboveStructure(){
        mario = new Mario(new Position(6,13));
        arena.setMario(mario);

        marioController.moveUp();
        Assertions.assertEquals(new Position(6, 13), mario.getPosition());

        marioController.moveDown();
        Assertions.assertEquals(new Position(6, 13), mario.getPosition());

        marioController.moveLeft();
        Assertions.assertEquals(new Position(5,13), mario.getPosition());

        marioController.moveRight();
        marioController.moveRight();
        Assertions.assertEquals(new Position(7,13), mario.getPosition());

        marioController.moveRight();
        Assertions.assertEquals(new Position(7,13), mario.getPosition());
    }

    @Test
    public void moveUpInLadder(){
        mario = new Mario(new Position(1,13));
        arena.setMario(mario);

        marioController.moveRight();
        marioController.moveRight();    //Reached the lowest stair of the ladder
        marioController.moveUp();
        Assertions.assertEquals(new Position(3,12), mario.getPosition());

        marioController.moveLeft();
        Assertions.assertEquals(new Position(3, 12), mario.getPosition());

        marioController.moveRight();
        Assertions.assertEquals(new Position(3,12), mario.getPosition());

        for (int i=0; i<3; i++)
            marioController.moveUp();
        Assertions.assertEquals(new Position(3,9), mario.getPosition());    //Reached the highest stair of the ladder

        marioController.moveUp();
        Assertions.assertEquals(new Position(3,8), mario.getPosition());    //Reached structure above the ladder

        marioController.moveUp();
        Assertions.assertEquals(new Position(3,7), mario.getPosition());    //Mario is above the structure

        marioController.moveLeft();
        Assertions.assertEquals(new Position(2,7), mario.getPosition());
    }


    @Test
    public void moveDownInLadder(){
        mario = new Mario(new Position(2,7));
        arena.setMario(mario);

        marioController.moveRight();
        Assertions.assertEquals(new Position(3,7), mario.getPosition());

        marioController.moveDown();
        Assertions.assertEquals(new Position(3,8), mario.getPosition());  //Reached structure above the ladder

        marioController.moveDown();
        Assertions.assertEquals(new Position(3,9), mario.getPosition());  //Reached the highest stair of the ladder

        for (int i=0; i<4; i++)
            marioController.moveDown();
        Assertions.assertEquals(new Position(3,13), mario.getPosition());  //Reached the lowest stair of the ladder

        marioController.moveLeft();
        Assertions.assertEquals(new Position(2,13), mario.getPosition());
    }

    @Test
    public void jumpTest(){
        mario = new Mario(new Position(6,13));
        Barrel barrel = mock (Barrel.class);
        Hammer hammer = new Hammer(new Position(10, 10));
        Mockito.when(barrel.getPosition()).thenReturn(new Position(6,13));

        arena.setMario(mario);
        arena.setBarrels(Arrays.asList(barrel));
        arena.setHammer(hammer);

        marioController.jump();
        Assertions.assertEquals(100, mario.getScore());
    }

    @Test
    public void MarioHasHammerAndMove1(){
        mario = new Mario(new Position(5,13));
        Hammer hammer = new Hammer(new Position(5, 12));

        arena.setMario(mario);
        Assertions.assertFalse(marioController.hasHammer());
        arena.setHammer(hammer);
        Assertions.assertFalse(marioController.hasHammer());

        marioController.jump();
        Assertions.assertTrue(marioController.hasHammer());
        Assertions.assertEquals(new Position(4,13), hammer.getPosition());

        marioController.moveLeft();
        Assertions.assertEquals(new Position(4, 13), mario.getPosition());
        Assertions.assertEquals(new Position(3,13), hammer.getPosition());

        marioController.moveLeft();
        Assertions.assertEquals(new Position(3, 13), mario.getPosition()); //Reached the lowest stair of the ladder
        Assertions.assertEquals(new Position(2,13), hammer.getPosition());

        marioController.moveUp();   //Try to climb the ladder while having a hammer (invalid move)
        Assertions.assertEquals(new Position(3,13), mario.getPosition());
        Assertions.assertEquals(new Position(2,13), hammer.getPosition());

        marioController.moveRight();
        Assertions.assertEquals(new Position(4,13), mario.getPosition());
        Assertions.assertEquals(new Position(5,13), hammer.getPosition());

    }

    @Test
    public void MarioHasHammerAndMove2(){
        mario = new Mario(new Position(4,7));
        Hammer hammer = new Hammer(new Position(4, 6));
        List<FireEnemy> fireEnemies = new ArrayList<>();

        arena.setFireEnemies(fireEnemies);
        arena.setMario(mario);
        Assertions.assertFalse(marioController.hasHammer());
        arena.setHammer(hammer);
        Assertions.assertFalse(marioController.hasHammer());

        marioController.jump();
        Assertions.assertTrue(marioController.hasHammer());
        Assertions.assertEquals(new Position(3,7), hammer.getPosition());

        marioController.moveLeft();
        Assertions.assertEquals(new Position(3, 7), mario.getPosition());
        Assertions.assertEquals(new Position(2,7), hammer.getPosition());

        marioController.moveDown();
        Assertions.assertEquals(new Position(3, 7), mario.getPosition());
        Assertions.assertEquals(new Position(2,7), hammer.getPosition());
    }

    @Test
    public void reachedPrincessAtLeftSideTest(){
        mario = new Mario(new Position(13,1));
        arena.setMario(mario);

        Assertions.assertFalse(marioController.reachedPrincess());

        marioController.moveLeft();
        Assertions.assertTrue(marioController.reachedPrincess());
    }

    @Test
    public void reachedPrincessAtRightSideTest(){
        mario = new Mario(new Position(9,1));
        arena.setMario(mario);

        Assertions.assertFalse(marioController.reachedPrincess());

        marioController.moveRight();
        Assertions.assertTrue(marioController.reachedPrincess());
    }

    @Test
    public void touchedBarrelTest(){
        mario = new Mario(new Position(4,7));
        Barrel barrel = mock (Barrel.class);
        Mockito.when(barrel.getPosition()).thenReturn(new Position(5,7));

        arena.setMario(mario);
        arena.setBarrels(Arrays.asList(barrel));

        Assertions.assertFalse(marioController.touchedBarrel());
        marioController.moveRight();
        Assertions.assertTrue(marioController.touchedBarrel());
        Assertions.assertFalse(mario.isAlive());
    }

    @Test
    public void touchedFireEnemy(){
        mario = new Mario(new Position(4,7));
        FireEnemy fireEnemy = mock (FireEnemy.class);
        Mockito.when(fireEnemy.getPosition()).thenReturn(new Position(5,7));

        arena.setMario(mario);
        arena.setFireEnemies(Arrays.asList(fireEnemy));

        Assertions.assertFalse(marioController.touchedFireEnemy());
        marioController.moveRight();
        Assertions.assertTrue(marioController.touchedFireEnemy());
        Assertions.assertFalse(mario.isAlive());
    }
}

