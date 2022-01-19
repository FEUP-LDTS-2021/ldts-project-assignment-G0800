package com.ldts.donkeykong.controller.menu;

import com.ldts.donkeykong.Application;
import com.ldts.donkeykong.controller.Controller;
import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.arena.ArenaBuilderLoader;
import com.ldts.donkeykong.model.menu.Menu;
import com.ldts.donkeykong.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) application.setState(null);
                if (getModel().isSelectedStart()) application.setState(new GameState(new ArenaBuilderLoader(3).createArena()));
        }
    }
}
