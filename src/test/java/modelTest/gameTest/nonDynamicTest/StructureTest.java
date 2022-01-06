package modelTest.gameTest.nonDynamicTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.nonDynamic.Structure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StructureTest {

    Structure structure;
    Position p;

    @BeforeEach
    public void beforeEach() {
        p = new Position(2,8);
        structure = new Structure(p);
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(p.getX(), structure.getPosition().getX());
        Assertions.assertEquals(p.getY(), structure.getPosition().getY());
    }
}
