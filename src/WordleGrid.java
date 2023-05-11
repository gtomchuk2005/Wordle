/**
 * This class represents the Wordle grid on which the user will play
 *
 * @author Gregory Tomchuk
 */
public class WordleGrid {

    /** The grid on which the game will be played */
    private String[][] grid;

    /** A number that tracks how many guesses have been entered into the grid */
    private int i = 0;

    /** A String constant of a blank space */
    private final String SPACE = " ";

    /** Instantiates a grid object and assigns every element to a SPACE constant */
    public WordleGrid() {

        grid = new String[6][5]; // 6 x 5 board; 5-letter word with 6 guesses

        for (int i = 0; i < grid.length; i++) { // i: rows
            for (int j = 0; j < grid[0].length; j++) { // j: columns
                grid[i][j] = SPACE;
            }
        }
    }

    /**
     * Updates the grid with a given word
     *
     * @param guess
     */
    public void updateGrid(String guess) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j].equals(SPACE)) {
                grid[i][j] = parseGuessAddColor(guess, j);
            }
        }
        i++;
    }

    /**
     * Draws the grid and prints to the console
     */
    public void drawGrid() {
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            System.out.print("|");
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + "|");
            }
            System.out.println();
            System.out.println("-----------");
        }
    }

    /**
     * Returns a letter of a word at a given index with a color depending on if it matches the character of word
     *
     * @param guess
     * @param index
     * @return a single letter at index within word
     */
    private String parseGuessAddColor(String guess, int index) {
        if (guess.substring(index, index + 1).equals(Word.getWord().substring(index, index + 1))) {
            return "\u001b[32m" + guess.substring(index, index + 1) + "\u001b[0m"; // colors the letter green
        }
        else if (Word.getWord().contains(guess.substring(index, index + 1))) {
            return "\u001b[33m" + guess.substring(index, index + 1) + "\u001b[0m"; // colors the letter yellow
        }
        else {
            return guess.substring(index, index + 1); // no color
        }
    }

}