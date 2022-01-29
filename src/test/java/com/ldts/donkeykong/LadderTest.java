package com.ldts.donkeykong;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Ladder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    public void constructorTest() {
        Ladder l = new Ladder(new Position(5,2),5);
        Assertions.assertEquals(5, l.getStairs().size());
        Assertions.assertEquals(2, l.getStairs().get(0).getPosition().getY());
        Assertions.assertEquals(1, l.getStairs().get(1).getPosition().getY());
        Assertions.assertEquals(0, l.getStairs().get(2).getPosition().getY());
        Assertions.assertEquals(-1, l.getStairs().get(3).getPosition().getY());
        Assertions.assertEquals(-2, l.getStairs().get(4).getPosition().getY());

        Ladder l2 = new Ladder(new Position(10,4),6);
        Assertions.assertEquals(6, l2.getStairs().size());
        Assertions.assertEquals(4, l2.getStairs().get(0).getPosition().getY());
        Assertions.assertEquals(3, l2.getStairs().get(1).getPosition().getY());
        Assertions.assertEquals(2, l2.getStairs().get(2).getPosition().getY());
        Assertions.assertEquals(1, l2.getStairs().get(3).getPosition().getY());
        Assertions.assertEquals(0, l2.getStairs().get(4).getPosition().getY());
        Assertions.assertEquals(-1, l2.getStairs().get(5).getPosition().getY());
        Assertions.assertEquals(10, l2.getStairs().get(0).getPosition().getX());
        Assertions.assertEquals(10, l2.getStairs().get(1).getPosition().getX());
    }
}