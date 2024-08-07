import java.util.Random;
import java.util.Scanner;

public class Task_1_RandomGuess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Game settings
        final int MAX_ATTEMPTS = 5;
        final int RANGE_START = 1;
        final int RANGE_END = 100;

        boolean playAgain;
        int roundsWon = 0;

        do {
            int numberToGuess = random.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("A new number(1-100) has been generated! Try to guess it.");

            while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
                System.out.print("Enter your guess (attempt " + (attempts + 1) + " of " + MAX_ATTEMPTS + "): ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number correctly.");
                    hasGuessedCorrectly = true;
                    roundsWon++;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thanks for playing! You won " + roundsWon + " round(s).");
        sc.close();
    }
}
