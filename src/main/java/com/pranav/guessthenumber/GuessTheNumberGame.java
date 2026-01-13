package com.pranav.guessthenumber;

import java.util.Scanner;

public class GuessTheNumberGame {

    private final Scanner scanner = new Scanner(System.in);
    private final GameLogic gameLogic = new GameLogic();
    private final ScoreManager scoreManager = new ScoreManager();

    public void startGame() {
        System.out.println("=================================");
        System.out.println("     GUESS THE NUMBER GAME");
        System.out.println("=================================");

        boolean playAgain;

        do {
            playRound();
            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("\nFinal Score: " + scoreManager.getTotalScore());
        System.out.println("Thanks for playing!");
    }

    private void playRound() {
        int targetNumber = gameLogic.generateRandomNumber();
        int attemptsLeft = GameLogic.MAX_ATTEMPTS;
        boolean isGuessed = false;

        System.out.println("\nI have selected a number between 1 and 100.");
        System.out.println("You have " + GameLogic.MAX_ATTEMPTS + " attempts.");

        while (attemptsLeft > 0) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            String result = gameLogic.checkGuess(userGuess, targetNumber);

            if (result.equals("correct")) {
                System.out.println("🎉 Correct! You guessed the number.");
                scoreManager.calculateScore(attemptsLeft);
                isGuessed = true;
                break;
            } else {
                System.out.println(result);
                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }
        }

        if (!isGuessed) {
            System.out.println("❌ You've run out of attempts!");
            System.out.println("The correct number was: " + targetNumber);
        }
    }
}
