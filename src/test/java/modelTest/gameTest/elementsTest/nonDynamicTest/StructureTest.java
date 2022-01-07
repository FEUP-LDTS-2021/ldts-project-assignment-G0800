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
        Assertions.assertEquals(structure.getStairs().get(0).getPosition().getY(),2);
        Assertions.assertEquals(structure.getStairs().get(1).getPosition().getY(),3);
        Assertions.assertEquals(structure.getStairs().get(2).getPosition().getY(),4);
        Assertions.assertEquals(structure.getStairs().get(3).getPosition().getY(),5);
        Assertions.assertEquals(structure.getStairs().get(4).getPosition().getY(),6);

        Structure newStructure = new Structure(new Position(1,2),1);
        Assertions.assertEquals(newStructure.getStairs().get(0).getPosition().getY(), 2);
        Assertions.assertNotEquals(newStructure.getStairs().get(0).getPosition().getY(), 1);
    }
}
