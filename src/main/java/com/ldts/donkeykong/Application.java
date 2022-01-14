package com.ldts.donkeykong;

import com.ldts.donkeykong.gui.LanternaGUI;
import com.ldts.donkeykong.viewer.menu.MenuViewer;
import com.ldts.donkeykong.model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args) {
        try {
            LanternaGUI gui = new LanternaGUI(20,20);
            Menu menu = new Menu();
            MenuViewer menuViewer = new MenuViewer(menu);
            menuViewer.draw(gui);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

    }
}