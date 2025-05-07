import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameSession {
    private static final int MAX_ATTEMPTS = 6;
    private String word;
    private char[] displayWord;
    private Set<Character> guessedLetters;
    private int wrongAttempts;
    private Scanner scanner;

    public GameSession(String word) {
        this.word = word;
        this.displayWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            displayWord[i] = '_';
        }
        this.guessedLetters = new HashSet<>();
        this.wrongAttempts = 0;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        while (wrongAttempts < MAX_ATTEMPTS) {
            showGameStatus();
            char guess = getUserGuess();
            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter.");
                continue;
            }

            guessedLetters.add(guess);
            if (word.indexOf(guess) >= 0) {
                revealLetter(guess);
                if (new String(displayWord).equals(word)) {
                    System.out.println("\nYou won! The word was: " + word);
                    return;
                }
            } else {
                wrongAttempts++;
                System.out.println("Incorrect guess.");
            }
        }
        System.out.println("\nGame over! The word was: " + word);
    }

    private void showGameStatus() {
        System.out.println("\nWord: " + new String(displayWord));
        System.out.println("Wrong attempts left: " + (MAX_ATTEMPTS - wrongAttempts));
    }

    private char getUserGuess() {
        System.out.print("Guess a letter: ");
        String input = scanner.nextLine().toLowerCase();
        while (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.print("Invalid input. Guess a single letter: ");
            input = scanner.nextLine().toLowerCase();
        }
        return input.charAt(0);
    }

    private void revealLetter(char guess) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                displayWord[i] = guess;
            }
        }
    }
}

