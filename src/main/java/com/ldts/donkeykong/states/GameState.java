package com.ldts.donkeykong.states;

import com.ldts.donkeykong.controller.Controller;
import com.ldts.donkeykong.controller.game.arena.ArenaController;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.viewer.Viewer;
import com.ldts.donkeykong.viewer.game.arena.ArenaViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new ArenaViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
