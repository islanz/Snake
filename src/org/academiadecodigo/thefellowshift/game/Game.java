package org.academiadecodigo.thefellowshift.game;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.thefellowshift.consumable.Food;
import org.academiadecodigo.thefellowshift.consumable.FoodFactory;
import org.academiadecodigo.thefellowshift.consumable.enumerable.FoodType;
import org.academiadecodigo.thefellowshift.field.FieldImpl;
import org.academiadecodigo.thefellowshift.keyboard.KeyboardHandler;
import org.academiadecodigo.thefellowshift.util.timer.BasicTimer;
import org.academiadecodigo.thefellowshift.field.Field;
import org.academiadecodigo.thefellowshift.snake.Snake;

public class Game {

    private Field field;
    private Snake snake;
    private BasicTimer basicTimer = new BasicTimer(18);
    private boolean isGameOver = false;
    private Food food;
    private KeyboardHandler keyboardHandler;
    private int score;

    private Text scoreText;
    private GameOverMenu gameOverMenu;

    public Game(Field field) {
        this.field = field;
        keyboardHandler  = new KeyboardHandler();
    }

    public void createSnake() {
        snake = new Snake();
        keyboardHandler.setKeyHandler(snake);
    }

    public void init() {

        Food.resetCounter();
        isGameOver = false;
        field.init();
        score = 0;
        scoreText = new Text(2, 2, String.format("Score: %s", score));
        scoreText.grow(2, 2);
        scoreText.setColor(Color.WHITE);
        scoreText.draw();
        createSnake();
        start();
    }

    public void start() {

        boolean isFoodActive = false;
        while(!isGameOver) {

            basicTimer.sync();
            snake.move();

            if(!isFoodActive) {
                if (Food.getCounter() % 5 == 0 && Food.getCounter() != 0) {
                    food = FoodFactory.createSpecialFood();
                    isFoodActive = true;
                } else {
                    food = FoodFactory.createRandomFood();
                    isFoodActive = true;
                }
            }

            if(snake.isCollidingWithConsumable(food)) {
                food.hide();
                isFoodActive = false;
                if (((Food.getCounter() - 1) % 5) == 0 && Food.getCounter() != 1) {
                    for(int i = 0; i < 3; i++) {
                        snake.grow();
                    }
                } else {
                    snake.grow();
                }
                score += food.getFoodScore();
                scoreText.setText(String.format("Score: %s", score));

            }

            isGameOver = snake.checkSnakeCollision();
            if (isGameOver) {
                gameOverMenu = new GameOverMenu();
                gameOverMenu.setScoreValue(score);
                keyboardHandler.setKeyHandler(gameOverMenu);
                while(!gameOverMenu.isRetryTransitioning()) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                gameOverMenu.hide();
                init();
            }
        }
    }


}
