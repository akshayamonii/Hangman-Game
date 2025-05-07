import java.util.Scanner;

public class HangmanGame {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Hangman!");

        boolean playAgain = true;
        while (playAgain) {
            String difficulty = chooseDifficulty();
            String word = WordBank.getRandomWord(difficulty);
            GameSession session = new GameSession(word);
            session.play();
            playAgain = askReplay();
        }

        System.out.println("Thanks for playing!");
    }

    private static String chooseDifficulty() {
        System.out.print("Choose difficulty (easy, medium, hard): ");
        String difficulty;
        while (true) {
            difficulty = scanner.nextLine().toLowerCase();
            if (WordBank.isValidDifficulty(difficulty)) {
                return difficulty;
            }
            System.out.print("Invalid input. Please choose again: ");
        }
    }

    private static boolean askReplay() {
        System.out.print("Do you want to play again? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.startsWith("y");
    }
}

