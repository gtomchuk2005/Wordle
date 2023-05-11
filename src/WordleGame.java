import java.util.Scanner;

/**
 * This class holds the logic of the game
 *
 * @author Gregory Tomchuk
 */
public class WordleGame {

    /**
     * This method runs the game
     */
    public void run() {
        System.out.println("Welcome to Wordle!");
        System.out.println("The game is simple - try to guess the Wordle in six tries or less. Good luck!");

        new Word();
        WordleGrid grid = new WordleGrid();
        Scanner sc = new Scanner(System.in);

        int guesses = 6; // player has 6 guesses
        String userGuess = "";

        while (!userGuess.equals(Word.getWord()) && guesses > 0) {
            System.out.print("\nPlease enter a guess (make sure all characters are lowercase): ");
            userGuess = sc.nextLine();
            guesses--;

            while (userGuess.length() != 5) {
                if (userGuess.length() != 5) {
                    System.out.println("The word must be 5 letters long.");
                }
                System.out.print("\nPlease enter a guess (make sure all characters are lowercase): ");
                userGuess = sc.nextLine();
            }

            grid.updateGrid(userGuess);
            grid.drawGrid();
        }

        System.out.println();

        // win & lose condition
        if (userGuess.equals(Word.getWord())) {
            System.out.println("The Wordle was \"" + Word.getWord() + "\". It took you " + (6 - guesses) + " guesses!");
            System.out.println("Genius! You beat today's Wordle, come back tomorrow and play again :)");
        }
        else {
            System.out.println("The Wordle was \"" + Word.getWord() + "\".");
            System.out.println("Unfortunately you did not get today's Wordle. Try again tomorrow :)");
        }

        sc.close();
    }

}