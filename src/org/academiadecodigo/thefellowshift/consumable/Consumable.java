package org.academiadecodigo.thefellowshift.consumable;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.thefellowshift.consumable.enumerable.ConsumableType;
import org.academiadecodigo.thefellowshift.field.FieldImpl;
import org.academiadecodigo.thefellowshift.snake.Node;
import org.academiadecodigo.thefellowshift.util.Randomizer;

import java.util.Random;

public abstract class Consumable extends Node {

    private Ellipse consumable;

    public Consumable(ConsumableType consumableType) {
        super(new Random().nextInt(FieldImpl.COLS) * FieldImpl.CELL_SIZE, new Random().nextInt(FieldImpl.ROWS) * FieldImpl.CELL_SIZE);
        consumable = new Ellipse(super.getX(), super.getY(), FieldImpl.CELL_SIZE * consumableType.getWidth(), FieldImpl.CELL_SIZE * consumableType.getHeight());
        consumable.setColor(Color.WHITE);
        consumable.fill();
    }

    public void remove() {
        consumable.delete();
    }


    @Override
    public int getX() {
        return super.getX()/FieldImpl.CELL_SIZE;
    }

    @Override
    public int getY() {
        return super.getY()/FieldImpl.CELL_SIZE;
    }




}
