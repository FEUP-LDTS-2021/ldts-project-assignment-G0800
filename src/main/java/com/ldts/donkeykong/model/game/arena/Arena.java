package com.ldts.donkeykong.model.game.arena;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.dynamic.Donkey;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.FireEnemy;
import com.ldts.donkeykong.model.game.elements.dynamic.Hammer;
import com.ldts.donkeykong.model.game.elements.dynamic.Mario;
import com.ldts.donkeykong.model.game.elements.nonDynamic.*;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Ladder;
import com.ldts.donkeykong.model.game.elements.nonDynamic.OilBarrel;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Princess;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Structure;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Mario mario;
    private Donkey donkey;
    private Princess princess;
    private OilBarrel oilBarrel;
    private Hammer hammer;
    private List<Structure> structures;
    private List<Ladder> ladders;
    private List<FireEnemy> fireEnemies;
    private List<Barrel> barrels;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        structures = new ArrayList<>();
        ladders = new ArrayList<>();
        fireEnemies = new ArrayList<>();
        barrels = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Barrel> getBarrels() {
        return barrels;
    }

    public void setBarrels(List<Barrel> barrels) {
        this.barrels = barrels;
    }

    public void removeBarrel(Barrel barrel) {
        barrels.remove(barrel);
    }

    public Donkey getDonkey() {
        return donkey;
    }

    public void setDonkey(Donkey donkey) {
        this.donkey = donkey;
    }

    public List<FireEnemy> getFireEnemies() {
        return fireEnemies;
    }

    public void removeFireEnemy(FireEnemy fireEnemy) {
        fireEnemies.remove(fireEnemy);
    }

    public void setFireEnemies(List<FireEnemy> fireEnemies) {
        this.fireEnemies = fireEnemies;
    }

    public Hammer getHammer() {
        return hammer;
    }

    public void setHammer(Hammer hammer) {
        this.hammer = hammer;
    }

    public Mario getMario() {
        return mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    public OilBarrel getOilBarrel() {
        return oilBarrel;
    }

    public void setOilBarrel(OilBarrel oilBarrel) {
        this.oilBarrel = oilBarrel;
    }

    public Princess getPrincess(){
        return princess;
    }

    public void setPrincess(Princess princess) {
        this.princess = princess;
    }

    public List<Ladder> getLadders(){
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) { this.ladders = ladders; }

    public List<Structure> getStructures() {
        return structures;
    }

    public void setStructures(List<Structure> structures) {
        this.structures = structures;
    }

    public boolean isEmpty(Position position) {
        return position.getX() >= 0 && position.getX() < width && position.getY() >= 0 && position.getY() < height;
    }

    public boolean isBarrel(Position position) {
        for (Barrel b: barrels) {
            if (b.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFireEnemy(Position position) {
        for (FireEnemy fe: fireEnemies) {
            if (fe.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPrincess(Position position) {
        return princess != null && princess.getPosition().equals(position);
    }

    public boolean isLadder(Position position){
        for (Ladder l: ladders) {
            for (Stair s: l.getStairs()) {
                if(s.getPosition().equals(position)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isStructure(Position position){
        for (Structure s: structures) {
            for (Stair t: s.getStairs()) {
                if(t.getPosition().equals(position)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isHammer(Position position){
        return hammer != null && hammer.getPosition().equals(position);
    }

    public boolean isOilBarrel(Position position){
        return oilBarrel != null && oilBarrel.getPosition().equals(position);
    }
}