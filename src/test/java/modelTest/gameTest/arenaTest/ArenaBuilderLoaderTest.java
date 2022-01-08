package modelTest.gameTest.arenaTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.arena.ArenaBuilderLoader;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.Donkey;
import com.ldts.donkeykong.model.game.elements.dynamic.Hammer;
import com.ldts.donkeykong.model.game.elements.dynamic.Mario;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Ladder;
import com.ldts.donkeykong.model.game.elements.nonDynamic.OilBarrel;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Princess;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Structure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaBuilderLoaderTest {

    ArenaBuilderLoader abl;

    @BeforeEach
    public void helper() {
        int level = 1;
        try {
            abl = new ArenaBuilderLoader(level);
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
    }

    @Test
    public void createArenaLevelOneTest() {
        Arena arena = abl.createArena();
        Position princessPosition = new Position(1, 9);
        Princess p = new Princess(princessPosition);
        arena.setPrincess(p);
        Position donkeyPosition = new Position(2, 3);
        Donkey d = new Donkey(donkeyPosition);
        arena.setDonkey(d);
        Position barrel1, barrel2, barrel3, barrel4;
        barrel1 = new Position(1, 1);
        barrel2 = new Position(1, 2);
        barrel3 = new Position(2, 1);
        barrel4 = new Position(2, 2);
        Barrel b1 = new Barrel(barrel1, true);
        Barrel b2 = new Barrel(barrel2, false);
        Barrel b3 = new Barrel(barrel3, false);
        Barrel b4 = new Barrel(barrel4, false);
        List<Barrel> b = new ArrayList<>();
        b.add(b1);
        b.add(b2);
        b.add(b3);
        b.add(b4);
        arena.setBarrels(b);
        Position oilBarrelPosition = new Position(8, 1);
        OilBarrel ob = new OilBarrel(oilBarrelPosition);
        arena.setOilBarrel(ob);
        Position marioPosition = new Position(8, 5);
        Mario m = new Mario(marioPosition);
        arena.setMario(m);
        Position ladderTop, ladderMiddle1, ladderMiddle2, ladderBottom;
        ladderTop = new Position(1, 14);
        Ladder l1 = new Ladder(ladderTop, 24);
        ladderMiddle1 = new Position(4, 12);
        Ladder l2 = new Ladder(ladderMiddle1, 20);
        ladderMiddle2 = new Position(6, 5);
        Ladder l3 = new Ladder(ladderMiddle2, 11);
        ladderBottom = new Position(8, 13);
        Ladder l4 = new Ladder(ladderBottom, 23);
        List<Ladder> l = new ArrayList<>();
        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);
        arena.setLadders(l);
        Position hammerPosition = new Position(6, 15);
        Hammer h = new Hammer(hammerPosition);
        arena.setHammer(h);
        Structure structure1, structure2, structure3, structure4, structure5;
        structure1 = new Structure(new Position(2, 8), 3);
        structure2 = new Structure(new Position(3, 1), 5);
        structure3 = new Structure(new Position(3, 9), 8);
        structure4 = new Structure(new Position(5, 2), 9);
        structure5 = new Structure(new Position(7, 9), 8);
        List<Structure> s = new ArrayList<>();
        s.add(structure1);
        s.add(structure2);
        s.add(structure3);
        s.add(structure4);
        s.add(structure5);
        arena.setStructures(s);
        Assertions.assertEquals(4, arena.getBarrels().size());
        Assertions.assertEquals(4, arena.getLadders().size());
        Assertions.assertEquals(5, arena.getStructures().size());

        Assertions.assertEquals(arena.getPrincess().getPosition(), princessPosition);
        Assertions.assertEquals(arena.getDonkey().getPosition(), donkeyPosition);
        Assertions.assertEquals(arena.getMario().getPosition(), marioPosition);
        Assertions.assertEquals(arena.getHammer().getPosition(), hammerPosition);
        Assertions.assertEquals(arena.getOilBarrel().getPosition(), oilBarrelPosition);

        Assertions.assertEquals(arena.getBarrels().get(0).getPosition(), barrel1);
        Assertions.assertEquals(arena.getBarrels().get(1).getPosition(), barrel2);
        Assertions.assertEquals(arena.getBarrels().get(2).getPosition(), barrel3);
        Assertions.assertEquals(arena.getBarrels().get(3).getPosition(), barrel4);

        Assertions.assertEquals(arena.getLadders().get(0).getPosition(), ladderTop);
        Assertions.assertEquals(arena.getLadders().get(1).getPosition(), ladderMiddle1);
        Assertions.assertEquals(arena.getLadders().get(2).getPosition(), ladderMiddle2);
        Assertions.assertEquals(arena.getLadders().get(3).getPosition(), ladderBottom);

        Assertions.assertEquals(arena.getStructures().get(0).getPosition(), structure1.getPosition());
        Assertions.assertEquals(arena.getStructures().get(1).getPosition(), structure2.getPosition());
        Assertions.assertEquals(arena.getStructures().get(2).getPosition(), structure3.getPosition());
        Assertions.assertEquals(arena.getStructures().get(3).getPosition(), structure4.getPosition());
        Assertions.assertEquals(arena.getStructures().get(4).getPosition(), structure5.getPosition());
    }
}
