package com.ldts.donkeykong.controller.game;

import com.ldts.donkeykong.controller.Controller;
import com.ldts.donkeykong.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}