package org.academiadecodigo.thefellowshift.consumable.enumerable;

import org.academiadecodigo.thefellowshift.constant.Constants;

public enum ConsumableType {
    FOOD(1, 1);


    private final int width;
    private final int height;

    ConsumableType(int width , int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
