package modelTest.baseTest;

import com.ldts.donkeykong.model.base.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {

    Position p;

    @BeforeEach
    public void helper() {
        p = new Position(7,3);
    }

    @Test
    public void getXTest() {
        Assertions.assertEquals(7,p.getX());
    }

    @Test
    public void getYTest() {
        Assertions.assertEquals(3, p.getY());
    }

    @Test
    public void setXTest() {
        p.setX(5);
        Assertions.assertEquals(5,p.getX());
    }

    @Test
    public void setYTest() {
        p.setY(9);
        Assertions.assertEquals(9,p.getY());
    }

    @Test
    public void getUpTest() {
        Assertions.assertEquals(6, p.getUp().getX());
        Assertions.assertEquals(3, p.getUp().getY());
    }

    @Test
    public void getDownTest() {
        Assertions.assertEquals(8, p.getDown().getX());
        Assertions.assertEquals(3, p.getDown().getX());
    }

    @Test
    public void getLeftTest() {
        Assertions.assertEquals(7, p.getLeft().getX());
        Assertions.assertEquals(2, p.getLeft().getY());
    }

    @Test
    public void getRightTest() {
        Assertions.assertEquals(7, p.getRight().getX());
        Assertions.assertEquals(4, p.getRight().getY());
    }

    @Test
    public void equalsTest() {
        Position positionToBeCompared = new Position(5,6);
        Assertions.assertNotSame(p, positionToBeCompared);
    }
}
