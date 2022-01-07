package com.ldts.donkeykong.model.game.arena;

import com.ldts.donkeykong.model.base.Position;
import com.ldts.donkeykong.model.game.elements.dynamic.Donkey;
import com.ldts.donkeykong.model.game.elements.dynamic.Barrel;
import com.ldts.donkeykong.model.game.elements.dynamic.FireEnemy;
import com.ldts.donkeykong.model.game.elements.dynamic.Hammer;
import com.ldts.donkeykong.model.game.elements.dynamic.Mario;

import com.ldts.donkeykong.model.game.elements.nonDynamic.Ladder;
import com.ldts.donkeykong.model.game.elements.nonDynamic.OilBarrel;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Princess;
import com.ldts.donkeykong.model.game.elements.nonDynamic.Structure;

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
    }

    public int getWidth() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }

    public void setWidth(int width) {}

    public void setHeight(int height) {}

    public List<Barrel> getBarrels() {
        return null;
    }

    public void setBarrels(List<Barrel> barrels) {

    }

    public Donkey getDonkey() {
        return null;
    }

    public void setDonkey(Donkey donkey) {}

    public List<FireEnemy> getFireEnemies() {
        return null;
    }

    public void setFireEnemies(List<FireEnemy> fireEnemies) {}

    public Hammer getHammer() {
        return null;
    }

    public void setHammer(Hammer hammer) {}

    public Mario getMario() {
        return null;
    }

    public void setMario(Mario mario) {

    }

    public OilBarrel getOilBarrel() {
        return null;
    }

    public void setOilBarrel(OilBarrel oilBarrel) {

    }

    public Princess getPrincess(){
        return null;
    }

    public void setPrincess(Princess princess) {

    }

    public List<Ladder> getLadders(){
        return null;
    }

    public void setLadders(List<Ladder> ladders) {}

    public List<Structure> getStructures() {
        return null;
    }

    public void setStructures(List<Structure> structures) {

    }

    public boolean isEmpty(Position position) {
        return false;
    }

    public boolean isBarrel(Position position) {
        return false;
    }

    public boolean isFireEnemy(Position position) {
        return false;
    }

    public boolean isPrincess(Position position) {
        return false;
    }

    public boolean isLadder(Position position){
        return false;
    }

    public boolean isHammer(Position position){
        return false;
    }

    public boolean isOilBarrel(Position position){
        return false;
    }
}