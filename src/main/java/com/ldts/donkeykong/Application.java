package com.ldts.donkeykong;

import com.ldts.donkeykong.gui.LanternaGUI;
import com.ldts.donkeykong.states.MenuState;
import com.ldts.donkeykong.states.State;
import com.ldts.donkeykong.viewer.menu.MenuViewer;
import com.ldts.donkeykong.model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    private final LanternaGUI gui;
    private State state;

    public Application() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(20, 20);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Application().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        int FPS = 15;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}