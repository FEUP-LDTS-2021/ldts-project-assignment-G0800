package controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.elements.dynamic.DonkeyController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Donkey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class DonkeyControllerTest {
    private DonkeyController controller;
    private Arena arena;
    private Application app;

    @BeforeEach
    void setUp() {
        Donkey donkey = new Donkey(new Position(3, 3));
        arena = new Arena(10,10);
        arena.setDonkey(donkey);

        controller = new DonkeyController(arena);

        app = Mockito.mock(Application.class);
    }

    @Test
    public void throwBarrelTest() throws IOException {
        controller.step(app, GUI.ACTION.NONE, 1000);
        Assertions.assertEquals(1, arena.getBarrels().size());

        controller.step(app, GUI.ACTION.NONE, 2000);
        Assertions.assertEquals(2, arena.getBarrels().size());
    }
}