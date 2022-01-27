package model.gameTest.elementsTest.nonDynamicTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Stair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StairTest {

    Stair stair;
    Position p;

    @BeforeEach
    public void beforeEach() {
        p = new Position(2,8);
        stair = new Stair(p);
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(p.getX(), stair.getPosition().getX());
        Assertions.assertEquals(p.getY(), stair.getPosition().getY());

    }
}
