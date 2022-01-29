package com.ldts.donkeykong;

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

public class ArenaTest {
    Arena arena;
    ArrayList<Barrel> barrels = new ArrayList<>();
    ArrayList<FireEnemy> fireEnemies = new ArrayList<>();
    ArrayList<Ladder> ladders = new ArrayList<>();
    ArrayList<Structure> structures = new ArrayList<>();
    Donkey donkey = Mockito.mock(Donkey.class);
    Hammer hammer = Mockito.mock(Hammer.class);
    Mario mario = Mockito.mock(Mario.class);
    OilBarrel oilBarrel = Mockito.mock(OilBarrel.class);
    Princess princess = Mockito.mock(Princess.class);

    @BeforeEach
    public void helper() {
        arena = new Arena(10,10);
        createBarrels1();
        createFireEnemies();
        createLadders();
        createStructure();
        Mockito.when(donkey.getPosition()).thenReturn(new Position(1,1));
        Mockito.when(hammer.getPosition()).thenReturn(new Position(8,8));
        Mockito.when(mario.getPosition()).thenReturn(new Position(3,4));
        Mockito.when(princess.getPosition()).thenReturn(new Position(8,9));

        arena.setDonkey(donkey);
        arena.setBarrels(barrels);
        arena.setFireEnemies(fireEnemies);
        arena.setLadders(ladders);
        arena.setStructures(structures);
        arena.setHammer(hammer);
        arena.setMario(mario);
        arena.setOilBarrel(oilBarrel);
        arena.setPrincess(princess);
    }

    private void createBarrels1() {
        Barrel barrel = Mockito.mock(Barrel.class);
        Mockito.when(barrel.getPosition()).thenReturn(new Position(1,1));
        for(int i = 0; i < 5; i++) {
            barrels.add(barrel);
        }
    }

    private ArrayList<Barrel> createBarrels2() {
        ArrayList<Barrel> b = new ArrayList<>();
        Barrel barrel = Mockito.mock(Barrel.class);
        Mockito.when(barrel.getPosition()).thenReturn(new Position(1,2));
        for(int i = 0; i < 2; i++) {
            b.add(barrel);
        }
        return b;
    }

    private void createFireEnemies() {
        FireEnemy fireEnemy = Mockito.mock(FireEnemy.class);
        Mockito.when(fireEnemy.getPosition()).thenReturn(new Position(4,3));
        for(int i = 0; i < 5; i++) {
            fireEnemies.add(fireEnemy);
        }
    }

    private void createFireEnemies2() {
        FireEnemy fireEnemy = Mockito.mock(FireEnemy.class);
        Mockito.when(fireEnemy.getPosition()).thenReturn(new Position(3,3));
        for(int i = 0; i < 2; i++) {
            fireEnemies.add(fireEnemy);
        }
    }

    private ArrayList<Stair> createStairs() {
        ArrayList<Stair> stairs = new ArrayList<>();
        for (int i = 7; i >= 1; i--) {
            stairs.add(new Stair(new Position(5,i)));
        }
        return stairs;
    }

    private ArrayList<Stair> createStairs2() {
        ArrayList<Stair> stairs = new ArrayList<>();
        for (int i = 3; i >= 1; i--) {
            stairs.add(new Stair(new Position(3,i)));
        }
        return stairs;
    }

    private ArrayList<Stair> createStairsStructure() {
        ArrayList<Stair> stairs = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            stairs.add(new Stair(new Position(i,5)));
        }
        return stairs;
    }

    private ArrayList<Stair> createStairsStructure2() {
        ArrayList<Stair> stairs = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            stairs.add(new Stair(new Position(i,7)));
        }
        return stairs;
    }

    private void createLadders() {
        Ladder ladder = Mockito.mock(Ladder.class);
        Mockito.when(ladder.getStairs()).thenReturn(createStairs());
        for(int i = 0; i < 5; i++) {
            ladders.add(ladder);
        }
    }

    private ArrayList<Ladder> createLadders2() {
        ArrayList<Ladder> l = new ArrayList<>();
        Ladder ladder = Mockito.mock(Ladder.class);
        Mockito.when(ladder.getStairs()).thenReturn(createStairs2());
        for(int i = 0; i < 2; i++) {
            l.add(ladder);
        }

        return l;
    }

    private void createStructure() {
        Structure structure = Mockito.mock(Structure.class);
        Mockito.when(structure.getStairs()).thenReturn(createStairsStructure());
        for(int i = 0; i < 3; i++) {
            structures.add(structure);
        }
    }

    private ArrayList<Structure> createStructure2() {
        ArrayList<Structure> s = new ArrayList<>();
        Structure structure = Mockito.mock(Structure.class);
        Mockito.when(structure.getStairs()).thenReturn(createStairsStructure2());
        for(int i = 0; i < 2; i++) {
            s.add(structure);
        }
        return s;
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
        Assertions.assertEquals(barrels, arena.getBarrels());
    }

    @Test
    public void setBarrelsTest() {
        ArrayList<Barrel> barrels2 = createBarrels2();
        arena.setBarrels(barrels2);

        Assertions.assertEquals(2, arena.getBarrels().size());
        Assertions.assertNotEquals(barrels, arena.getBarrels());
        Assertions.assertEquals(barrels2, arena.getBarrels());
    }

    @Test
    public void getDonkeyTest() {
        Assertions.assertEquals(donkey, arena.getDonkey());
    }

    @Test
    public void setDonkeyTest() {
        Donkey donkey2 = Mockito.mock(Donkey.class);
        Mockito.when(donkey2.getPosition()).thenReturn(new Position(8,50));

        arena.setDonkey(donkey2);
        Assertions.assertEquals(donkey2, arena.getDonkey());
        Assertions.assertEquals(8, arena.getDonkey().getPosition().getX());
        Assertions.assertEquals(50, arena.getDonkey().getPosition().getY());
    }

    @Test
    public void getFireEnemiesTest() {
        Assertions.assertEquals(fireEnemies, arena.getFireEnemies());
    }

    @Test
    public void setFireEnemiesTest() {
        fireEnemies.clear();
        createFireEnemies2();
        arena.setFireEnemies(fireEnemies);

        Assertions.assertEquals(2, arena.getFireEnemies().size());
        Assertions.assertEquals(fireEnemies, arena.getFireEnemies());
    }

    @Test
    public void getHammerTest() {
        Assertions.assertEquals(hammer,arena.getHammer());
    }

    @Test
    public void setHammerTest() {
        Hammer newHammer = Mockito.mock(Hammer.class);
        Mockito.when(newHammer.getPosition()).thenReturn(new Position(5,3));
        arena.setHammer(newHammer);

        Assertions.assertEquals(newHammer, arena.getHammer());
        Assertions.assertEquals(new Position(5,3), arena.getHammer().getPosition());
    }

    @Test
    public void getMarioTest() {
        Assertions.assertEquals(mario,arena.getMario());
    }

    @Test
    public void setMarioTest() {
        Mario anotherMario = Mockito.mock(Mario.class);
        Mockito.when(anotherMario.getPosition()).thenReturn(new Position(2,3));
        arena.setMario(anotherMario);

        Assertions.assertEquals(anotherMario, arena.getMario());
        Assertions.assertEquals(new Position(2,3), arena.getMario().getPosition());
    }

    @Test
    public void getOilBarrelTest() {
        Assertions.assertEquals(oilBarrel,arena.getOilBarrel());
    }

    @Test
    public void setOilBarrelTest() {
        OilBarrel newOilBarrel = Mockito.mock(OilBarrel.class);
        Mockito.when(newOilBarrel.getPosition()).thenReturn(new Position(3,7));
        arena.setOilBarrel(newOilBarrel);

        Assertions.assertEquals(newOilBarrel,arena.getOilBarrel());
        Assertions.assertEquals(new Position(3,7), arena.getOilBarrel().getPosition());
    }

    @Test
    public void getPrincessTest() {
        Assertions.assertEquals(princess,arena.getPrincess());
    }

    @Test
    public void setPrincessTest() {
        Princess newPrincess = Mockito.mock(Princess.class);
        Mockito.when(newPrincess.getPosition()).thenReturn(new Position(7,8));
        arena.setPrincess(newPrincess);

        Assertions.assertEquals(newPrincess, arena.getPrincess());
        Assertions.assertEquals(new Position(7,8), arena.getPrincess().getPosition());
    }


    @Test
    public void getLaddersTest() {
        Assertions.assertEquals(ladders,arena.getLadders());
    }

    @Test
    public void setLaddersTest() {
        ArrayList<Ladder> ladders2 = createLadders2();
        arena.setLadders(ladders2);

        Assertions.assertEquals(2, arena.getLadders().size());
        Assertions.assertNotEquals(ladders, arena.getLadders());
        Assertions.assertEquals(ladders2,arena.getLadders());
    }

    @Test
    public void getStructuresTest() {
        Assertions.assertEquals(structures, arena.getStructures());
    }

    @Test
    public void setStructuresTest() {
        structures.clear();
        ArrayList<Structure> structures2 = createStructure2();
        arena.setStructures(structures2);

        Assertions.assertEquals(2,arena.getStructures().size());
        Assertions.assertNotEquals(structures, arena.getStructures());
        Assertions.assertEquals(structures2, arena.getStructures());
    }

    @Test
    public void isEmptyTest() {
        Assertions.assertTrue(arena.isInArena(new Position(7,8)));
        Assertions.assertFalse(arena.isInArena(new Position(15,13)));
        Assertions.assertFalse(arena.isInArena(new Position(0,10)));

        Assertions.assertFalse(arena.isInArena(new Position(0,-1)));
        Assertions.assertFalse(arena.isInArena(new Position(-1,-1)));
        Assertions.assertFalse(arena.isInArena(new Position(-1,0)));

        Assertions.assertFalse(arena.isInArena(new Position(10,0)));
        Assertions.assertFalse(arena.isInArena(new Position(9,-1)));
        Assertions.assertFalse(arena.isInArena(new Position(10,-1)));

        Assertions.assertFalse(arena.isInArena(new Position(-1,9)));
        Assertions.assertFalse(arena.isInArena(new Position(-1,10)));
        Assertions.assertFalse(arena.isInArena(new Position(0,10)));

        Assertions.assertFalse(arena.isInArena(new Position(10,9)));
        Assertions.assertFalse(arena.isInArena(new Position(10,10)));
        Assertions.assertFalse(arena.isInArena(new Position(9,10)));

        Assertions.assertTrue(arena.isInArena(new Position(0,0)));
        Assertions.assertTrue(arena.isInArena(new Position(9,0)));
        Assertions.assertTrue(arena.isInArena(new Position(0,9)));
        Assertions.assertTrue(arena.isInArena(new Position(9,9)));
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
        Assertions.assertFalse(arena.isLadder(new Position(5,9)));
        Assertions.assertFalse(arena.isLadder(new Position(5,8)));

        Assertions.assertTrue(arena.isLadder(new Position(5,7)));
        Assertions.assertTrue(arena.isLadder(new Position(5,6)));
        Assertions.assertTrue(arena.isLadder(new Position(5,5)));
        Assertions.assertTrue(arena.isLadder(new Position(5,4)));
        Assertions.assertTrue(arena.isLadder(new Position(5,3)));
        Assertions.assertTrue(arena.isLadder(new Position(5,2)));
        Assertions.assertTrue(arena.isLadder(new Position(5,1)));

        Assertions.assertFalse(arena.isLadder(new Position(5,0)));
        Assertions.assertFalse(arena.isLadder(new Position(5,-1)));
    }

    @Test
    public void isStructure(){
        Assertions.assertFalse(arena.isStructure(new Position(-1,5)));
        Assertions.assertFalse(arena.isStructure(new Position(0,5)));

        Assertions.assertTrue(arena.isStructure(new Position(1,5)));
        Assertions.assertTrue(arena.isStructure(new Position(2,5)));
        Assertions.assertTrue(arena.isStructure(new Position(3,5)));
        Assertions.assertTrue(arena.isStructure(new Position(4,5)));
        Assertions.assertTrue(arena.isStructure(new Position(5,5)));
        Assertions.assertTrue(arena.isStructure(new Position(6,5)));
        Assertions.assertTrue(arena.isStructure(new Position(7,5)));

        Assertions.assertFalse(arena.isStructure(new Position(8,5)));
        Assertions.assertFalse(arena.isStructure(new Position(9,5)));
    }

    @Test
    public void isHammerTest() {
        Assertions.assertTrue(arena.isHammer(new Position(8,8)));
        Assertions.assertFalse(arena.isHammer(new Position(4,3)));
        Assertions.assertFalse(arena.isHammer(new Position(7,4)));
    }

    @Test
    public void hasStructureBelowTest(){
        Assertions.assertFalse(arena.hasStructureBelow(new Position(-1,4)));
        Assertions.assertFalse(arena.hasStructureBelow(new Position(0,4)));

        Assertions.assertTrue(arena.hasStructureBelow(new Position(1,4)));
        Assertions.assertTrue(arena.hasStructureBelow(new Position(2,4)));
        Assertions.assertTrue(arena.hasStructureBelow(new Position(3,4)));
        Assertions.assertTrue(arena.hasStructureBelow(new Position(4,4)));
        Assertions.assertTrue(arena.hasStructureBelow(new Position(5,4)));
        Assertions.assertTrue(arena.hasStructureBelow(new Position(6,4)));
        Assertions.assertTrue(arena.hasStructureBelow(new Position(7,4)));

        Assertions.assertFalse(arena.hasStructureBelow(new Position(8,4)));
        Assertions.assertFalse(arena.hasStructureBelow(new Position(9,4)));

        Assertions.assertFalse(arena.hasStructureBelow(new Position(1,5)));
        Assertions.assertFalse(arena.hasStructureBelow(new Position(4,5)));
        Assertions.assertFalse(arena.hasStructureBelow(new Position(7,5)));

    }

}
