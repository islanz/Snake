package org.academiadecodigo.thefellowshift.field;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class FieldImpl implements Field {
    public static final int PADDING = 0;
    public static final int CELL_SIZE = 30;
    public static final int COLS = 54;
    public static final int ROWS = 30;
    private Rectangle rectangle;
    private int width;
    private int height;

    public FieldImpl() {
        this.width = COLS * CELL_SIZE;
        this.height = ROWS * CELL_SIZE;
    }

    public void init() {
        rectangle = new Rectangle(PADDING, PADDING, width, height);
        rectangle.setColor(Color.BLACK);
        rectangle.fill();
    }

    public int rowToY(int row) {
        return row * CELL_SIZE;
    }

    public int columnToX(int column) {
        return column * CELL_SIZE;
    }
}
