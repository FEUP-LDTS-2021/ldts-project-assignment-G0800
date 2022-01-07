package com.ldts.donkeykong.model.game.arena;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.dynamic.*;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Ladder;
import com.ldts.donkeykong.model.game.elements.nonDynamic.OilBarrel;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Princess;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        return null;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract Donkey createDonkey();

    protected abstract Mario createMario();

    protected abstract Princess createPrincess();

    protected abstract List<Barrel> createBarrels();

    protected abstract List<FireEnemy> createFireEnemies();

    protected abstract List<Ladder> createLadders();

    protected abstract Hammer createHammer();

    protected abstract OilBarrel createOilBarrel();
}
