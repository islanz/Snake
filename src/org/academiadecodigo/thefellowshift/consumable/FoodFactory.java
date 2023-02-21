package org.academiadecodigo.thefellowshift.consumable;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.thefellowshift.consumable.enumerable.FoodType;

import java.util.Random;

public class FoodFactory {



    public static Food createRandomFood() {

        Random random = new Random();
        Food food = null;
        int randomIndex = random.nextInt(FoodType.values().length - 1);

        switch(FoodType.values()[randomIndex]) {
            case BANANA:
                food = new Food(FoodType.BANANA);
                break;
            case APPLE:
                food = new Food(FoodType.APPLE);
                break;

            case BLUEBERRY:
                food = new Food(FoodType.BLUEBERRY);
                break;
        }
        return food;
    }

    public static Food createSpecialFood() {
        return new Food(FoodType.POTION);
    }
}
