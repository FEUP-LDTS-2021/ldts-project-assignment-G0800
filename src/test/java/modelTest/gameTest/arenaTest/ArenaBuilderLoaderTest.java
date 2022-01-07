package modelTest.gameTest.arenaTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.arena.ArenaBuilderLoader;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Structure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

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
        Position princessPosition = new Position(1,9);
        Position donkeyPosition = new Position(2,3);
        Position barrel1,barrel2,barrel3,barrel4;
        barrel1 = new Position(1,1);
        barrel2 = new Position(1,2);
        barrel3 = new Position(2,1);
        barrel4 = new Position(2,2);
        Position oilBarrelPosition = new Position(8,1);
        Position marioPosition = new Position(8,5);
        Position ladderTop,ladderMiddle1,ladderMiddle2,ladderBottom;
        ladderTop = new Position(1,14);
        ladderMiddle1 = new Position(4,12);
        ladderMiddle2 = new Position(6,5);
        ladderBottom = new Position(8,13);
        Position hammerPosition = new Position(6,15);
        Structure structure1,structure2,structure3,structure4,structure5;
        structure1 = new Structure(new Position(2,8),3);
        structure2 = new Structure(new Position(3,1),5);
        structure3 = new Structure(new Position(3,9),8);
        structure4 = new Structure(new Position(5,2),9);
        structure5 = new Structure(new Position(7,9),8);

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
