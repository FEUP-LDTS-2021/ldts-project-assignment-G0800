package com.ldts.donkeykong.model.game.arena;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.dynamic.*;
import com.ldts.donkeykong.model.game.elements.nonDynamic.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ArenaBuilderLoader extends ArenaBuilder {
    private final int level;
    private final List<String> lines;

    public ArenaBuilderLoader(int level) throws IOException {
        this.level = level;
        URL resource = ArenaBuilderLoader.class.getResource("/levels/level" + level + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        this.lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        br.readLine();                 //Ignore first line
        for (String line; (line = br.readLine()) != null; ){
            line = line.replace("#", "");
            lines.add(line);
        }
        lines.remove(lines.size()-1);
        return lines;
    }

    @Override
    protected int getWidth() {
        return lines.get(0).length();
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Barrel> createBarrels() {
        List<Barrel> barrels = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '&') {
                    if (barrels.isEmpty()) {
                        barrels.add(new Barrel(new Position(x, y), true));
                    }
                    else {
                        barrels.add(new Barrel(new Position(x, y), false));
                    }
                }
        }
        return barrels;
    }

    @Override
    protected Donkey createDonkey() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '/') {
                    return new Donkey(new Position(x, y));
                }
        }
        return null;
    }

    @Override
    protected Mario createMario() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '*') {
                    return new Mario(new Position(x, y));
                }
        }
        return null;
    }

    @Override
    protected Princess createPrincess() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '?') {
                    return new Princess(new Position(x, y));
                }
        }
        return null;
    }

    @Override
    protected List<FireEnemy> createFireEnemies() {
        List<FireEnemy> fireEnemies = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '+') {
                    fireEnemies.add(new FireEnemy(new Position(x, y)));
                }
        }
        return fireEnemies;
    }

    @Override
    protected List<Ladder> createLadders() {
        List<Ladder> ladders = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            int height = 0;
            while (y < lines.size() && lines.get(y).contains("|")){
                y++;
                height ++;
            }
            if (height > 0){
                String line = lines.get(y-1);
                ladders.add(new Ladder(new Position(line.indexOf("|"), y-1), height));
            }

        }
        return ladders;
    }

    @Override
    protected  Hammer createHammer() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '$') {
                    return new Hammer(new Position(x, y));
                }
        }
        return null;
    }

    @Override
    protected OilBarrel createOilBarrel() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '@') {
                    return new OilBarrel(new Position(x, y));
                }
        }
        return null;
    }

    @Override
    protected List<Structure> createStructures() {
        List<Structure> structures = new ArrayList<>();
        Position startingPosition;
        int width = 0;

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '-') {
                    startingPosition = new Position(x, y);
                    while (x < line.length() && line.charAt(x) == '-' ) {
                        x++;
                        width++;
                    }
                    structures.add(new Structure(startingPosition, width));
                    width = 0;
                }
            }
        }
        return structures;
    }
}