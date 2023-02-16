package org.academiadecodigo.thefellowshift.snake;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.thefellowshift.consumable.Consumable;
import org.academiadecodigo.thefellowshift.enumerable.Direction;
import org.academiadecodigo.thefellowshift.field.FieldImpl;
import org.academiadecodigo.thefellowshift.keyboard.KeyHandler;

import java.util.LinkedList;

public class Snake implements KeyHandler {
    private LinkedList<SnakeSegment> snake;
    private int length = 7;
    private boolean isDirectionChanging;

    public Snake() {
        snake = new LinkedList<>();

        for (int i = length - 1; i >= 0 ; i--) {
            snake.add(new SnakeSegment(FieldImpl.COLS / 2 + i, FieldImpl.ROWS / 2 , Direction.RIGHT));
        }
        System.out.println(getHead().getX());
        System.out.println(snake.getLast().getX());
    }

    public void move() {
        SnakeSegment tail = snake.getLast();
        SnakeSegment head = snake.getFirst();
        Direction headDirection = head.getCurrentDirection();
        int x = 0;
        int y = 0;

        switch(headDirection) {
            case RIGHT:
                x = head.getX() + 1 ;
                y = head.getY();
                break;
            case LEFT:
                x = head.getX() - 1;
                y = head.getY();
                break;
            case UP:
                x = head.getX();
                y = head.getY() - 1;
                break;
            case DOWN:
                x = head.getX();
                y = head.getY() + 1;
                break;
        }

        if(x < 0) {
            x = FieldImpl.COLS - 1;
        }
        if(x > FieldImpl.COLS - 1) {
            x = 0;
        }
        if(y < 0) {
            y = FieldImpl.ROWS - 1;
        }
        if(y > FieldImpl.ROWS - 1) {
            y = 0;
        }
        snake.addFirst(new SnakeSegment(x, y, headDirection));
        tail.deleteSegment();
        snake.removeLast();
        isDirectionChanging = false;
    }


    public void grow() {
        SnakeSegment head = snake.getFirst();
        Direction headDirection = head.getCurrentDirection();
        int x = 0;
        int y = 0;

        switch(headDirection) {
            case RIGHT:
                x = head.getX() + 1;
                y = head.getY();
                break;
            case LEFT:
                x = head.getX() - 1;
                y = head.getY();
                break;
            case UP:
                x = head.getX();
                y = head.getY() - 1;
                break;
            case DOWN:
                x = head.getX();
                y = head.getY() + 1;
                break;
        }
        snake.addFirst(new SnakeSegment(x, y, headDirection));
        length++;
    }

    public boolean checkSnakeCollision() {

        int headX = snake.getFirst().getX();
        int headY = snake.getFirst().getY();

        System.out.println("" + headX + ":" + headY);



        for(int i = snake.size() - 1; i > 0 ; i--) {
            if (snake.get(i).getX() == headX && snake.get(i).getY() == headY) {
                System.out.println(String.format("Snake head X: %s Snake head Y: %s", String.valueOf(headX), String.valueOf(headY)));
                System.out.println(String.format("Snake collider X: %s Snake collider Y: %s element: %s ", String.valueOf(snake.get(i).getX()), String.valueOf(snake.get(i).getY()), i));
                return true;
            }
        }
        return false;
    }

    public boolean isCollidingWithConsumable(Consumable consumable) {
        return snake.getFirst().getX() == consumable.getX() && snake.getFirst().getY() == consumable.getY();
    }
    @Override
    public void pressed(KeyboardEvent e) {

        SnakeSegment head = snake.getFirst();
        Direction headDirection = head.getCurrentDirection();
        Direction oppositeHeadDirection = headDirection.getOppositeDirection();

        if(isDirectionChanging) return;

        switch(e.getKey()) {
            case KeyboardEvent.KEY_UP:
                Direction up = Direction.UP;
                if(oppositeHeadDirection == up) break;
                head.setCurrentDirection(Direction.UP);
                isDirectionChanging = true;
                break;
            case KeyboardEvent.KEY_DOWN:
                Direction down = Direction.DOWN;
                if(oppositeHeadDirection == down) break;
                head.setCurrentDirection(Direction.DOWN);
                isDirectionChanging = true;
                break;
            case KeyboardEvent.KEY_RIGHT:
                Direction right = Direction.RIGHT;
                if(oppositeHeadDirection == right) break;
                head.setCurrentDirection(Direction.RIGHT);
                isDirectionChanging = true;
                break;
            case KeyboardEvent.KEY_LEFT:
                Direction left = Direction.LEFT;
                if(oppositeHeadDirection == left) break;
                head.setCurrentDirection(Direction.LEFT);
                isDirectionChanging = true;
                break;
        }
    }

    public SnakeSegment getHead() {
        return snake.getFirst();
    }
}
