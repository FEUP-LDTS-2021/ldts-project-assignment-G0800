package modelTest.gameTest.elementsTest.nonDynamicTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.nonDynamic.OilBarrel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OilBarrelTest {
    OilBarrel oilBarrel;
    Position p;

    @BeforeEach
    public void beforeEach() {
        p = new Position(2,4);
        oilBarrel = new OilBarrel(p);
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(p.getX(), oilBarrel.getPosition().getX());
        Assertions.assertEquals(p.getY(), oilBarrel.getPosition().getY());
    }
}
