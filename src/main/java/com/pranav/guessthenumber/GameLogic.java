package com.pranav.guessthenumber;

import java.util.Random;

public class GameLogic {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;
    public static final int MAX_ATTEMPTS = 7;

    private final Random random = new Random();

    public int generateRandomNumber() {
        return random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }

    public String checkGuess(int guess, int target) {
        if (guess == target) {
            return "correct";
        } else if (guess > target) {
            return "Too high!";
        } else {
            return "Too low!";
        }
    }
}
