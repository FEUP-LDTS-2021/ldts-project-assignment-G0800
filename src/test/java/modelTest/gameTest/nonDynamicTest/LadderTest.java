package modelTest.gameTest.nonDynamicTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.nonDynamic.Ladder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    public void constructorTest() {
        Ladder l = new Ladder(new Position(5,2),5);
        Assertions.assertEquals(l.getStairs().get(0).getPosition().getX(),5);
        Assertions.assertEquals(l.getStairs().get(1).getPosition().getX(),4);
        Assertions.assertEquals(l.getStairs().get(2).getPosition().getX(),3);
        Assertions.assertEquals(l.getStairs().get(3).getPosition().getX(),2);
        Assertions.assertEquals(l.getStairs().get(4).getPosition().getX(),1);


        Ladder l2 = new Ladder(new Position(10,4),6);
        Assertions.assertEquals(l2.getStairs().get(0).getPosition().getX(),10);
        Assertions.assertEquals(l2.getStairs().get(1).getPosition().getX(),9);
        Assertions.assertEquals(l2.getStairs().get(2).getPosition().getX(),8);
        Assertions.assertEquals(l2.getStairs().get(3).getPosition().getX(),7);
        Assertions.assertEquals(l2.getStairs().get(4).getPosition().getX(),6);
        Assertions.assertEquals(l2.getStairs().get(0).getPosition().getY(),4);
        Assertions.assertEquals(l2.getStairs().get(1).getPosition().getY(),4);
    }
}
