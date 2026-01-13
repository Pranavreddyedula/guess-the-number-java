package com.pranav.guessthenumber;

public class ScoreManager {

    private int totalScore = 0;
    private static final int POINTS_PER_ROUND = 100;

    public void calculateScore(int attemptsLeft) {
        int score = attemptsLeft * (POINTS_PER_ROUND / GameLogic.MAX_ATTEMPTS);
        totalScore += score;
        System.out.println("⭐ You earned " + score + " points this round.");
        System.out.println("⭐ Total Score: " + totalScore);
    }

    public int getTotalScore() {
        return totalScore;
    }
}
