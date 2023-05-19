package org.academiadecodigo.thefellowshift.field;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FieldImpl implements Field {
    public static final int PADDING = 0;
    public static final int CELL_SIZE = 30;
    public static final int COLS = 43;
    public static final int ROWS = 24;

    private int width;
    private int height;

    public FieldImpl() {
        this.width = COLS * CELL_SIZE;
        this.height = ROWS * CELL_SIZE;
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
