package modelTest.gameTest.arenaTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.Donkey;
import com.ldts.donkeykong.model.game.elements.dynamic.*;
import com.ldts.donkeykong.model.game.elements.nonDynamic.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;

public class ArenaTest {
    Arena arena;
    ArrayList<Barrel> barrels;
    ArrayList<FireEnemy> fireEnemies;
    ArrayList<Ladder> ladders;
    ArrayList<Structure> structures;
    Donkey donkey = new Donkey(new Position(1,1));
    Hammer hammer = new Hammer(new Position(8,8));
    Mario mario = new Mario(new Position(5,5));
    OilBarrel oilBarrel = new OilBarrel(new Position(3,4));
    Princess princess = new Princess(new Position(8,9));

    @BeforeEach
    public void helper() {
        arena = new Arena(10,10);
        barrels = new ArrayList<>();
        fireEnemies = new ArrayList<>();
        ladders = new ArrayList<>();
        arena.setDonkey(donkey);
        arena.setBarrels(createBarrels(barrels));
        arena.setFireEnemies(createFireEnemies(fireEnemies));
        arena.setLadders(createLadders(ladders));
        arena.setHammer(hammer);
        arena.setMario(mario);
        arena.setOilBarrel(oilBarrel);
        arena.setPrincess(princess);
    }

    private ArrayList<Barrel> createBarrels(ArrayList<Barrel> barrels) {
        Barrel barrel = Mockito.mock(Barrel.class);
        Mockito.when(barrel.getPosition()).thenReturn(new Position(1,1));
        for(int i = 0; i < 5; i++) {
            barrels.add(barrel);
        }
        return barrels;
    }

    private ArrayList<FireEnemy> createFireEnemies(ArrayList<FireEnemy> fireEnemies) {
        FireEnemy fireEnemy = Mockito.mock(FireEnemy.class);
        Mockito.when(fireEnemy.getPosition()).thenReturn(new Position(4,3));
        for(int i = 0; i < 5; i++) {
            fireEnemies.add(fireEnemy);
        }
        return fireEnemies;
    }

    private ArrayList<Stair> createStairs() {
        ArrayList<Stair> stairs = new ArrayList<>();
        for (int i = 7; i >= 1; i--) {
            stairs.add(new Stair(new Position(i,5)));
        }
        return stairs;
    }

    private ArrayList<Ladder> createLadders(ArrayList<Ladder> ladders) {
        Ladder ladder = Mockito.mock(Ladder.class);
        Mockito.when(ladder.getStairs()).thenReturn(createStairs());
        for(int i = 0; i < 5; i++) {
            ladders.add(ladder);
        }
        return ladders;
    }


    @Test
    public void getWidthTest() {
        Assertions.assertEquals(10,arena.getWidth());
    }

    @Test
    public void getHeightTest() {
        Assertions.assertEquals(10, arena.getHeight());
    }

    @Test
    public void getBarrelsTest() {
        ArrayList<Barrel> barrels = new ArrayList<>();
        Assertions.assertEquals(createBarrels(barrels), barrels);
    }

    @Test
    public void setBarrelsTest() {
        arena.setBarrels(createBarrels(barrels));
        Assertions.assertEquals(createBarrels(barrels), arena.getBarrels());
    }

    @Test
    public void getDonkeyTest() {
       Assertions.assertEquals(donkey, arena.getDonkey());
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
        Assertions.assertEquals(fireEnemies, arena.getFireEnemies());
    }

    @Test
    public void setFireEnemiesTest() {
        arena.setFireEnemies(createFireEnemies(fireEnemies));
        Assertions.assertEquals(createFireEnemies(fireEnemies),arena.getFireEnemies());
    }

    @Test
    public void getHammerTest() {
        Assertions.assertEquals(hammer,arena.getHammer());
    }

    @Test
    public void setHammerTest() {
        Hammer newHammer = new Hammer(new Position(5,3));
        arena.setHammer(newHammer);
        Assertions.assertEquals(newHammer, arena.getHammer());
    }

    @Test
    public void getMarioTest() {
        Assertions.assertEquals(mario,arena.getMario());
    }

    @Test
    public void setMarioTest() {
        Mario anotherMario = new Mario(new Position(2,3));
        arena.setMario(anotherMario);
        Assertions.assertEquals(anotherMario, arena.getMario());
    }

    @Test
    public void getOilBarrelTest() {
        Assertions.assertEquals(oilBarrel,arena.getOilBarrel());
    }

    @Test
    public void setOilBarrelTest() {
        OilBarrel newOilBarrel = new OilBarrel(new Position(3,7));
        arena.setOilBarrel(newOilBarrel);
        Assertions.assertEquals(newOilBarrel,arena.getOilBarrel());
    }

    @Test
    public void getPrincessTest() {
        Assertions.assertEquals(princess,arena.getPrincess());
    }

    @Test
    public void setPrincessTest() {
        Princess newPrincess = new Princess(new Position(7,8));
        arena.setPrincess(newPrincess);
        Assertions.assertEquals(newPrincess, arena.getPrincess());
    }


    @Test
    public void getLaddersTest() {
        Assertions.assertEquals(ladders,arena.getLadders());
    }

    @Test
    public void setLaddersTest() {
        ArrayList<Ladder> ladders = new ArrayList<>();
        arena.setLadders(createLadders(ladders));
        Assertions.assertEquals(createLadders(ladders),arena.getLadders());
    }

    @Test
    public void getStructuresTest() {

    }

    @Test
    public void setStructuresTest() {

    }

    @Test
    public void isEmptyTest() {
        Assertions.assertTrue(arena.isEmpty(new Position(7,8)));
        Assertions.assertFalse(arena.isEmpty(new Position(15,13)));
    }

    @Test
    public void isBarrelTest() {
        Assertions.assertTrue(arena.isBarrel(new Position(1,1)));
        Assertions.assertFalse(arena.isBarrel(new Position(3,5)));
    }

    @Test
    public void isFireEnemyTest() {
        Assertions.assertTrue(arena.isFireEnemy(new Position(4,3)));
        Assertions.assertFalse(arena.isFireEnemy(new Position(1,2)));
    }

    @Test
    public void isPrincessTest() {
        Assertions.assertTrue(arena.isPrincess(new Position(8,9)));
        Assertions.assertFalse(arena.isPrincess(new Position(2,3)));
    }

    @Test
    public void isLadderTest() {
        Assertions.assertTrue(arena.isLadder(new Position(1,5)));
        Assertions.assertTrue(arena.isLadder(new Position(2,5)));
        Assertions.assertTrue(arena.isLadder(new Position(3,5)));
        Assertions.assertTrue(arena.isLadder(new Position(4,5)));
        Assertions.assertTrue(arena.isLadder(new Position(5,5)));
        Assertions.assertTrue(arena.isLadder(new Position(6,5)));
        Assertions.assertTrue(arena.isLadder(new Position(7,5)));
        Assertions.assertFalse(arena.isLadder(new Position(8,5)));
        Assertions.assertFalse(arena.isLadder(new Position(9,5)));

    }

    @Test
    public void isHammerTest() {
        Assertions.assertTrue(arena.isHammer(new Position(8,8)));
        Assertions.assertFalse(arena.isHammer(new Position(4,3)));
        Assertions.assertFalse(arena.isHammer(new Position(7,4)));
    }
}
