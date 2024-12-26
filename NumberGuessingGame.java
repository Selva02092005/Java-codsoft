import java.util.Random;
import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int attemptsLimit = 10;
        int totalScore = 0;
        int roundsPlayed = 0;

        while (true) {
            roundsPlayed++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            System.out.println("\nRound " + roundsPlayed + ": Guess the number between 1 and 100!");

            while (attempts < attemptsLimit) {
                System.out.print("Attempt " + (attempts + 1) + "/" + attemptsLimit + ": Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! The number was " + numberToGuess + ".");
                    int score = Math.max(0, attemptsLimit - attempts + 1);
                    totalScore += score;
                    System.out.println("You scored " + score + " points this round!");
                    break;
                }
            }
            if (attempts == attemptsLimit) {
                System.out.println("Sorry! You've used all attempts. The number was " + numberToGuess + ".");
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        System.out.println("\nGame Over! You played " + roundsPlayed + " rounds and your total score is: " + totalScore);
    }
}
