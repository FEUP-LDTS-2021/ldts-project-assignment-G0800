package com.ldts.donkeykong.model.game.arena;

import com.ldts.donkeykong.model.game.elements.dynamic.*;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Ladder;
import com.ldts.donkeykong.model.game.elements.nonDynamic.OilBarrel;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Princess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ArenaBuilderLoader extends ArenaBuilder {
    private final int level;
    private final List<String> lines;

    public ArenaBuilderLoader(int level) throws IOException {
        this.level = 0;
        this.lines = null;
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        return null;
    }

    @Override
    protected int getWidth() {
        return 0;
    }

    @Override
    protected int getHeight() {
        return 0;
    }

    @Override
    protected List<Barrel> createBarrels() {
        return null;
    }

    @Override
    protected Donkey createDonkey() {
        return null;
    }

    @Override
    protected Mario createMario() {
        return null;
    }

    @Override
    protected Princess createPrincess() {
        return null;
    }

    @Override
    protected List<FireEnemy> createFireEnemies() {
        return null;
    }

    @Override
    protected List<Ladder> createLadders() {
        return null;
    }

    @Override
    protected  Hammer createHammer() {
        return null;
    }

    @Override
    protected OilBarrel createOilBarrel() {
        return null;
    }
}