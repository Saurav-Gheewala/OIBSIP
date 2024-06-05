import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int BASE_SCORE = 100;
    private static final int PENALTY_PER_GUESS = 10;
    private static final int BONUS_PER_REMAINING_ATTEMPT = 10;

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1; 
        int attempts = 0;
        boolean end = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100. Try to guess it.");

        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Remaining Attempts: " + (MAX_ATTEMPTS - attempts)); 
            System.out.print("Enter your guess: ");

            int guess = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    guess = scanner.nextInt();
                    if (guess < 1 || guess > 100) {
                        System.out.print("Please enter a number between 1 and 100: ");
                    } else {
                        validInput = true;
                    }
                } catch (Exception e) {
                    System.out.print("Invalid input. Please enter a valid number: ");
                    scanner.next(); 
                }
            }

            attempts++;

            if (guess == targetNumber) {
                int score = calculateScore(attempts);
                System.out.println("Correct! You've guessed the number.");
                System.out.println("Your score: " + score);
                end = true;
                break;
            } else {
                displayHint(guess, targetNumber);
            }
        }

        if (attempts >= MAX_ATTEMPTS && end == false) {
            System.out.println("GAME OVER! Better luck next time!");
            System.out.println("The number was: " + targetNumber);
            System.out.println("Your score: 0");
        }

        scanner.close();
    }

    private static int calculateScore(int attempts) {
        return BASE_SCORE - (PENALTY_PER_GUESS * (attempts - 1)) + (BONUS_PER_REMAINING_ATTEMPT * (MAX_ATTEMPTS - attempts));
    }

    private static void displayHint(int guess, int targetNumber) {
        if (guess < targetNumber - 5) {
            System.out.println("Too low! Try again.");
        } else if (guess > targetNumber + 5) {
            System.out.println("Too high! Try again.");
        } else if (guess < targetNumber) {
            System.out.println("Little bit low! Try again.");
        } else {
            System.out.println("Little bit high! Try again.");
        }
        System.out.println("");
    }
}
