package org.academiadecodigo.thefellowshift.snake;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thefellowshift.consumable.Food;
import org.academiadecodigo.thefellowshift.enumerable.Direction;
import org.academiadecodigo.thefellowshift.field.FieldImpl;
import org.academiadecodigo.thefellowshift.keyboard.KeyHandler;

import java.awt.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Snake implements KeyHandler {
    private LinkedList<SnakeSegment> snake;
    private int length = 7;
    private boolean isDirectionChanging;
    private boolean isPaused = false;
    public static final String SNAKE_HEAD_RIGHT = "snake_head_right.png";

    private Picture activeHead;

    public Snake() {
        snake = new LinkedList<>();

        for (int i = length - 1; i >= 0; i--) {
            snake.add(new SnakeSegment(FieldImpl.COLS / 2 + i, FieldImpl.ROWS / 2, Direction.RIGHT));
        }
        activeHead = new Picture(snake.getFirst().getX() * FieldImpl.CELL_SIZE, snake.getFirst().getY() * FieldImpl.CELL_SIZE, SNAKE_HEAD_RIGHT);
        activeHead.draw();
    }


    public void move() {
        if(isPaused) return;
        SnakeSegment tail = snake.getLast();
        SnakeSegment head = snake.getFirst();
        Direction headDirection = head.getCurrentDirection();
        int x = 0;
        int y = 0;
        int dx = 0;
        int dy = 0;

        switch (headDirection) {
            case RIGHT:
                x = head.getX() + 1;
                y = head.getY();
                dx = 1;
                break;
            case LEFT:
                x = head.getX() - 1;
                y = head.getY();
                dx = -1;
                break;
            case UP:
                x = head.getX();
                y = head.getY() - 1;
                dy = -1;
                break;
            case DOWN:
                x = head.getX();
                y = head.getY() + 1;
                dy = 1;
                break;
        }

        if (x < 0) {
            x = FieldImpl.COLS - 1;
            dx = FieldImpl.COLS - 1;
        }
        if (x > FieldImpl.COLS - 1) {
            x = 0;
            dx = - FieldImpl.COLS + 1;
        }
        if (y < 0) {
            y = FieldImpl.ROWS - 1;

            dy = FieldImpl.ROWS - 1;
        }
        if (y > FieldImpl.ROWS - 1) {
            y = 0;
            dy = - FieldImpl.ROWS + 1;
        }

        head.show();
        snake.addFirst(new SnakeSegment(x, y, headDirection));
        snake.getFirst().hide();

        activeHead.translate(dx * FieldImpl.CELL_SIZE, dy * FieldImpl.CELL_SIZE);
        activeHead.draw();

        tail.deleteSegment();
        snake.removeLast();
        isDirectionChanging = false;
    }

    public void grow() {
        SnakeSegment head = snake.getFirst();
        SnakeSegment tail = snake.getLast();
        Direction headDirection = head.getCurrentDirection();
        int x = 0;
        int y = 0;

        switch (headDirection) {
            case RIGHT:
                x = tail.getX() + 1;
                y = tail.getY();
                break;
            case LEFT:
                x = tail.getX() - 1;
                y = tail.getY();
                break;
            case UP:
                x = tail.getX();
                y = tail.getY() - 1;
                break;
            case DOWN:
                x = tail.getX();
                y = tail.getY() + 1;
                break;
        }

        snake.addLast(new SnakeSegment(x, y, headDirection));


        int counter = 0;
        for(SnakeSegment segment : snake) {
            System.out.println(String.format("INDEX %s X %S Y %s", counter, segment.getX(), segment.getY()));
            counter++;
        };
        length++;


    }


    public boolean checkSnakeCollision() {

        int headX = snake.getFirst().getX();
        int headY = snake.getFirst().getY();


        for (int i = snake.size() - 1; i > 0; i--) {
            if (snake.get(i).getX() == headX && snake.get(i).getY() == headY) {
                return true;
            }
        }
        return false;
    }

    public boolean isCollidingWithConsumable(Food consumable) {
        return snake.getFirst().getX() == consumable.getX() && snake.getFirst().getY() == consumable.getY();
    }

    @Override
    public void pressed(KeyboardEvent e) {

        SnakeSegment head = snake.getFirst();
        Direction headDirection = head.getCurrentDirection();

        if (isDirectionChanging) return;

        switch (e.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                if (isPaused) {
                    isPaused = false;
                } else {
                    isPaused = true;
                }
                break;
            case KeyboardEvent.KEY_UP:
                if(isPaused) return;
                if (headDirection == Direction.DOWN) break;
                head.setCurrentDirection(Direction.UP);
                loadPicture();
                isDirectionChanging = true;
                break;
            case KeyboardEvent.KEY_DOWN:
                if(isPaused) return;
                if (headDirection == Direction.UP) break;
                head.setCurrentDirection(Direction.DOWN);
                loadPicture();
                isDirectionChanging = true;
                break;
            case KeyboardEvent.KEY_RIGHT:
                if(isPaused) return;
                if (headDirection == Direction.LEFT) break;
                head.setCurrentDirection(Direction.RIGHT);
                loadPicture();
                isDirectionChanging = true;
                break;
            case KeyboardEvent.KEY_LEFT:
                if(isPaused) return;
                if (headDirection == Direction.RIGHT) break;
                head.setCurrentDirection(Direction.LEFT);
                loadPicture();
                isDirectionChanging = true;
                break;
            default:
                throw new NoSuchElementException();
        }
    }
    private void loadPicture() {
        switch (snake.getFirst().getCurrentDirection()) {
            case UP:
                activeHead.load("snake_head_up.png");
                break;
            case DOWN:
                activeHead.load("snake_head_down.png");
                break;
            case LEFT:
                activeHead.load("snake_head_left.png");
                break;
            case RIGHT:
                activeHead.load("snake_head_right.png");
                break;
        }
    }
}
