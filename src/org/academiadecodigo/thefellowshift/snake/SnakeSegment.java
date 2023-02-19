package org.academiadecodigo.thefellowshift.snake;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thefellowshift.enumerable.Direction;
import org.academiadecodigo.thefellowshift.field.FieldImpl;

public class SnakeSegment extends Node {
    private Rectangle snakeSegment;
    private Direction currentDirection;
    private Picture pic;
    private int x;
    private int y;

    public SnakeSegment(int x, int y, Direction currentDirection) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.currentDirection = currentDirection;
        snakeSegment = new Rectangle(super.getX() * FieldImpl.CELL_SIZE, super.getY() * FieldImpl.CELL_SIZE, FieldImpl.CELL_SIZE, FieldImpl.CELL_SIZE);
        snakeSegment.setColor(Color.GREEN);
        snakeSegment.fill();
    }

    public void hide() {
        snakeSegment.fill();
        pic.delete();
        pic = null;
    }

    public void show() {
        snakeSegment.delete();
        System.out.println(String.format("X : %s Y : %s", x, y ));
        pic = createPicture();
        pic.draw();
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void deleteSegment() {
        snakeSegment.delete();
    }

    public Picture createPicture() {

        Picture pic = null;
        switch (currentDirection) {
            case UP:
                pic = new Picture(x * FieldImpl.CELL_SIZE, y  * FieldImpl.CELL_SIZE, "snake_head_up.png");
                break;
            case DOWN:
                pic = new Picture(x * FieldImpl.CELL_SIZE, y  * FieldImpl.CELL_SIZE, "snake_head_down.png");
                break;
            case LEFT:
                pic = new Picture(x * FieldImpl.CELL_SIZE, y  * FieldImpl.CELL_SIZE, "snake_head_left.png");
                break;
            case RIGHT:
                pic = new Picture(x * FieldImpl.CELL_SIZE, y * FieldImpl.CELL_SIZE, "snake_head_right.png");
                break;
        }
        return pic;
    }

    public void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
