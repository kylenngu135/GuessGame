import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        print_beginning_message(); 
        
        Difficulty difficulty = difficulty_prompt(input);
        int numGuesses = numGuesses(difficulty);
        int valueToGuess = RandomNumber();
        guessLoop(input, numGuesses, valueToGuess);

        input.close();
    }

    public static Difficulty difficulty_prompt(Scanner input) {
      
        Difficulty difficulty = Difficulty.Easy;

        while (true) {
            int value = input.nextInt();
            if (value < 4 && value > 0) { 

                switch (value) {
                    case 1: 
                        difficulty = Difficulty.Easy;
                        break;
                    case 2:
                        difficulty = Difficulty.Medium;
                        break;
                    case 3:
                        difficulty = Difficulty.Hard;
                        break;
                }
                break;
            } else {
                System.out.println("\nOutside of acceptable range. Please try again.");
                System.out.print("Enter your choice: ");
            }
        }

        return difficulty;
    }

    public static void print_beginning_message() {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have 5 chances to guess the correct number.");
        System.out.println("\nPlease select the difficult level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)\n");
        System.out.print("Enter your choice: ");
    }

    public static int numGuesses(Difficulty difficulty) {
        String diffStr = "";
        int numGuess = 0;

        switch (difficulty) {
            case Difficulty.Easy:
                diffStr = "Easy";
                numGuess = 10;
                break;
            case Difficulty.Medium:
                diffStr = "Medium";
                numGuess = 5;
                break;
            case Difficulty.Hard:
                diffStr = "Hard";
                numGuess = 3;
                break;
        }

        System.out.println("\nGreat you have selected the " + diffStr + " difficulty level.");
        System.out.println("Let's start the game!");

        return numGuess;
    }

    public static int RandomNumber() {
        Random rand = new Random();

        return ((rand.nextInt(100)) + 1);
    }

    public static void guessLoop(Scanner input, int numGuess, int numToGuess) {
        int guessTracker = 1;
        for (; guessTracker <= numGuess; guessTracker++) {
            System.out.print("Enter your guess: ");
            int guess = getGuess(input);
            if (numToGuess == guess) {
                System.out.println("\nCongratulations! You guessed the correct number in " + guessTracker + " attempts.\n");
                break;
            } else if (guess > numToGuess) {
                System.out.println("\nIncorrect! The number is less than " + guess);
            } else {
                System.out.println("\nIncorrect! The number is greater than " + guess);
            }
        }

        if (guessTracker > numGuess) {
            System.out.println("\nYou lose! You ran out of attempts! The correct number was " + numToGuess);
        }
    }

    public static int getGuess(Scanner input) {
        int guess = input.nextInt();

        return guess;
    }
}
