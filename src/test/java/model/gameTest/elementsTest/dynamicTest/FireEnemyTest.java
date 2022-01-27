package model.gameTest.elementsTest.dynamicTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.dynamic.FireEnemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FireEnemyTest {

    FireEnemy fireEnemy;
    Position p;

    @BeforeEach
    public void beforeEach() {
        p = new Position(1,1);
        fireEnemy = new FireEnemy(p);
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(p.getX(), fireEnemy.getPosition().getX());
        Assertions.assertEquals(p.getY(), fireEnemy.getPosition().getY());
    }

}
