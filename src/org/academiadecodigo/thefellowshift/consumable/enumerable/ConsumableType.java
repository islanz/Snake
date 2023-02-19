package org.academiadecodigo.thefellowshift.consumable.enumerable;

import org.academiadecodigo.thefellowshift.constant.Constants;

public enum ConsumableType {
    FOOD(1, 1, 5, 20);


    private final int width;
    private final int height;
    private final int score;
    private final int specialScore;

    ConsumableType(int width , int height, int score, int specialScore) {
        this.width = width;
        this.height = height;
        this.score = score;
        this.specialScore = specialScore;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getScore() {
        return score;
    }

    public int getSpecialScore() {
        return specialScore;
    }
}
