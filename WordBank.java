import java.util.*;

public class WordBank {
    private static final Map<String, List<String>> wordBank = new HashMap<>();

    static {
        wordBank.put("easy", Arrays.asList("cones", "dance", "plane", "chair", "swipe", "scent", "plush", "shirt", "alarm", "chess", "smart", "laser", "erase"));
        wordBank.put("medium", Arrays.asList("experts", "castle", "banana", "hundred", "perfect", "thirsty", "random", "ozone", "matrix", "robotic", "cologne"));
        wordBank.put("hard", Arrays.asList("transistor", "syndrome", "mechanism", "mnemonic", "technology", "certificate", "operation", "crystaline", "electromagnetic"));
    }

    public static String getRandomWord(String difficulty) {
        List<String> words = wordBank.get(difficulty);
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public static boolean isValidDifficulty(String difficulty) {
        return wordBank.containsKey(difficulty.toLowerCase());
    }
}

