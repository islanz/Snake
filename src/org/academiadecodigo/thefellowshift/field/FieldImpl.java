package org.academiadecodigo.thefellowshift.field;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FieldImpl implements Field {
    public static final int PADDING = 0;
    public static final int CELL_SIZE = 30;
    public static final int COLS = 43;
    public static final int ROWS = 24;
    public static final int WIDTH = COLS * CELL_SIZE;
    public static final int HEIGHT = ROWS * CELL_SIZE;

    public FieldImpl() {
    }

    public void init() {
        Picture background = new Picture();
        background.load("background.png");
        background.draw();
        System.out.println(background);

    }

    public int rowToY(int row) {
        return row * CELL_SIZE;
    }

    public int columnToX(int column) {
        return column * CELL_SIZE;
    }
}
