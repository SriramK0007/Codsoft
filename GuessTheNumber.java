import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber{
    public static void main(String[] args) {
        PlayTheGame();
    }

    public static void PlayTheGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int starting = 1;
        int ending = 100;
        int numberToGuess = random.nextInt(ending - starting + 1) + starting;
        int maxchances = 10;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game! Guess a number between " + starting + " and " + ending + ".");

        while (attempts < maxchances) {
            try {
                System.out.print("Enter your guessed number: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < starting || userGuess > ending) {
                    System.out.println("The Number you guessed is out of  specified range. Please Enter the Number in specified range.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number " + numberToGuess + " in " + attempts + " attempts.");
                    int score = maxchances - attempts + 1;
                    System.out.println("Your score is: " + score);
                    break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
            }
        }

        if (attempts == maxchances) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + numberToGuess + ".");
             System.out.println("Better luck next time!!");
            System.out.println("Your score is: 0");
           
        }

        System.out.println("Do you want to play again? (yes/no):"); 
        scanner.nextLine(); 
        String playAgain = scanner.nextLine().toLowerCase();
        if (playAgain.equals("yes")) {
            PlayTheGame();
        } else {
            System.out.println("Thanks for playing!");
        }

        scanner.close();
    }
}
