package com.ldts.donkeykong.viewer.game.elements;

import com.ldts.donkeykong.gui.GUI;
import com.ldts.donkeykong.model.game.elements.GameElement;

public interface GameElementViewer<T extends GameElement> {
    void draw(T element, GUI gui);
}