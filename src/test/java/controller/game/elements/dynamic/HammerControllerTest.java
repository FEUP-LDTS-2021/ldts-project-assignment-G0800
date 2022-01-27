package controller.game.elements.dynamic;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.game.elements.dynamic.HammerController;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.FireEnemy;
import com.ldts.donkeykong.model.game.elements.dynamic.Hammer;
import com.ldts.donkeykong.model.game.elements.dynamic.Mario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HammerControllerTest {

    Arena arena;
    Mario mario;
    Hammer hammer;
    FireEnemy fireEnemy, fireEnemy2;
    List<FireEnemy> fireEnemies;
    HammerController hammerController;
    Application app;

    private ArrayList<Barrel> createBarrels() {
        ArrayList<Barrel> barrels = new ArrayList<>();
        barrels.add(new Barrel(new Position(1,4),false));
        for(int i = 0; i < 5; i++) {
            barrels.add(new Barrel(new Position(i,i+1),false));
        }
        return barrels;
    }

    @BeforeEach
    public void createData() {
        app = Mockito.mock(Application.class);
        arena = new Arena(10,10);
        arena.setBarrels(createBarrels());
        mario = new Mario(new Position(0,4));
        hammer = new Hammer(new Position(mario.getPosition().getX()+1,mario.getPosition().getY()));
        arena.setMario(mario);
        arena.setHammer(hammer);
        hammerController = new HammerController(arena);
        fireEnemy = new FireEnemy(new Position(hammer.getPosition()));
        fireEnemy2 = new FireEnemy(new Position(4,3));
        fireEnemies = new ArrayList<>();
        fireEnemies.add(fireEnemy); fireEnemies.add(fireEnemy2);
        arena.setFireEnemies(fireEnemies);
    }

    @Test
    public void touchedBarrelTest() throws IOException {
        hammerController.step(app, GUI.ACTION.NONE,0);
        for (int i = 1; i < hammerController.getModel().getBarrels().size(); i++) {
            hammerController.step(app, GUI.ACTION.NONE,0);
        }
        Assertions.assertEquals(5, hammerController.getModel().getBarrels().size());
    }

    @Test
    public void touchedFireEnemyTest() throws IOException {
        hammerController.step(app, GUI.ACTION.NONE,0);
        Assertions.assertEquals(1,hammerController.getModel().getFireEnemies().size());
    }

    @Test
    public void hammerAsNullTest() throws IOException {
        for (int i = 1; i <= 5; i++) {
            hammerController.step(app, GUI.ACTION.NONE,0);
        }
        Assertions.assertNotNull(hammerController.getModel().getHammer());
        Assertions.assertEquals(5, hammerController.getModel().getBarrels().size());
        Assertions.assertEquals(1, hammerController.getModel().getFireEnemies().size());
    }
}
