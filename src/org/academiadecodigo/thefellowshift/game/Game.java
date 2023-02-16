package org.academiadecodigo.thefellowshift.game;

import org.academiadecodigo.thefellowshift.consumable.Consumable;
import org.academiadecodigo.thefellowshift.consumable.Food;
import org.academiadecodigo.thefellowshift.consumable.enumerable.ConsumableType;
import org.academiadecodigo.thefellowshift.keyboard.KeyboardHandler;
import org.academiadecodigo.thefellowshift.timer.BasicTimer;
import org.academiadecodigo.thefellowshift.field.Field;
import org.academiadecodigo.thefellowshift.snake.Snake;

public class Game {

    private Field field;
    private Snake snake;
    private BasicTimer basicTimer = new BasicTimer(17);
    private boolean isGameOver = false;

    private Food food;
    private KeyboardHandler keyboardHandler;
    public Game(Field field) {
        this.field = field;
        keyboardHandler  = new KeyboardHandler();
    }

    public void createSnake() {
        snake = new Snake();
        keyboardHandler.setKeyHandler(snake);
    }

    public void init() {
        field.init();
        createSnake();
        start();
    }

    public void start() {

        boolean isFoodActive = false;
        while(!isGameOver) {
            snake.move();
            isGameOver = snake.checkSnakeCollision();
            basicTimer.sync();
            if(!isFoodActive) {
                food = new Food(ConsumableType.FOOD);
                isFoodActive = true;
            }
            if(snake.isCollidingWithConsumable(food)) {
                snake.grow();
                food.remove();
                isFoodActive = false;
            }
        }
    }

}
