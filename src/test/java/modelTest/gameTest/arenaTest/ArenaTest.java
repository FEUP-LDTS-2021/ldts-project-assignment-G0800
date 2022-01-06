package modelTest.gameTest.arenaTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.Donkey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class ArenaTest {
    Arena arena;
    ArrayList<Barrel> barrels;
    @BeforeEach
    public void helper() {
        arena = new Arena(10,10);
        barrels = new ArrayList<>();
        arena.setDonkey(new Donkey(new Position(1,1)));
        arena.setScore(0);
        arena.setBarrels(createBarrels(barrels));
    }

    public ArrayList<Barrel> createBarrels(ArrayList<Barrel> barrels) {
        Barrel barrel = Mockito.mock(Barrel.class);
        for(int i = 0; i < 5; i++) {
            Mockito.when(barrel.getPosition()).thenReturn(new Position(1,1));
            barrels.add(barrel);
        }
        return barrels;
    }

    @Test
    public void getWidthTest() {
        Assertions.assertEquals(10,arena.getWidth());
    }

    @Test
    public void setWidthTest() {
        arena.setWidth(70);
        Assertions.assertEquals(70, arena.getWidth());
    }

    @Test
    public void getHeightTest() {
        Assertions.assertEquals(10, arena.getHeight());
    }

    @Test
    public void setHeightTest() {
        arena.setHeight(50);
        Assertions.assertEquals(50, arena.getHeight());
    }

    @Test
    public void getBarrelsTest() {
        Assertions.assertEquals(1, arena.getBarrels().get(0).getPosition().getX());
        Assertions.assertEquals(1, arena.getBarrels().get(0).getPosition().getY());
    }

    @Test
    public void setBarrelsTest() {
        arena.setBarrels(createBarrels(barrels));
        Assertions.assertEquals(createBarrels(barrels), arena.getBarrels());
    }

    @Test
    public void getDonkeyTest() {
       Assertions.assertEquals(1, arena.getDonkey().getPosition().getX());
       Assertions.assertEquals(1, arena.getDonkey().getPosition().getY());
    }

    @Test
    public void setDonkeyTest() {
        Position p= new Position (8,50);
        arena.setDonkey(new Donkey(p));
        Assertions.assertEquals(8, arena.getDonkey().getPosition().getX());
        Assertions.assertEquals(50, arena.getDonkey().getPosition().getY());
    }

    @Test
    public void getFireEnemiesTest() {

    }

    @Test
    public void setFireEnemiesTest() {

    }

    @Test
    public void getHammerTest() {

    }

    @Test
    public void setHammerTest() {

    }

    @Test
    public void getMarioTest() {

    }

    @Test
    public void setMarioTest() {

    }

    @Test
    public void getOilBarrelTest() {

    }

    @Test
    public void setOilBarrelTest() {

    }

    @Test
    public void getPrincessTest() {

    }

    @Test
    public void setPrincessTest() {
        
    }
    
    @Test
    public void getScoreTest() {

    }

    @Test
    public void setScoreTest() {

    }

    @Test
    public void getLaddersTest() {

    }

    @Test
    public void setLaddersTest() {

    }

    @Test
    public void getStructuresTest() {

    }

    @Test
    public void setStructuresTest() {

    }

    @Test
    public void isEmptyTest() {

    }

    @Test
    public void isBarrelTest() {

    }

    @Test
    public void isFireEnemyTest() {

    }

    @Test
    public void isPrincessTest() {

    }

    @Test
    public void isLadderTest() {

    }

    @Test
    public void isHammerTest() {

    }
}
