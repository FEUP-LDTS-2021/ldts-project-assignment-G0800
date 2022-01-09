package com.ldts.donkeykong.gui;

import com.ldts.donkeykong.model.base.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawMario(Position position);

    void drawDonkey(Position position);

    void drawPrincess(Position position);

    void drawBarrel(Position position, boolean isFiery);

    void drawFireEnemy(Position position);

    void drawHammer(Position position);

    void drawOilBarrel(Position position);

    void drawStair(Position position, char c);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}