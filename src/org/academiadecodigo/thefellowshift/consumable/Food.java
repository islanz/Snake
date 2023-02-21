package org.academiadecodigo.thefellowshift.consumable;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thefellowshift.constant.Constants;
import org.academiadecodigo.thefellowshift.consumable.enumerable.FoodType;
import org.academiadecodigo.thefellowshift.field.FieldImpl;
import org.academiadecodigo.thefellowshift.snake.Node;

import java.util.Random;

public class Food extends Node  {

    private static int counter;
    private final FoodType foodType;

    private final Picture foodPicture;
    public Food(FoodType foodType) {
        super(new Random().nextInt(FieldImpl.COLS), new Random().nextInt(FieldImpl.ROWS) );
        foodPicture = new Picture(super.getX()  * FieldImpl.CELL_SIZE , super.getY() * FieldImpl.CELL_SIZE, foodType.getPath());
        System.out.println(foodPicture.getX());
        System.out.println(foodPicture.getY());
        foodPicture.draw();
        this.foodType = foodType;
        counter++;
    }

    public int getFoodScore() {
        return foodType.getScore();
    }

    public void hide() {
        foodPicture.delete();
    }
    public static int getCounter() {
        return counter;
    }
    public static void resetCounter() {
        counter = 0;
    }
}
