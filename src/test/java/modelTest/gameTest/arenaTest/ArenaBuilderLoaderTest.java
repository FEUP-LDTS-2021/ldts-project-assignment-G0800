package modelTest.gameTest.arenaTest;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.arena.ArenaBuilderLoader;
import com.ldts.donkeykong.model.game.elements.nonDynamic.*;
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
        int level = 2;
        try {
            abl = new ArenaBuilderLoader(level);
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
    }

    public List<Structure> createStructures(){
        List<Structure> structures = new ArrayList<>();
        structures.add(new Structure(new Position(1,1), 3));
        structures.add(new Structure(new Position(7,1), 3));
        structures.add(new Structure(new Position(0,3), 4));
        structures.add(new Structure(new Position(6,3), 10));
        structures.add(new Structure(new Position(1,5), 12));
        structures.add(new Structure(new Position(3,8), 13));
        structures.add(new Structure(new Position(3,11), 16));
        structures.add(new Structure(new Position(2,15), 5));
        structures.add(new Structure(new Position(6,17), 12));
        structures.add(new Structure(new Position(0,20), 19));

        return structures;

    }

    public List<Ladder> createLadders(){
        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder (new Position(8,2), 1));
        ladders.add(new Ladder (new Position(11, 4), 1));
        ladders.add(new Ladder (new Position(4, 7), 2));
        ladders.add(new Ladder (new Position(11, 10), 2));
        ladders.add(new Ladder (new Position(3, 14), 3));
        ladders.add(new Ladder (new Position(6,16), 1));
        ladders.add(new Ladder (new Position(12, 19), 2));
        return ladders;
    }


    @Test
    public void createArenaLevelTwoTest() {
        Arena arena = abl.createArena();

        Position princessPosition = new Position(9, 0);
        Assertions.assertEquals(princessPosition, arena.getPrincess().getPosition());

        Position donkeyPosition = new Position(3, 0);
        Assertions.assertEquals(arena.getDonkey().getPosition(), donkeyPosition);

        Position oilBarrelPosition = new Position(0, 19);
        Assertions.assertEquals(arena.getOilBarrel().getPosition(), oilBarrelPosition);

        Position marioPosition = new Position(4, 19);
        Assertions.assertEquals(arena.getMario().getPosition(), marioPosition);

        Position hammerPosition = new Position(15, 15);
        Assertions.assertEquals(arena.getHammer().getPosition(), hammerPosition);

        List<Structure> structures = createStructures();
        Assertions.assertEquals(10, arena.getStructures().size());
        for (int i=0; i < structures.size(); i++){
            Assertions.assertEquals(structures.get(i).getPosition(), arena.getStructures().get(i).getPosition());
            Assertions.assertEquals(structures.get(i).getStairs().size(), arena.getStructures().get(i).getStairs().size());
        }

        List<Ladder> ladders = createLadders();
        Assertions.assertEquals(7, arena.getLadders().size());
        for (int i=0; i < ladders.size(); i++){
            Assertions.assertEquals(ladders.get(i).getPosition(), arena.getLadders().get(i).getPosition());
            Assertions.assertEquals(ladders.get(i).getStairs().size(), arena.getLadders().get(i).getStairs().size());
        }

    }
}
