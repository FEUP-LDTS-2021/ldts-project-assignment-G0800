package com.ldts.donkeykong.states;

import com.ldts.donkeykong.controller.Controller;
import com.ldts.donkeykong.controller.menu.MenuController;
import com.ldts.donkeykong.model.menu.Menu;
import com.ldts.donkeykong.viewer.Viewer;
import com.ldts.donkeykong.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
