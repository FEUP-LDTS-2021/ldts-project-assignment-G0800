package modelTest.gameTest.elementsTest.dynamicTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BarrelTest {
    Barrel barrel, nonFieryBarrel;
    Position p;

    @BeforeEach
    public void beforeEach() {
        p = new Position(2,3);
        barrel = new Barrel(p,true);
        nonFieryBarrel = new Barrel(p, false);
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(p.getX(), barrel.getPosition().getX());
        Assertions.assertEquals(p.getY(), barrel.getPosition().getY());
        Assertions.assertTrue(barrel.isFiery());
    }

    @Test
    public void isFieryTest() {
        Assertions.assertFalse(nonFieryBarrel.isFiery());
    }
}