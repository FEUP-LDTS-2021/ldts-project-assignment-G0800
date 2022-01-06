package modelTest.gameTest.elementsTest.nonDynamicTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Score;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreTest {
    Score score;
    Position p;

    @BeforeEach
    public void beforeEach() {
        p = new Position(0,20);
        score = new Score(p);
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(p.getX(), score.getPosition().getX());
        Assertions.assertEquals(p.getY(), score.getPosition().getY());
        Assertions.assertEquals(0, score.getScore());
    }

    @Test
    public void setScoreTest(){
        score.setScore(25);
        Assertions.assertEquals(25, score.getScore());

        score.setScore(2);
        Assertions.assertEquals(2, score.getScore());
    }


}
