package controllerTest.gameTest.elementsTest.dynamicTest;

import com.ldts.donkeykong.controller.game.elements.dynamic.DonkeyController;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Donkey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class DonkeyControllerTest {
    @Test
    public void throwBarrelTest() {
        Arena arena = mock(Arena.class);
        Donkey donkey = mock(Donkey.class);
        arena.setDonkey(donkey);
        DonkeyController donkeyController = new DonkeyController(arena);

        donkeyController.throwBarrel();
        Assertions.assertEquals(1, arena.getBarrels().size());

        donkeyController.throwBarrel();
        Assertions.assertEquals(2, arena.getBarrels().size());
    }
}