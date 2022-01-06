package modelTest.gameTest.nonDynamicTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.nonDynamic.Princess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrincessTest {
    Princess princess;
    Position p;

    @BeforeEach
    public void beforeEach() {
        p = new Position(9,6);
        princess = new Princess(p);
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(p.getX(), princess.getPosition().getX());
        Assertions.assertEquals(p.getY(), princess.getPosition().getY());
    }
}
