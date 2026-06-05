import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        do {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\n===== NUMBER GAME =====");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Correct! You guessed the number.");
                    System.out.println("Attempts used: " + attempts);
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }

                System.out.println("Remaining Attempts: "
                        + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: "
                        + secretNumber);
            }

            System.out.println("Current Score: " + score);

            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\nThank you for playing!");
        System.out.println("Final Score: " + score);

        sc.close();
    }
}