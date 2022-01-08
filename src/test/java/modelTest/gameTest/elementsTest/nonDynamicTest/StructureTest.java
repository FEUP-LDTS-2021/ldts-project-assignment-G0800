package modelTest.gameTest.elementsTest.nonDynamicTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Ladder;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Structure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StructureTest {

    Structure structure;
    Position p;

    @BeforeEach
    public void beforeEach() {
        p = new Position(2,2);
        structure = new Structure(p,5);
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(5, structure.getStairs().size());
        Assertions.assertEquals(2, structure.getStairs().get(0).getPosition().getX());
        Assertions.assertEquals(3, structure.getStairs().get(1).getPosition().getX());
        Assertions.assertEquals(4, structure.getStairs().get(2).getPosition().getX());
        Assertions.assertEquals(5, structure.getStairs().get(3).getPosition().getX());
        Assertions.assertEquals(6, structure.getStairs().get(4).getPosition().getX());

        Structure newStructure = new Structure(new Position(1,2),1);
        Assertions.assertEquals(1, newStructure.getStairs().size());
        Assertions.assertEquals(2, newStructure.getStairs().get(0).getPosition().getY());
        Assertions.assertNotEquals(1,newStructure.getStairs().get(0).getPosition().getY());
    }
}
