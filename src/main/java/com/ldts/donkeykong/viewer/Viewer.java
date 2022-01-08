package com.ldts.donkeykong.viewer;

import com.ldts.donkeykong.gui.GUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = null;
    }

    public T getModel() {
        return null;
    }

    public void draw(GUI gui) throws IOException {
    }

    protected abstract void drawElements(GUI gui);
}
