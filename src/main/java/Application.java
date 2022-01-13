import com.ldts.donkeykong.gui.LanternaGUI;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.arena.ArenaBuilderLoader;
import com.ldts.donkeykong.viewer.game.arena.ArenaViewer;
import com.ldts.donkeykong.viewer.menu.MenuViewer;
import com.ldts.donkeykong.model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args) {
        try {
            LanternaGUI gui = new LanternaGUI(20,20);
            //Arena arena = new ArenaBuilderLoader(1).createArena();
            //ArenaViewer view = new ArenaViewer(arena);
            Menu menu = new Menu();
            MenuViewer menuViewer = new MenuViewer(menu);
            menuViewer.draw(gui);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

    }
}
