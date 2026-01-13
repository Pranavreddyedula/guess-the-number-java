package com.pranav.guessthenumber;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {

    GameLogic gameLogic = new GameLogic();

    @Test
    void testRandomNumberRange() {
        int number = gameLogic.generateRandomNumber();
        assertTrue(number >= GameLogic.MIN_NUMBER && number <= GameLogic.MAX_NUMBER,
                "Generated number is out of range");
    }

    @Test
    void testCorrectGuess() {
        String result = gameLogic.checkGuess(50, 50);
        assertEquals("correct", result);
    }

    @Test
    void testHighGuess() {
        String result = gameLogic.checkGuess(80, 50);
        assertEquals("Too high!", result);
    }

    @Test
    void testLowGuess() {
        String result = gameLogic.checkGuess(20, 50);
        assertEquals("Too low!", result);
    }
}
