package org.academiadecodigo.thefellowshift.game;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thefellowshift.keyboard.KeyHandler;

public class GameOverMenu implements KeyHandler {
    private Picture retrySelected = new Picture();
    private Picture exitSelected = new Picture();
    private boolean isRetrySelected = true;
    private boolean isRetryTransitioning = false;

    private Text scoreText;
    private int scoreValue;

    public GameOverMenu() {
        retrySelected.load("gameover_background_retry_1290_700.png");
        exitSelected.load("gameover_background_exit_1290_700.png");
        retrySelected.draw();
    }

    @Override
    public void pressed(KeyboardEvent e) {
        if (e.getKey() == KeyboardEvent.KEY_RIGHT) {
            if (!isRetrySelected) return;
            retrySelected.delete();
            exitSelected.draw();
            isRetrySelected = false;
            scoreText.delete();
            scoreText.draw();
        } else if (e.getKey() == KeyboardEvent.KEY_LEFT) {
            if(isRetrySelected) return;
            exitSelected.delete();
            retrySelected.draw();
            isRetrySelected = true;
            scoreText.delete();
            scoreText.draw();
        } else if (e.getKey() == KeyboardEvent.KEY_SPACE) {
            if(isRetrySelected) {
                isRetryTransitioning = true;
            } else {
                System.exit(5);
            }
        }
    }

    public void hide() {
        retrySelected.delete();
        exitSelected.delete();
        isRetrySelected = false;
        isRetryTransitioning = false;
        scoreText.delete();
    }
    public boolean isRetryTransitioning() {
        return isRetryTransitioning;
    }

    public void setScoreValue(int score) {
        this.scoreValue = score;
        scoreText = new Text(625, 250, String.format("Score : %s", score));
        scoreText.setColor(Color.RED);
        scoreText.grow(50, 20);
        scoreText.draw();
    }
}
