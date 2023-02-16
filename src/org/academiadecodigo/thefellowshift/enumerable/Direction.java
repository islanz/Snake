package org.academiadecodigo.thefellowshift.enumerable;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    private Direction oppositeDirection;


    static {
      UP.oppositeDirection = DOWN;
      DOWN.oppositeDirection = UP;
      LEFT.oppositeDirection = RIGHT;
      RIGHT.oppositeDirection = LEFT;
    }

    public Direction getOppositeDirection() {
        return oppositeDirection;
    }

}
