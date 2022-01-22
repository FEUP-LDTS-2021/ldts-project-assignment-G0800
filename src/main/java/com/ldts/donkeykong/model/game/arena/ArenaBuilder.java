package com.ldts.donkeykong.model.game.arena;

import com.ldts.donkeykong.model.game.elements.dynamic.*;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Ladder;
import com.ldts.donkeykong.model.game.elements.nonDynamic.OilBarrel;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Princess;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Structure;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setDonkey(createDonkey());
        arena.setFireEnemies(createFireEnemies());
        arena.setHammer(createHammer());
        arena.setMario(createMario());
        arena.setLadders(createLadders());
        arena.setOilBarrel(createOilBarrel());
        arena.setStructures(createStructures());
        arena.setPrincess(createPrincess());
        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract Donkey createDonkey();

    protected abstract Mario createMario();

    protected abstract Princess createPrincess();

    protected abstract List<FireEnemy> createFireEnemies();

    protected abstract List<Ladder> createLadders();

    protected abstract Hammer createHammer();

    protected abstract OilBarrel createOilBarrel();

    protected abstract List<Structure> createStructures();
}
