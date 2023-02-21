package org.academiadecodigo.thefellowshift.consumable.enumerable;

public enum FoodType {

    APPLE(15, "Apple.png"),
    BLUEBERRY(5, "Blueberries.png"),
    BANANA(10, "Banana.png"),
    POTION(30, "potion.png");



    private final int score;
    private final String path;

    FoodType(int score, String path) {
        this.score = score;
        this.path = path;
    }

    public int getScore() {
        return score;
    }

    public String getPath() {
        return path;
    }
}
