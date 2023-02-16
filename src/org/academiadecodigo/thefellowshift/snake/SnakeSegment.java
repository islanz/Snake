package org.academiadecodigo.thefellowshift.snake;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.thefellowshift.enumerable.Direction;
import org.academiadecodigo.thefellowshift.field.FieldImpl;

public class SnakeSegment extends Node {

    private Rectangle snakeSegment;
    private Direction currentDirection;

    public SnakeSegment(int x, int y, Direction currentDirection) {
        super(x, y);
        this.currentDirection = currentDirection;
        snakeSegment = new Rectangle(super.getX() * FieldImpl.CELL_SIZE, super.getY() * FieldImpl.CELL_SIZE, FieldImpl.CELL_SIZE, FieldImpl.CELL_SIZE);
        snakeSegment.setColor(Color.PINK);
        snakeSegment.fill();
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

}
