package com.eddanp.sabelotodogame.model;

public class Score {
    private final int[] scoreOne = {45, 80, 125, 250, 500};
    private final int[] scoreTwo = {20, 25, 35, 45, 55, 70, 100, 150, 200, 300};
    private final int[] scoreThree = {10, 15, 20, 24, 26, 30, 35, 40, 50, 70, 80, 100, 120, 160, 220};
    private final int[] scoreFour = {8, 10, 12, 15, 18, 19, 21, 22, 25, 28, 32, 40, 45, 55, 70, 80, 90, 110, 140, 160};
    private final int[] scoreFive = {6, 8, 9, 10, 12, 13, 15, 16, 17, 19, 22, 24, 25, 26, 28, 40, 45, 50, 55, 60, 80, 90, 100, 110, 120};

    public int[] getScoreOne() {
        return scoreOne;
    }

    public int[] getScoreTwo() {
        return scoreTwo;
    }

    public int[] getScoreThree() {
        return scoreThree;
    }

    public int[] getScoreFour() {
        return scoreFour;
    }

    public int[] getScoreFive() {
        return scoreFive;
    }
}


