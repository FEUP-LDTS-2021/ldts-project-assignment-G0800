package com.ldts.donkeykong;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.dynamic.Hammer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HammerTest {

    Position p;
    Hammer hammer;

    @BeforeEach
    public void beforeEach() {
        p = new Position(8,6);
        hammer = new Hammer(p);
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(p.getX(), hammer.getPosition().getX());
        Assertions.assertEquals(p.getY(), hammer.getPosition().getY());
    }
}
