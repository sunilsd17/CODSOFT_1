package numbergame;

import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowerLimit = 1;
        int upperLimit = 100;
        int attemptsLimit = 10;
        int score = 0;

        System.out.println("Welcome to Guess the Number Game!");

        do {
            int generatedNumber = generateRandomNumber(lowerLimit, upperLimit);
            System.out.println("\nGenerated a number between " + lowerLimit + " and " + upperLimit + ". Try to guess it!");

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess number: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Wrong! The number you are guessing is too low! Try again.");
                } else {
                    System.out.println("Wrong! The number you are guessing is too high! Try again.");
                }
            }

            int pointsEarned = attemptsLimit - attempts + 1;
            pointsEarned = Math.max(pointsEarned, 1); // Ensure points earned is at least 1

            if (guessedCorrectly) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                System.out.println("You earned " + pointsEarned + " points.");
                score += pointsEarned;
            } else {
                System.out.println("Timeout! Your attempt is over. The correct number is: " + generatedNumber);
            }

            System.out.println("Your total score is: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static int generateRandomNumber(int lowerLimit, int upperLimit) {
        return lowerLimit + (int) (Math.random() * (upperLimit - lowerLimit + 1));
    }
}
