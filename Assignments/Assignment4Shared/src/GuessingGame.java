
// You may use the nested comments below as hints only. Remember, there is no one right or wrong way 
// to 'solve' this Assignment, so feel free to delete the comments if you find them distracting.

import java.util.Random;
import java.util.Scanner;

/**
 * CS1A, Assignment 4, "Guessing Game" <br>
 * Quarter: Fall 2021<br>
 * <h1>Description of the class</h1> GuessingGame is a class which runs a game
 * in which the player has to guess a randomized,<br>
 * "secret" number within a specified range. The player will have 7 tries to
 * guess the secret number.<br>
 * Throughout the game, the program will give the player feedback on whether
 * their guess is too high <br>
 * or too low compared to the secret number. <br>
 * 
 * <h1>How to win most efficiently</h1> 1) enter a guess of 0<br>
 * 2) if 0 is too high, the number is negative, if 0 is too low, the number is
 * positive<br>
 * 3) Enter half the the max/min number (depending on if the number is positive
 * or negative)<br>
 * 4) Enter the previous number +/- half the previous number (depending on if
 * the number is positive or negative)<br>
 * 5) Repeat step 4 until you get the number
 * 
 * 
 * @author Sangeet Satpathy
 * @author William Rowe
 * 
 */
public class GuessingGame extends Object
{
   // List any instance variables, including constants, here.
   private static final int MAX_POSSIBLE_GUESS = 64;
   private static final int MIN_POSSIBLE_GUESS = -64;// This is a constant
   // Use an array instance variable to hold the guesses
   private final int NUM_GUESSES = 7;
   private Random randomNumberGenerator = new Random();

   private int userGuess = 0;

   private int[] userGuesses = new int[NUM_GUESSES];

   // If you need to get a number for the user to guess (randomly),
   // call the method below and it will create one for you.
   // The number may be as low as -64, and as high as 64
   // (This will be 129 separate numbers that the user might try to guess)
   // Of course, you will have to create a variable space to hold this number
   // when it is returned (for example, secretNumber)

   /** Generates a random number to be used as the "secret number." */
   private int getRandomNumber()
   {

      int max = MAX_POSSIBLE_GUESS - MIN_POSSIBLE_GUESS;
      int zeroToMax = randomNumberGenerator.nextInt(max + 1);
      return zeroToMax + MIN_POSSIBLE_GUESS;
   }

   /**
    * Prints a welcome message and introduces the player to the rules of the game.
    */
   private void welcome()
   {
      System.out.println("Welcome to the game!");
      System.out.println("Rules:");
      System.out.println("1) You will have " + NUM_GUESSES + " guesses");
      System.out.println("2) If you guess wrong, a hint will be displayed");
      System.out.println("3) You must guess a whole number between " + MIN_POSSIBLE_GUESS + " and " + MAX_POSSIBLE_GUESS
            + " inclusive.");
   }

   /**
    * Determines whether a number is already in an array.
    * 
    * @param arr
    *           the array of integers to be checked.
    * @param the
    *           integer to be checking for inside the array.
    */
   private boolean contains(int[] arr, int in, int guesses)
   {
      for (int i = 0; i < guesses; i++)
      {
         if (arr[i] == in)
         {
            return true;
         }
      }
      return false;
   }

   // You may want to create a method that will display the welcome message and
   // rules (e.g., welcome)

   // You may want to create a method (e.g., isGuessNum) that will check to see
   // that the number entered is a whole number,
   // assign it to a variable like userGuess, and then handle all
   // the various options regarding that number: has it been guessed before?; is it
   // the secret number?; if it isn't the secret number store it in the proper
   // location for cross checking; display messages regarding the number of guesses
   // made,
   // incorrect guesses, guesses remaining, secret number if all guesses used up,
   // error handling, etc.

   // You may want to create a method to print the user's previous guesses

   // You may want to create a method to store the user's guesses in the 8 elements
   // of the array

   // You will NEED a getInput method for getting integer input from the user (see
   // the assignment instructions on applying the techniques of structured
   // (functional) decomposition)).

   /** Gets a valid input from the player. */
   private int getInput(int maximum, int minimum)
   {
      Scanner sc = new Scanner(System.in);
      boolean pass = false;
      int query = 0;
      while (!pass)
      {
         if (sc.hasNextInt()) // The user inputs a whole number.
         {
            query = sc.nextInt();
            sc.nextLine();
            if (query <= maximum && query >= minimum)
            // The user inputs a value in the valid range AND is a whole number
            {
               pass = true;

            } else
            {// user has inputted a number outside the valid range
               System.out.println("Please enter a number between " + maximum + " and " + minimum + " inclusive.");

            }
         } else
         {// user didn't input a whole number.
            System.out.println("You did not input a whole number, please try again.");
            sc.nextLine();
            // sc.nextLine() is required here as well as when sc.nextLine() is only called
            // if the next line has an int,
            // and when there is no int, it is not called. Since this block of code is used
            // for ensuring that appropriate
            // feedback is made if the user does not enter a number, the sc.nextline() on
            // line 146 is not called,
            // and therefore needs to be called here instead
         }
      }
      return query;
   }

   /**
    * Compares two numbers and prints a message representing whether the number
    * guessed by the player is too high or too low.
    * 
    * @param guess
    *           The player's guess
    * @param secretNum
    *           The actual number.
    */
   private void highorlow(int guess, int secretNum)
   {
      if (guess > secretNum)
      {
         System.out.println("Your guess, " + guess + " is too high.");
      } else
      {
         System.out.println("Your guess, " + guess + " is too low.");
      }
   }

   /** Prints the array of the guesses so far. */
   private void printGuesses(int guesses)
   {
      System.out.print("Previous Guesses: ");
      for (int i = 0; i <= guesses - 1; i++)
      {

         System.out.print(this.userGuesses[i] + ", ");

      }
      System.out.println("");

   }

   // You may want to create a boolean method to check that the user's guess is
   // within range (between a minimum and maximum)
   // and will return true if it is

   // You may want to create a boolean method to see if the number has been guessed
   // previously and will return true if it has

   // You may want to create a boolean method to see if the number matches the
   // secret number and will return true if it does or false if it doesn't

   // You may want to create a method to give a hint about the number guessed
   // (e.g., "My secret number is GREATER than " or "My secret number is LESS than
   // ")

   // You may want to create a method (e.g., playGame) that will check if the user
   // wants to play again, by calling the method for getting integer input from the
   // user,
   // (1 for 'yes', 0 for 'no') and incorporate the proper functionality depending
   // on the user's choice ( 1 or 0).

   /**
    * Asks the user if they want to play again and returns a boolean, where True
    * represents the user wants to play again, and False represents the user wants
    * to quit.
    */
   private boolean playGame()
   {

      System.out.println("1) Enter '1' to play again. \n2) Enter '0' to quit.");
      int userChoice = getInput(1, 0);

      if (userChoice == 1)
      {
         return true;
      }
      return false;
   }

   /**
    * The function in which the game is played. Utilizes other helper functions.
    */
   public boolean playGuessingGame()
   {

      int secretNumber = this.getRandomNumber(); // Feel free to move this into another method
      this.welcome();
      for (int i = 0; i < NUM_GUESSES; i++)
      {
         System.out.println("");
         System.out.println("Guess #" + (i + 1));
         System.out.println("You have " + (NUM_GUESSES - i) + " guesses left");
         System.out.println("Please enter a number:");
         boolean pass = false;
         while (!pass)
         {
            userGuess = this.getInput(MAX_POSSIBLE_GUESS, MIN_POSSIBLE_GUESS);
            if (!contains(this.userGuesses, userGuess, i))
            // The user has inputted a valid whole number that HAS NOT been inputted before.
            {
               // Accepted output
               pass = true;

            } else
            {// User put in a number that has been guessed before.
               System.out.println("You already guessed " + userGuess);
            }
         }
         this.userGuesses[i] = userGuess;
         System.out.println("Your guess was " + userGuess);
         this.printGuesses(i);
         if (userGuess == secretNumber)
         {
            i = NUM_GUESSES + 1;
         } else
         {
            this.highorlow(this.userGuess, secretNumber);
         }
      }
      if (userGuess == secretNumber)
      {
         System.out.println("You win!");
      } else
      {
         System.out.println("You lose, the number was " + secretNumber);
      }

      return this.playGame();

      // You might call a welcome() method here instead

      // You might create a loop here that will check numberGuesses 8 times and print
      // the guess number and call the
      // pertinent method (e.g., isGuessNum)

      // You might call and capture results from method (e.g., playGame) to see if
      // user wants to play again and if
      // so return it. Example: int playAgain = this.playGame();

      // if you want to end the game early & go directly back to main,
      // you can use a "return;" statement like this one (e.g., return playAgain;)
   }

}
