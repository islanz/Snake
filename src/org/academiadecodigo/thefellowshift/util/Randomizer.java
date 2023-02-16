package org.academiadecodigo.thefellowshift.util;

import org.academiadecodigo.thefellowshift.field.FieldImpl;

import java.util.Random;

public class Randomizer
{

    public static int getRandomXPosition() {
       return new Random().nextInt(FieldImpl.COLS);
    }

    public static int getRandomYPosition() {
        return new Random().nextInt(FieldImpl.ROWS);
    }
}
