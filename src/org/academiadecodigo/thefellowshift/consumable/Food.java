package org.academiadecodigo.thefellowshift.consumable;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.thefellowshift.constant.Constants;
import org.academiadecodigo.thefellowshift.consumable.enumerable.ConsumableType;

public class Food extends Consumable {

    private static int counter;

    public Food(ConsumableType consumableType, Color color) {
        super(consumableType, color);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
    public static void resetCounter() {
        counter = 0;
    }
}
