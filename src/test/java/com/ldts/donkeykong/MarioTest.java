package com.ldts.donkeykong;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.dynamic.Mario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MarioTest {
    Position p;
    Mario mario;

    @BeforeEach
    public void beforeEach() {
        p = new Position(10,5);
        mario = new Mario(p);
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(p.getX(), mario.getPosition().getX());
        Assertions.assertEquals(p.getY(), mario.getPosition().getY());
    }

    @Test
    public void marioAliveTest() {
        Assertions.assertTrue(mario.isAlive());
    }

    @Test
    public void marioDeadTest() {
        mario.setAsDead();
        Assertions.assertFalse(mario.isAlive());
    }

    @Test
    public void marioGetScoreTest() {
        Assertions.assertEquals(0,mario.getScore());
    }

    @Test
    public void marioUpdateScoreTest() {
        mario.increaseScore();
        Assertions.assertEquals(100, mario.getScore());
        mario.increaseScore();
        mario.increaseScore();
        Assertions.assertEquals(300, mario.getScore());
        mario.increaseScore();
        Assertions.assertNotEquals(500, mario.getScore());
    }
}
