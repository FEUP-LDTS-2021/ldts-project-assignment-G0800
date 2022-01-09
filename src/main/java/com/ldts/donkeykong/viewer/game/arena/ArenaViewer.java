package com.ldts.donkeykong.viewer.game.arena;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.arena.Arena;
import com.ldts.donkeykong.model.game.elements.GameElement;
import com.ldts.donkeykong.viewer.Viewer;
import com.ldts.donkeykong.viewer.game.elements.GameElementViewer;
import com.ldts.donkeykong.viewer.game.elements.dynamic.BarrelViewer;
import com.ldts.donkeykong.viewer.game.elements.dynamic.DonkeyViewer;
import com.ldts.donkeykong.viewer.game.elements.dynamic.HammerViewer;
import com.ldts.donkeykong.viewer.game.elements.dynamic.MarioViewer;
import com.ldts.donkeykong.viewer.game.elements.nonDynamic.LadderViewer;
import com.ldts.donkeykong.viewer.game.elements.nonDynamic.OilBarrelViewer;
import com.ldts.donkeykong.viewer.game.elements.nonDynamic.PrincessViewer;
import com.ldts.donkeykong.viewer.game.elements.nonDynamic.StructureViewer;

import java.util.List;

public class ArenaViewer extends Viewer<Arena> {

    public ArenaViewer(Arena arena) {
        super(arena);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawElement(gui, getModel().getMario(), new MarioViewer());
        drawElement(gui, getModel().getDonkey(), new DonkeyViewer());
        drawElement(gui, getModel().getHammer(), new HammerViewer());
        drawElement(gui, getModel().getOilBarrel(), new OilBarrelViewer());
        drawElement(gui, getModel().getPrincess(), new PrincessViewer());
        drawElements(gui, getModel().getBarrels(), new BarrelViewer());
        drawElements(gui, getModel().getLadders(), new LadderViewer());
        drawElements(gui, getModel().getStructures(), new StructureViewer());
    }

    private<T extends GameElement> void drawElements(GUI gui, List<T> elements, GameElementViewer<T> viewer) {
        for(T element: elements) {
            drawElement(gui,element,viewer);
        }
    }

    private<T extends GameElement> void drawElement(GUI gui, T element, GameElementViewer<T> viewer) {
        viewer.draw(element,gui);
    }
}
