package modelTest.gameTest.dynamicTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.dynamic.Donkey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DonkeyTest {
    Donkey donkey;
    Position p;

    @BeforeEach
    public void beforeEach() {
        p = new Position(8,3);
        donkey = new Donkey(p);
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(p.getX(), donkey.getPosition().getX());
        Assertions.assertEquals(p.getY(), donkey.getPosition().getY());
    }
}

