import java.util.Scanner;

public class Hangman {
    private static final String[] WORDS = {"java", "programming", "hangman", "challenge", "developer"};
    private static final int MAX_TRIES = 6;
    private String wordToGuess;
    private StringBuilder currentGuess;
    private int tries;

    public Hangman() {
        // Randomly select a word from the list
        wordToGuess = WORDS[(int) (Math.random() * WORDS.length)];
        currentGuess = new StringBuilder("_".repeat(wordToGuess.length()));
        tries = 0;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (tries < MAX_TRIES) {
            System.out.println("Current guess: " + currentGuess);
            System.out.println("Tries left: " + (MAX_TRIES - tries));
            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().charAt(0);

            if (wordToGuess.indexOf(guess) >= 0) {
                updateCurrentGuess(guess);
                if (currentGuess.toString().equals(wordToGuess)) {
                    System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                    return;
                }
            } else {
                tries++;
                System.out.println("Incorrect guess. Try again.");
            }
        }
        System.out.println("Game over! The word was: " + wordToGuess);
    }

    private void updateCurrentGuess(char guess) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                currentGuess.setCharAt(i, guess);
            }
        }
    }

    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.play();
    }
}
